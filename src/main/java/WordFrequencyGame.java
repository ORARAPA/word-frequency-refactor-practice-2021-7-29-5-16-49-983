import java.util.*;

public class WordFrequencyGame {

    public static final String BlANK_SPACE = "\\s+";

    public String getResult(String sentence){


        if (sentence.split(BlANK_SPACE).length==1) {
            return sentence + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                String[] words = sentence.split(BlANK_SPACE);

                List<WordsInfo> wordsInfoList = new ArrayList<>();
                for (String word : words) {
                    WordsInfo wordsInfo = new WordsInfo(word, 1);
                    wordsInfoList.add(wordsInfo);
                }

                //get the map for the next step of sizing the same word
                Map<String, List<WordsInfo>> map =getListMap(wordsInfoList);

                List<WordsInfo> distinctWordsInfo = new ArrayList<>();
                for (Map.Entry<String, List<WordsInfo>> entry : map.entrySet()){
                    WordsInfo wordsInfo = new WordsInfo(entry.getKey(), entry.getValue().size());
                    distinctWordsInfo.add(wordsInfo);
                }
                wordsInfoList = distinctWordsInfo;

                wordsInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordsInfo wordInfo : wordsInfoList) {
                    String s = wordInfo.getValue() + " " +wordInfo.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }


    private Map<String,List<WordsInfo>> getListMap(List<WordsInfo> wordsInfoList) {
        Map<String, List<WordsInfo>> map = new HashMap<>();
        for (WordsInfo wordsInfo : wordsInfoList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordsInfo.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(wordsInfo);
                map.put(wordsInfo.getValue(), arr);
            }

            else {
                map.get(wordsInfo.getValue()).add(wordsInfo);
            }
        }


        return map;
    }


}
