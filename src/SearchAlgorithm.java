import java.util.*;

public class SearchAlgorithm {
    private MatchData algorithm;

    public SearchAlgorithm(MatchData algorithm) {
        this.algorithm = algorithm;
    }

    public List<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        return algorithm.search(invertedIndex, people);
    }
}

// ANY - the program should print lines containing at least one word from the query.

// NONE - the program should print lines that do not contain words from the query at all.

