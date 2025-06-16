import java.io.*;
import java.util.*;

public class FlashCardManager {
    private List<Flashcard> cards = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void papers() {
        System.out.println("Enter Question:");
        String question = input.nextLine();
        System.out.println("Enter Answer:");
        String answer = input.nextLine();
        cards.add(new Flashcard(question, answer));
        System.out.println("Flashcard added.\n");
    }

    public void reviews() {
        Collections.shuffle(cards);
        for (Flashcard card : cards) {
            System.out.println("Q: " + card.getQuestion());
            System.out.print("Your Answer: ");
            String userAnswer = input.nextLine();
            if (userAnswer.equalsIgnoreCase(card.getAnswer())) {
                System.out.println("NOICE u did it bb\n");
                card.markCorrect();
            } else {
                System.out.println("Ehh you’re wrong b*tch, the correct answer is: " + card.getAnswer() + "\n");
                card.markWrong();
            }
        }
    }

    public void stats() {
        for (Flashcard card : cards) {
            System.out.println("\"" + card.getQuestion() + "\" → " +
                    card.getCorrectCount() + " correct / " + card.getWrongCount() + " wrong");
        }
    }

    public void saveFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Flashcard card : cards) {
                writer.println(card.getQuestion() + "," +
                        card.getAnswer() + "," +
                        card.getCorrectCount() + "," +
                        card.getWrongCount());
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
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    Flashcard card = new Flashcard(parts[0], parts[1]);
                    card.setCorrectCount(Integer.parseInt(parts[2]));
                    card.setWrongCount(Integer.parseInt(parts[3]));
                    cards.add(card);
                }
            }
        }
    }
}
