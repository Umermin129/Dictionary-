import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class DictionaryTree {
    static DictionaryNode root;
    String file="C:\\Users\\Lenovo\\IdeaProjects\\DS_Assignment_3\\Dictionary.txt";
    public void start(DictionaryNode obj)
    {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //  String [] arr = data.split(" ");
                readData(obj,data);

                //  System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred!");
        }
    }
    public void readData(DictionaryNode obj1,String data)
    {
        Scanner lineScanner = new Scanner(data);
        lineScanner.useDelimiter("=");
        while (lineScanner.hasNext()) {
            DictionaryNode obj = new DictionaryNode();
            String word=lineScanner.next();
            obj.setWord(word);
            String meaning=lineScanner.next();
            obj.setMeaning(meaning);
            obj.setData(obj);
            root=insert(root,obj);
        }
        lineScanner.close();
    }
    public void writeData(DictionaryNode node)
    {
        try {
            FileWriter myWriter = new FileWriter(file, false);
            if(node!=null) {
                myWriter.write(node.getWord() + "=");
                myWriter.write(node.getMeaning());
                writeData(node.left);
                writeData(node.right);
                }
                 myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    DictionaryNode insert(DictionaryNode node, DictionaryNode data)
    {

        if (node == null)
            return (new DictionaryNode(data.getWord(),data.getMeaning()));
            if (data.getWord().compareTo(node.getWord()) < 0)
                node.left = insert(node.left, data);
            else if (data.getWord().compareTo(node.getWord()) > 0)
                node.right = insert(node.right, data);
            else
                return node;

            node.height = 1 + max(height(node.left),
                    height(node.right));


            int balance = getBalance(node);


            if (balance > 1 && data.getWord().compareTo(node.getWord()) < 0)
                return rightRotate(node);


            if (balance < -1 && data.getWord().compareTo(node.getWord()) > 0)
                return leftRotate(node);


            if (balance > 1 && data.getWord().compareTo(node.getWord()) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }


            if (balance < -1 && data.getWord().compareTo(node.getWord()) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        return node;
    }
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    int height(DictionaryNode N)
    {
        if (N == null)
            return 0;
        return N.height;
    }
    DictionaryNode rightRotate(DictionaryNode y)
    {
        DictionaryNode x = y.left;
        DictionaryNode T2 = x.right;


        x.right = y;
        y.left = T2;


        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }
    DictionaryNode leftRotate(DictionaryNode x)
    {
        DictionaryNode y = x.right;
        DictionaryNode T2 = y.left;


        y.left = x;
        x.right = T2;


        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;


        return y;
    }
    int getBalance(DictionaryNode N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    DictionaryNode minValueNode(DictionaryNode node)
    {
        DictionaryNode current = node;


        while (current.left != null)
            current = current.left;

        return current;
    }
    DictionaryNode deleteNode(DictionaryNode root, String word)
    {

        if (root == null)
            return root;


        if ( word.compareTo(root.getWord())<0)
            root.left = deleteNode(root.left, word);


        else if (word.compareTo(root.getWord())>0)
            root.right = deleteNode(root.right, word);

        else
        {
            if ((root .left == null) || (root.right == null))
            {
                DictionaryNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {
                DictionaryNode temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.getWord());
            }
        }


        if (root == null)
            return root;


        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);


        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);


        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }


        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);


        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void preOrdersearch(DictionaryNode node,String word,boolean wordflag)
    {
        if (node != null)
        {
            if(node.getWord().compareTo(word)==0)
            {
                System.out.print("Meaning of "+node.getWord()+" is: "+node.getMeaning());
                wordflag=true;
                }
            preOrdersearch(node.left,word,wordflag);
            preOrdersearch(node.right,word,wordflag);
        }
    }
    void preOrderdisplay(DictionaryNode node)
    {
        if (node != null)
        {
                System.out.println("Meaning of "+node.getWord()+" is: "+node.getMeaning());
            preOrderdisplay(node.left);
            preOrderdisplay(node.right);
        }
    }
}
