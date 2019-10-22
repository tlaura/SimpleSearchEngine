import java.util.List;
import java.util.Map;

public interface MatchData {
    void search(Map<String, List<Integer>> invertedIndex);
}
