public class WordsInfo {
    private String value;
    private int count;

    public WordsInfo(String w, int i){
        this.value =w;
        this.count =i;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
