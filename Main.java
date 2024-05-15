import java.util.Scanner;

public class Main {

    static boolean wordflag;
    public static void main(String[] args) {
        DictionaryTree dictionaryObj = new DictionaryTree();
        Scanner input = new Scanner(System.in);
//        System.out.println("Entre the Word 1:");
//        String word1=input.next();
//        System.out.println("Entre the meaning:");
//        String meaning1=input.next();
//        System.out.println("Entre the  word 2:");
//        String word2=input.next();
//        System.out.println("Entre the meaning");
//        String meaning2=input.next();
//        String word3="3";
//        String meaning3="ahmed";
//        DictionaryNode tree=new DictionaryNode();
//        DictionaryNode data1=new DictionaryNode(word1,meaning1);
//        data1.setData(data1);
//        dictionaryObj.root=dictionaryObj.insert(dictionaryObj.root,data1);
//        DictionaryNode data2=new DictionaryNode(word2,meaning2);
//        data2.setData(data2);
//        dictionaryObj.root=dictionaryObj.insert(dictionaryObj.root,data2);
//        DictionaryNode data3=new DictionaryNode(word3,meaning3);
//        data3.setData(data3);
//        dictionaryObj.root=dictionaryObj.insert(dictionaryObj.root,data3);
//        System.out.println("Entre the word of which you want to see the meaning");
//        String wordToFind=input.next();
//        boolean wordflag=false;
//        dictionaryObj.preOrdersearch(dictionaryObj.root, wordToFind, wordflag);
//        if(!wordflag)
//        {
//            System.out.println("No such data found");
//        }
//        dictionaryObj.root=dictionaryObj.deleteNode(dictionaryObj.root,"1");
        Boolean flag=false;
        dictionaryObj.start(dictionaryObj.root);
        while (!flag) {
            wordflag = false;
            System.out.println("*****Welcome to Umer Dictionary*****");
            System.out.println("Press 1: Insert a word with meaning :");
            System.out.println("Press 2: Delete a word :");
            System.out.println("Press 3: Search a word :");
            System.out.println("Press 4: Display all : ");
            System.out.println("Press 5 : Exit");
            String option = input.next();
            switch (option) {
                case "1":
                    System.out.println("Entre the Word :");
                    String word1 = input.next();
                    System.out.println("Entre the meaning:");
                    String meaning1 = input.next();
                    DictionaryNode data1 = new DictionaryNode(word1, meaning1);
                    data1.setData(data1);
                    DictionaryTree.root = dictionaryObj.insert(DictionaryTree.root, data1);
                    System.out.println("This is the new Data:");
                    dictionaryObj.preOrderdisplay(DictionaryTree.root);
                    break;
                case "2":
                    dictionaryObj.preOrderdisplay(DictionaryTree.root);
                    System.out.println("Entre the word you want to delete:");
                    String name = input.next();
                    DictionaryTree.root = dictionaryObj.deleteNode(DictionaryTree.root, name);
                    System.out.println("Successfully Deleted");
                    break;
                case "3":
                    System.out.println("Entre the word of which you want to see the meaning");
                    String wordToFind = input.next();
                    dictionaryObj.preOrdersearch(dictionaryObj.root, wordToFind, wordflag);
                    break;
                case "4":
                    dictionaryObj.preOrderdisplay(dictionaryObj.root);
                    break;
                case "5":
                    flag=true;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
    }
}
