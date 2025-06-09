import java.io.*;
import java.util.*;

public class FlashCardManager {
    private List<Flashcards> cards = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void papers() {
        System.out.println("Enter Question:");
        String knowledge = input.nextLine();
        System.out.println("Enter Answer:");
        String WhatYaGot = input.nextLine();
        cards.add(new Flashcards(knowledge, WhatYaGot));
        System.out.println("Flashcard added.\n");
    }

    public void reviews() {
        Collections.shuffle(cards);
        for (Flashcards card : cards) {
            System.out.println("Q: " + card.getQuestion());
            System.out.print("Your Answer: ");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase(card.getAnswer())) {
                System.out.println("NOICE u did it bb\n");
                card.markCorrect();
            } else {
                System.out.println("Ehh you’re wrong b*tch, the correct answer is: " + card.getAnswer() + "\n");
                card.markWrong();
            }
        }
    }

    public void stats() {
        for (Flashcards card : cards) {
            System.out.println("\"" + card.getQuestion() + "\" → " +
                    card.getCorrectCount() + " correct / " + card.getWrongCount() + " wrong");
        }
    }

    public void saveFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Flashcards card : cards) {
                writer.println(card);
            }
        }
    }

    public void loadFile(String filename) throws IOException {
        cards.clear();
        File file = new File(filename);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Flashcards card = new Flashcards(parts[0], parts[1]);
                cards.add(card);
            }
        }
    }
}
