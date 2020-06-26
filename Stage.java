import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Stage {
    private double processingTime;
    private String name;
    private InterstageStorage nextQueue;

    private ArrayList<Stage> nextStage;
    private ArrayList<Stage> prevStage;

    private double starveTime;
    private double blockTime;
    private double workLoad;

    private int aBrands;
    private int bBrands;

    private int S3atoS5a;
    private int S3atoS5b;
    private int S3btoS5a;
    private int S3btoS5b;

    private int currentState;

    // main constructor
    public Stage(String n){
        processingTime = 0;
        nextStage = new ArrayList<Stage>();
        prevStage = new ArrayList<Stage>();

        aBrands = 0;
        bBrands = 0;

        S3atoS5a = 0;
        S3atoS5b = 0;
        S3btoS5a = 0;
        S3btoS5b = 0;

        starveTime = 0;
        blockTime = 0;
        workLoad = 0;
    }

    // modifiers for stats
    public void addStarveTime(double addedTime){
        starveTime += addedTime;
    }
    public void addBlockTime(double addedTime){
        blockTime += addedTime;
    }
    public void calculateWorkLoad(double w){        // still trynna figure out how im supposed to go about this lol
        workLoad += w;
    }

    // getters for stats
    public double getStarveTime(){
        return starveTime;
    }
    public double getBlockTime(){
        return blockTime;
    }
    public double getWorkLoad(){
        return workLoad;
    }

    public double getProcessingTime(){
        return processingTime;
    }
    public void setProcessingTime(double p){
        processingTime = p;
    }

    public void setCurrentState(int s){
        // -1: starve
        //  0: busy
        //  1: blocked
        currentState = s;
    }

    public int getCurrentState(){
        return currentState;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public InterstageStorage getNextQueue(){
        return nextQueue;
    }

    public abstract void processItem(double currentTime);
    
    // fake toString() method
    public String toString(){
        String printer = "";  

        printer += name + "\t\t" + "0%" + "\t\t" + "00000.00" + "\t" + "00000.00" + "\n";

        return printer;
    }

    // linked list controlling
    public void setNext(Stage after){
        nextStage.add(after);
    }
    public int getNextSize(){
        return nextStage.size();
    }
    public ArrayList<Stage> getNext(){
        return nextStage;
    }
    
    // linked list controlling
    public void setPrev(Stage before){
        prevStage.add(before);
    }
    public int getPrevSize(){
        return prevStage.size();
    }
    public ArrayList<Stage> getPrev(){
        return prevStage;
    }

    public void setProcessingTime(int m, int n){
        Random r = new Random();
        double d = r.nextDouble();
        
        // P = M + N x (d - 0.5)
        processingTime = m + n * (d - 0.5);

        System.out.println("processingTime: " + processingTime);
    }

    // T2 = T1 + P.
    public double getProcessingTime(double p){
        // timeFinish = timeStart + p;
        return processingTime;
    }

    // TODO: 5. You will also keep a total number of items created by S0a and S0b that arrive at the end of the line.
    protected void countABrands() {
        aBrands++;
    }
    public int getABrands(){
        return aBrands;
    }

    public void countBBrands(){
        bBrands++;
    }
    public int getBBrands(){
        return bBrands;
    }

    // TODO: 6. Lastly, you will keep a total of the number of items that followed each path through Stage 3a/b and Stage 5a/b, that arrive at the end of the line
    // S3a to S5a
    public void addS3atoS5a(){
        S3atoS5a++;
    }
    public int getS3atoS5a(){
        return S3atoS5a;
    }

    // S3a to S5b
    public void addS3atoS5b(){
        S3atoS5b++;
    }
    public int getS3atoS5b(){
        return S3atoS5b;
    }

    // S3b to S5a
    public void addS3btoS5a(){
        S3btoS5a++;
    }
    public int getS3btoS5a(){
        return S3btoS5a;
    }

    // S3b to S5b
    public void addS3btoS5b(){
        S3btoS5b++;
    }
    public int getS3btoS5b(){
        return S3btoS5b;
    }
}