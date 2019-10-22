import java.util.List;
import java.util.Map;

public interface MatchData {
    List<String> search(Map<String, List<Integer>> invertedIndex, List<String> people);
}
