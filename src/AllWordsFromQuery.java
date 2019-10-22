import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// ALL - the program should print lines containing all words from the query.
public class AllWordsFromQuery implements MatchData {
    private String searchTerm;

    public AllWordsFromQuery(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public List<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        searchTerm = searchTerm.toLowerCase();
        List<String> result = new ArrayList<>();
        if (invertedIndex.containsKey(searchTerm)) {
            for (Integer line : invertedIndex.get(searchTerm)) {
                result.add(people.get(line));
            }
        }
        return result;
    }
}
