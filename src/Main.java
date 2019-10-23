import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        UserInterface ui = new UserInterface();
        if(args.length > 0 && args[0].equals("--data")) {
            ui.addPeopleAndIndexInfo(args[1]);
//            for(String i : ui.people){
//                System.out.println(i);
//            }
//            for(String i : ui.invertedIndex.keySet()){
//                System.out.print(" " + i + " -> " + ui.invertedIndex.get(i));
//            }
//            System.out.println();
        }
        ui.readInput();
    }
}
