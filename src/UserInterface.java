import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    SearchAlgorithm search = new SearchAlgorithm();

    public void addPeopleAndIndexInfo(String line) throws FileNotFoundException {
        File file = new File("/Users/tundelaura/Desktop/java/searchEngine/" + line);
        Scanner scan = new Scanner(file);
        search.addInvertedIndex(scan);
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
        if(!search.getPeople().isEmpty()){
            for(String s : search.getPeople()) {
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
                System.out.println(search.getPeople().get(line));
            }
        } else {
            System.out.println("Information not found.");
        }
        System.out.println();
    }
}
