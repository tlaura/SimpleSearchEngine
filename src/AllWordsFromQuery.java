import java.util.*;

// ALL - the program should print lines containing all words from the query.
public class AllWordsFromQuery implements MatchData {
    private String searchTerm;

    public AllWordsFromQuery(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public Set<String> search(Map<String, List<Integer>> invertedIndex, List<String> people) {
        searchTerm = searchTerm.toLowerCase();
        Set<String> result = new HashSet<>();
        String[] searchTermArray = searchTerm.split("\\s+");
        for(Integer line : invertedIndex.get(searchTermArray[0])) {
            result.add(people.get(line));
        }
        if(searchTermArray.length > 1){
            List<String> toBeRemoved = new ArrayList<>();
            for (int i = 1; i < searchTermArray.length; i++) {
                for(String r : result){
                    if(!r.toLowerCase().contains(searchTermArray[i])) {
                        toBeRemoved.add(r);
                    }
                }
            }
            if(!toBeRemoved.isEmpty()){
                result.removeAll(toBeRemoved);
            }
        }
        return result;
    }
}
