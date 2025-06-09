import java.io.IOException;
import java.util.Scanner;

public class Flashcard {
    public static void main(String[] args){
        FlashCardManager manager = new FlashCardManager();
        Scanner input = new Scanner(System.in);

        try{
            manager.LoadFile("flashcards.txt");
        } catch (IOException e){
            System.out.println("Could not load flashcards!");
        }
        while(true){
            System.out.println("Welcome to my Flashing");
            System.out.println("1. Add ur flash card");
            System.out.println("2. Review");
            System.out.println("3. view how u did");
            System.out.println("4. save and leave");
            System.out.print("Pick ur options: ");

            String choice = input.nextLine();
            if(choice.equals("1")){
                manager.addCard();
            } else if (choice.equals("2")) {
                manager.review();
            } else if (choice.equals("3")) {
                manager.viewStats();
            } else if (choice.equals("4")) {
                try{
                    manager.SaveFile("flashcard.txt");
                }catch (IOException e){
                    System.out.println("we cant save your flashcards");
                }
                System.out.println("bye bye");
                break;
            }
        }
    }
}
