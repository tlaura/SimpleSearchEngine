import java.util.*;

public class SearchAlgorithm {
    private MatchData algorithm;
    private List<String> people = new ArrayList<>();
    //    maps words to lines that contains them
    private Map<String, List<Integer>> invertedIndex = new HashMap<>();

    public void setAlgorithm(MatchData algorithm) {
        this.algorithm = algorithm;
    }

    public void addPeople(String s) {
        this.people.add(s);
    }

    public List<String> getPeople() {
        return new ArrayList<>(people);
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return new HashMap<>(invertedIndex);
    }

    public void printResult() {
        algorithm.search(invertedIndex);
    }

    public void addInvertedIndex(Scanner scan) {
        int lineNumber = 0;
        while(scan.hasNextLine()) {
            String l = scan.nextLine();
            addPeople(l);
            String[] wordsPerLine = l.split("\\s+");
            for (int i = 0; i < wordsPerLine.length; i++) {
                wordsPerLine[i] = wordsPerLine[i].toLowerCase();
                if(!invertedIndex.containsKey(wordsPerLine[i])){
                    invertedIndex.put(wordsPerLine[i], new ArrayList<>());
                    invertedIndex.get(wordsPerLine[i]).add(lineNumber);
                } else {
                    invertedIndex.get(wordsPerLine[i]).add(lineNumber);
                }
            }
            lineNumber++;
        }
    }
}

// ANY - the program should print lines containing at least one word from the query.

// NONE - the program should print lines that do not contain words from the query at all.

