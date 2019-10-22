import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<String> people = new ArrayList<>();

//    public void addPeople() {
//        System.out.println("Enter number of people to add:");
//        int numOfLines = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter people's information:");
//        for (int i = 0; i < numOfLines; i++) {
//            people.add(scanner.nextLine());
//        }
//    }

    public void addPeople(String line) throws FileNotFoundException {
        File file = new File("/Users/tundelaura/Desktop/java/searchEngine/" + line);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            people.add(scan.nextLine());
        }
    }

    private static void menu() {
        System.out.println("=== Menu ===\n" +
                "1. Search information.\n" +
                "2. Print all data.\n" +
                "0. Exit.");
    }

    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            menu();
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    System.out.println("Bye!");
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
    }

    private void searchPeople(String s) {
        List<String> l = new ArrayList<>();
        for(String line: people){
            if(line.contains(s.toLowerCase())){
                l.add(line);
            }
        }
        if(l.isEmpty()){
            System.out.println("Information not found");
        } else {
            for(String found: l){
                System.out.println(found);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        if(args[0].equals("--data")) {
            main.addPeople(args[1]);
        }
        main.readInput();
    }
}
