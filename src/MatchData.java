import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MatchData {
    Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people);
}
