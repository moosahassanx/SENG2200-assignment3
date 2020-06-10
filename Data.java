public class Data {
    private double timeEntered;
    private double timeLeft;
    private String stage;

    // default constructor
    public Data(){
        timeEntered = 0;
        timeLeft = 0;
        stage = "";
    }

    // main constructor
    public Data(String s, double tE, double tL){
        timeEntered = tE;
        timeLeft = tL;
        stage = s;
    }
}