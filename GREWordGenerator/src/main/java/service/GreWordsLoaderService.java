package service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class GreWordsLoaderService {

    public static void main(String [] args) throws IOException {
        GreWordsLoaderService greWordsLoaderService = new GreWordsLoaderService();
        TreeMap<Integer, Map<String, List<String>>> greWordsCorrectFrequencyTreeMap =
                new TreeMap<>(new CorrectAnswerDescendingComparator());
        greWordsLoaderService.loadGreWordsIntoTreeSet();
        // greWordsLoaderService.getTopIncorrectWordsByIncorrectCount();
    }

    static class CorrectAnswerDescendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

    private void loadGreWordsIntoTreeSet() throws IOException {
        // Step 1: Parse GRE words and meaning from CSV file
        Reader reader =new FileReader("/Users//hamsalekhavenkatesh//Desktop//git//GREWordGenerator//src/main//resources//GreVocabList.csv");
        String[] HEADERS = {"Words", "Meaning"};
        Iterable <CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS).withFirstRecordAsHeader().parse(reader);

        String words;
        // HashMap<String, List<String>>greWordsAndTheirMeaningHashMap = new HashMap<>();
        int i = 0;
        List<String> meaning = null;
        for(CSVRecord csvRecord : records) {
            words = csvRecord.get("Words");
            meaning = Collections.singletonList(csvRecord.get("Meaning"));

            System.out.println(words + "----" + meaning);
//            // Step 2: Load the words into hash set
//            greWordsAndTheirMeaningHashMap.clear();
//            greWordsAndTheirMeaningHashMap.put(words, meaning);

            greWordsCorrectFrequencyTreeMap.put(++i, Collections.singletonMap(words, Collections.singletonList(csvRecord.get("Meaning"))));
        }
        System.out.println("Size of Tree Map " + greWordsCorrectFrequencyTreeMap.size());
        printTreeMap();
    }
    private void printTreeMap() {
        for(Map.Entry<Integer, Map<String, List<String>>> entry: greWordsCorrectFrequencyTreeMap.entrySet()) {
            System.out.println("KEY = " + entry.getKey() + " VALUE = " + entry.getValue().toString());
        }
    }

    public void  getTopIncorrectWordsByIncorrectCount() {
        for (Map.Entry<Integer, Map<String, List<String>>> entry : greWordsCorrectFrequencyTreeMap.entrySet()) {
            Map<String, List<String>> wordsAndItsMeaning = entry.getValue();
            for (Map.Entry<String, List<String>> wordsMap : wordsAndItsMeaning.entrySet()) {
                String word = wordsMap.getKey();
                List<String> meaningList = wordsMap.getValue();
                System.out.println(word + "----->" + meaningList.toString());
            }
        }
    }

    public void updateIncorrectWordCount(String word) {
        for (Map.Entry<Integer, Map<String, List<String>>> entry : greWordsCorrectFrequencyTreeMap.entrySet()) {
            Map<String, List<String>> wordsAndItsMeaning = entry.getValue();
            for (Map.Entry<String, List<String>> wordsMap : wordsAndItsMeaning.entrySet()) {
                String exisitngWord = wordsMap.getKey();
                List<String> meaningList = wordsMap.getValue();
                System.out.println(word + "----->" + meaningList.toString());
            }
        }

    }

}
