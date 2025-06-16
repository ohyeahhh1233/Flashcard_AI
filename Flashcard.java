public class Flashcard {
    private String question;
    private String answer;
    private int correctCount;
    private int wrongCount;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.correctCount = 0;
        this.wrongCount = 0;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void markCorrect() {
        correctCount++;
    }

    public void markWrong() {
        wrongCount++;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setCorrectCount(int count) {
        this.correctCount = count;
    }

    public void setWrongCount(int count) {
        this.wrongCount = count;
    }

    @Override
    public String toString() {
        return question + "," + answer + "," + correctCount + "," + wrongCount;
    }
}
