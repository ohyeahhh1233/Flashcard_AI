import java.io.*;
import java.util.*;

public class FlashCardManager {
    private List<Flashcards> cards = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    private void papers(){
        System.out.println("Enter Question:");
        String knowledge = input.nextLine();
        System.out.println("Enter Answer:");
        String WhatYaGot = input.nextLine();
        cards.add(new Flashcard(knowledge, WhatYaGot));
        System.out.println("Flashcard added. ((\n");
    }
    private void reviews(){
        Collection.shuffle(cards);
        for(Flashcards card:cards){
            System.out.println("Q:" + card.getQuestion());
            System.out.print("Your Answer: ");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase(card.getAnswer())){
                System.out.println("NOICE u did it bb");
                card.markCorrect();
            }
            else{
                System.out.println("Ehh Your wrong b*tch, the correct answer is: " + card.getAnswer() + "\n");
                card.markWrong();
            }
        }
    }
    private void stats(){
        for (Flashcard card : cards){
            System.out.println("\"" + card.getQuestion() "\" > " + card.YourRight() + " correct / " + card.YourWrong + " wrong");
        }
    }
    public void SaveFile(Strong filename) throws IOException{
        
    }
}

