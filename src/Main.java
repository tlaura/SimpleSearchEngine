import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    List<String> people = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
//    maps words to lines that contains them
    Map<String, List<Integer>> invertedIndex = new HashMap<>();

    public void addPeople() {
        System.out.println("Enter number of people to add:");
        int numOfLines = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter people's information:");
        for (int i = 0; i < numOfLines; i++) {
            people.add(scanner.nextLine());
        }
    }

    private void addPeopleAndIndexInfo(String line) throws FileNotFoundException {
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

    private static void menu() {
        System.out.println("=== Menu ===\n" +
                "1. Search information.\n" +
                "2. Print all data.\n" +
                "0. Exit.");
    }

    public void readInput(){
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
                    System.out.println("Enter a name or email to search all suitable people.");
                    String search = scanner.nextLine();
                    searchPeople(search);
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

    private void printPeople() {
        System.out.println("=== List of people ===");
        if(!people.isEmpty()){
            for(String s : people) {
                System.out.println(s);
            }
        }
        System.out.println();
    }

//    optimize with inverted index
    private void searchPeople(String s) {
        s = s.toLowerCase();
        if(invertedIndex.containsKey(s)) {
            System.out.println("Search result:");
            for(Integer line : invertedIndex.get(s)) {
                System.out.println(people.get(line));
            }
        } else {
            System.out.println("Information not found.");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        if(args.length > 0 && args[0].equals("--data")) {
            main.addPeopleAndIndexInfo(args[1]);
        } else {
            main.addPeople();
        }
        main.readInput();

    }
}
