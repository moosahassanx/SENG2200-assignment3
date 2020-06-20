import java.util.Random;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.lang.Thread;

public class Controller {
    private int averageTime;
    private int timeRange;
    private int Qmax;
    private InterstageStorage Q01, Q12, Q23, Q34, Q45, Q56;
    private Stage S3a, S3b, S5a, S5b;                           // 2M, 2N
    private Stage S1, S2, S4, S6;                               // 1M, 1N
    private double timeLimit = 10000000;

    private BeginningStage S0a, S0b;        // S0a: 2M, 2N      S0b: 1M, 1N

    private double processingTime;
    private double d;       // random number between 0 and 1

    public Controller(int m, int n, int qMax){
        averageTime = m;
        timeRange = n;
        Qmax = qMax;
        // P = M + N × (d − 0.5).
        processingTime = (d-0.5) * timeRange + averageTime;
    }

    public void run(){
        System.out.println("M: " + averageTime);
        System.out.println("N: " + timeRange);
        System.out.println("Qmax: " + Qmax);
        System.out.println();

        // generating item numbers
        Random r = new Random();
        int a = 0;
        int b = 0;
        String beginA = "a";
        String beginB = "b";

        // generating amount of items to be made for which beginning stage
        for(int i = 0; i < 100; i++){
            double AorB = r.nextDouble();

            if(AorB < 0.5){
                a++;
            }
            
            else{
                b++;
            }
        }

        // lineup
        S0a = new BeginningStage("S0a", averageTime*2, timeRange*2, a, beginA);
        S0b = new BeginningStage("S0b", averageTime, timeRange, b, beginB);
        
        Q01 = new InterstageStorage("Q01");

        S1 = new Stage("S1");
        /*
        Q12 = new InterstageStorage("Q12");

        S2 = new Stage("S2");
        Q23 = new InterstageStorage("Q23");

        S3a = new Stage("S3a");
        S3b = new Stage("S3b");
        Q34 = new InterstageStorage("Q34");

        S4 = new Stage("S4");
        Q45 = new InterstageStorage("Q45");

        S5a = new Stage("S5a");
        S5b = new Stage("S5b");
        Q56 = new InterstageStorage("Q56");

        S6 = new Stage("S6");
        */
    }

    public String toString(){
        String output = "";

        output += "Production Stations:\n---------------------------------------------------------\n";
        output += "Stage\t\tWork[%]\t\tStarve[t]\tBlock[t]\n";
        output += S0a.toString();
        output += S0b.toString();
        output += S1.toString();
        /*
        output += S2.toString();
        output += S3a.toString();
        output += S3b.toString();
        output += S4.toString();
        output += S5a.toString();
        output += S5b.toString();
        */
        output += "\n";
        

        output += "Storage Queues:\n----------------------------------------------------\n";
        output += "Store\t\tAvgTime[t]\t\tAvgItems\n";
        output += Q01.toString();
        /*
        output += Q12.toString();
        output += Q23.toString();
        output += Q34.toString();
        output += Q45.toString();
        output += Q56.toString();
        */
        output += "\n\n";

        output += "Production Paths:\n------------------\n";
        output += "S3a -> S5a: " + "NEED TODO THIS \n";
        output += "S3a -> S5b: " + "NEED TODO THIS \n";
        output += "S3b -> S5a: " + "NEED TODO THIS \n";
        output += "S3b -> S5b: " + "NEED TODO THIS \n";
        output += "\n\n";

        output += "Production Items:\n------------------\n";
        output += "S0a: " + "NEED TODO THIS \n";
        output += "S0b: " + "NEED TODO THIS \n";

        return output;
    }
}