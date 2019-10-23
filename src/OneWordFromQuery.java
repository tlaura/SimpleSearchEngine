import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// ANY - the program should print lines containing at least one word from the query.
public class OneWordFromQuery implements MatchData {
    private String searchTerm;

    public OneWordFromQuery(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        String[] searchTermArray = searchTerm.split("\\s+");
        Set<String> result = new HashSet<>();
        for(String s: searchTermArray) {
            if(invertedIndex.containsKey(s)){
                for (Integer line : invertedIndex.get(s)) {
                    result.add(people.get(line));
                }
            }
        }
        return result;
    }
}
