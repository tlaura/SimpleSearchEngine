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
    public void search(Map<String, List<Integer>> invertedIndex) {
        searchTerm = searchTerm.toLowerCase();
        List<String> res = new ArrayList<>();
        if (invertedIndex.containsKey(searchTerm)) {
            for (Integer line : invertedIndex.get(searchTerm)) {
                System.out.println(people.get(line));
            }
        } else {
            System.out.println("Information not found.");
        }
        System.out.println();
    }
}
