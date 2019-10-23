import java.util.List;
import java.util.Map;
import java.util.Set;

public class OneWordFromQuery implements MatchData {
    private String query;

    public OneWordFromQuery(String query) {
        this.query = query;
    }

    @Override
    public Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        return null;
    }
}
