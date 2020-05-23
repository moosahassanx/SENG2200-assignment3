public class Controller {
    private int averageTime;
    private int timeRange;
    private int Qmax;
    Stage S0a;
    Stage S3a;
    Stage S3b;
    Stage S5a;
    Stage S5b;


    public Controller(int m, int n, int qMax){
        averageTime = m;
        timeRange = n;
        Qmax = qMax;
    }

    public void run(){
        System.out.println("M: " + averageTime);
        System.out.println("N: " + timeRange);
        System.out.println("Qmax: " + Qmax);

        
    }
}