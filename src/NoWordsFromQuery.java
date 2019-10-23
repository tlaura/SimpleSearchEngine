import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// NONE - the program should print lines that do not contain words from the query at all.
public class NoWordsFromQuery implements MatchData {
    private String searchTerm;

    public NoWordsFromQuery(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        String[] searchTermArray = searchTerm.split("\\s+");
        Set<String> result = new HashSet<>(people);
        for(String s: searchTermArray) {
            for(Integer i: invertedIndex.get(s)) {
                result.remove(people.get(i));
            }
        }

        for(String e: result) {
            System.out.println(e);
        }
        return result;
    }
}
