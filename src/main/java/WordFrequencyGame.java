import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String BlANK_SPACE = "\\s+";
    List<WordsInfo> wordsInfoList;

    public String getResult(String sentence){


        if (sentence.split(BlANK_SPACE).length==1) {
            return sentence + " 1";
        } else {
            try {
                calculateWordFrequency(sentence);
                sortWordsInfoList(wordsInfoList);
                return getStringOutput(wordsInfoList);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private String getStringOutput(List<WordsInfo> wordsInfoList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordsInfo wordInfo : wordsInfoList) {
            String s = wordInfo.getValue() + " " +wordInfo.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private void sortWordsInfoList(List<WordsInfo> wordsInfoList) {
        wordsInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
    }

    private void calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(BlANK_SPACE));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());

        List<WordsInfo> wordsInfos = new ArrayList<>();
        distinctWords.forEach(distinctWord ->{
            int count = (int) words.stream().filter(word -> word.equals(distinctWord)).count();
            WordsInfo wordsInfo = new WordsInfo(distinctWord,count);
            wordsInfos.add(wordsInfo);
        });
         this.wordsInfoList = wordsInfos;
    }


}
