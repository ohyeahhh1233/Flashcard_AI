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

        }
    }
}

