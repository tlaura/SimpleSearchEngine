import java.io.FileNotFoundException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        UserInterface ui = new UserInterface();
        if(args.length > 0 && args[0].equals("--data")) {
            ui.addPeopleAndIndexInfo(args[1]);
//            NoWordsFromQuery no = new NoWordsFromQuery("djo@gmail.com ERICK");
//            Set<String> set = no.search(ui.invertedIndex, ui.people);
//            for(String e : set) {
//                System.out.println(e);
//            }
        }
        ui.readInput();
    }
}
