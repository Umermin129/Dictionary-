public class DictionaryNode {
    DictionaryNode left,right,data;
    private String word,meaning;
    int height;
    DictionaryNode()
    {
    }
    DictionaryNode(String word,String meaning)
    {
        this.word=word;
        this.meaning=meaning;
        this.left=null;
        this.right=null;
        this.height=-1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public DictionaryNode getData() {
        return data;
    }

    public void setData(DictionaryNode data) {
        this.data = data;
    }
}
