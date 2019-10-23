import java.util.*;

public class SearchAlgorithm {
    private MatchData algorithm;

    public SearchAlgorithm(MatchData algorithm) {
        this.algorithm = algorithm;
    }

    public Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        return algorithm.search(invertedIndex, people);
    }
}

