public class FlashCardApp {
    private String questions;
    private String answers;
    private int yippie;
    private int boohoo;

    public FlashCardApp(String questions, String answers){
        this.questions = questions;
        this.answers = answers;
        this.yippie = 0;
        this.boohoo = 0;
    }
    public String getQuestion(){
        return questions;
    }
    public String getAnswer(){
        return answers;
    }
    private void YourRight(){
        yippie++;
    }
    private void YourWrong(){
        boohoo++;
    }
    public int getRight(){
        return yippie;
    }
    public int getWrong(){
        return boohoo;
    }
    
}
