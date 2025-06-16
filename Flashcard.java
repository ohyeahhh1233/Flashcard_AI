import java.io.IOException;
import java.util.Scanner;

public class FlashcardApp {

    public static void main(String[] args) {
        FlashCardManager manager = new FlashCardManager();

        try {
            manager.loadFile("flashcards.txt");
        } catch (IOException e) {
            System.out.println("Could not load flashcards, starting fresh.");
        }

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                        ========= FLASHCARDS =========
                        1) Add a flashcard
                        2) Review
                        3) View stats
                        4) Save & quit
                        ==============================""");
                System.out.print("Pick an option: ");

                switch (input.nextLine().trim()) {
                    case "1" -> manager.papers();
                    case "2" -> manager.reviews();
                    case "3" -> manager.stats();
                    case "4" -> {
                        try {
                            manager.saveFile("flashcards.txt");
                        } catch (IOException e) {
                            System.out.println("Could not save flashcards!");
                        }
                        System.out.println("Bye-bye");
                        return;
                    }
                    default -> System.out.println("Invalid choice, try again.");
                }
            }
        }
    }
}
