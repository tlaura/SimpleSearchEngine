import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private List<String> people = new ArrayList<>();
    //    maps words to lines that contains them
    private Map<String, List<Integer>> invertedIndex = new HashMap<>();


    public void addPeopleAndIndexInfo(String line) throws FileNotFoundException {
        File file = new File("/Users/tundelaura/Desktop/java/searchEngine/" + line);
        Scanner scan = new Scanner(file);
        int lineNumber = 0;
        while(scan.hasNextLine()) {
            String l = scan.nextLine();
            people.add(l);
            String[] wordsPerLine = l.split("\\s+");
            for (int i = 0; i < wordsPerLine.length; i++) {
                wordsPerLine[i] = wordsPerLine[i].toLowerCase();
                if(!invertedIndex.containsKey(wordsPerLine[i])){
                    invertedIndex.put(wordsPerLine[i], new ArrayList<>());
                    invertedIndex.get(wordsPerLine[i]).add(lineNumber);
                } else {
                    invertedIndex.get(wordsPerLine[i]).add(lineNumber);
                }
            }
            lineNumber++;
        }
    }

    private static void printSearchResult(Set<String> result){
        if(result != null) {
            System.out.println("Search results:");
            for(String s: result) {
                System.out.println(s);
            }
        } else {
            System.out.println("Information not found.");
        }
    }

    public static MatchData createData(String matchingStrategy, String query) {
        switch (matchingStrategy) {
            case "ALL":
                return new AllWordsFromQuery(query);
            case "ANY":
                return new OneWordFromQuery(query);
            case "NONE":
                return new NoWordsFromQuery(query);
            default:
                throw new IllegalArgumentException("Unknown algorithm type " + matchingStrategy);
        }
    }

    public void readInput() {
        boolean exit = false;
        while(!exit) {
            menu();
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    System.out.println("Bye!\n");
                    exit = true;
                    break;
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE:");
                    String matchingStrategy = scanner.nextLine();
                    System.out.println("Enter a name or email to search all suitable people:");
                    String query = scanner.nextLine().toLowerCase();
//                    strategy pattern:
                    MatchData alg = createData(matchingStrategy, query);
                    SearchAlgorithm searchAlgorithm = new SearchAlgorithm(alg);
                    Set<String> result = searchAlgorithm.search(invertedIndex, people);

                    printSearchResult(result);
                    break;
                case 2:
                    printPeople();
                    break;
                default:
                    System.out.println("Incorrect input. Option doesn't exist.");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("=== Menu ===\n" +
                "1. Search information.\n" +
                "2. Print all data.\n" +
                "0. Exit.");
    }

    private void printPeople() {
        System.out.println("=== List of people ===");
        if(!people.isEmpty()){
            for(String s : people) {
                System.out.println(s);
            }
        }
        System.out.println();
    }
}
