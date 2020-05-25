import java.util.Random;

public class Controller {
    private int averageTime;
    private int timeRange;
    private int Qmax;
    private Stage S0a, S3a, S3b, S5a, S5b;      // 2M, 2N
    private Stage S0b, S1, S2, S4, S6;          // 1M, 1N
    private Item[] car;
    private double processingTime;
    private double d;       // random number between 0 and 1


    public Controller(int m, int n, int qMax){
        averageTime = m;
        timeRange = n;
        Qmax = qMax;
        car = new Item[10000];
        Random r = new Random();
        d = r.nextDouble();           // assigning value instead of having it be random TEMPORARY
        
        // P = M + N × (d − 0.5).
        processingTime = (d-0.5) * timeRange + averageTime;
    }

    public void run(){
        System.out.println("M: " + averageTime);
        System.out.println("N: " + timeRange);
        System.out.println("Qmax: " + Qmax);

        System.out.println("Production Stations:\n--------------------------------");
        System.out.println("Stage\t\tWork[%]\t\tStarve[t]\tBlock[t]");
        System.out.println(S0a.toString());
    }
}