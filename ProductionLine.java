// DESCRIPTION: consists of a number of production stages separated by interstage storage in the form of queues
//              of finite length (size Qmax). Those interstage stoirages will have varied time taken to process
//              an item because of the randomisers. This production line is balanced in that the average time
//              taken at any stage would essentiall be the same.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProductionLine {
    private int averageTime;
    private int timeRange;
    private int Qmax;

    private ArrayList<Stage> stageList;
    private ArrayList<InterstageStorage> interstageStorageList;
    private InterstageStorage Q01, Q12, Q23, Q34, Q45, Q56;
    private Stage S0b, S3a, S3b, S5a, S5b;                          // 2M, 2N
    private Stage S0a, S1, S2, S4, S6;                              // 1M, 1N

    private double currentTime;
    private double timeLimit = 10000000;

    private Scheduler Scheduler;

    public ProductionLine(int m, int n, int qMax) {
        averageTime = m;
        timeRange = n;
        Qmax = qMax;
        stageList = new ArrayList<Stage>();
        interstageStorageList = new ArrayList<InterstageStorage>();
        new PriorityQueue<Job>();
        currentTime = 0;
    }

    public void run(){
        System.out.println("M: " + averageTime);
        System.out.println("N: " + timeRange);
        System.out.println("Qmax: " + Qmax);
        System.out.println();
        

        // making queues
        Q01 = new InterstageStorage("Q01", Qmax);
        Q12 = new InterstageStorage("Q12", Qmax);
        Q23 = new InterstageStorage("Q23", Qmax);
        Q34 = new InterstageStorage("Q34", Qmax);
        Q45 = new InterstageStorage("Q45", Qmax);
        Q56 = new InterstageStorage("Q56", Qmax);

        // adding to storage lists
        interstageStorageList.add(Q01);
        interstageStorageList.add(Q12);
        interstageStorageList.add(Q23);
        interstageStorageList.add(Q34);
        interstageStorageList.add(Q45);
        interstageStorageList.add(Q56);

        // lineup
        S0a = new StartStage("S0a", averageTime*2, timeRange*2, Q01, "a");
        S0b = new StartStage("S0b", averageTime, timeRange, Q01, "b");
        S1 = new MiddleStage("S1", averageTime, timeRange, Q12, Q01);
        S2 = new MiddleStage("S2", averageTime, timeRange, Q23, Q12);
        S3a = new MiddleStage("S3a", averageTime*2, timeRange*2, Q34, Q23);
        S3b = new MiddleStage("S3b", averageTime*2, timeRange*2, Q34, Q23);
        S4 = new MiddleStage("S4", averageTime, timeRange, Q45, Q34);
        S5a = new MiddleStage("S5a", averageTime*2, timeRange*2, Q56, Q45);
        S5b = new MiddleStage("S5b", averageTime*2, timeRange*2, Q56, Q45);
        S6 = new FinishStage("S6", averageTime, timeRange, Q56);

        // linking all the stages using java linked lists
        S0a.setNext(S1);
        S0b.setNext(S1);

        S1.setPrev(S0a);
        S1.setPrev(S0b);
        S1.setNext(S2);

        S2.setPrev(S1);
        S2.setNext(S3a);
        S2.setNext(S3b);
        
        S3a.setPrev(S2);
        S3a.setNext(S4);

        S3b.setPrev(S2);
        S3b.setNext(S4);

        S4.setPrev(S3a);
        S4.setPrev(S3b);
        S4.setNext(S5a);
        S4.setNext(S5b);

        S5a.setPrev(S4);
        S5a.setNext(S6);
        
        S5b.setPrev(S4);
        S5b.setNext(S6);

        S6.setPrev(S5a);
        S6.setPrev(S5b);

        // adding to stage arraylist (controller communicating)
        stageList.add(S0a); // 0
        stageList.add(S0b); // 1
        stageList.add(S1);  // 2
        stageList.add(S2);  // 3
        stageList.add(S3a); // 4
        stageList.add(S3b); // 5
        stageList.add(S4);  // 6
        stageList.add(S5a); // 7
        stageList.add(S5b); // 8
        stageList.add(S6);  // 9

        // create new event manager
        Scheduler = new Scheduler();

        Scheduler.addToPriorityQueue(stageList.get(0), 0);  // S0a
        Scheduler.addToPriorityQueue(stageList.get(1), 0);  // S0b

        // overall checker - stop the process once the productionline reaches 10 000 000 time units
        while(Scheduler.timeNow() < timeLimit){
            // take the job with the highest priority and use that
            Job bigJob = Scheduler.removeJob();

            // process the priority stage
            bigJob.getCurrentStage().processItem(Scheduler.timeNow());

            // for busy stages
            if(bigJob.getCurrentStage().getCurrentState() == 0){
                Scheduler.addToPriorityQueue(bigJob.getCurrentStage(), bigJob.getCurrentStage().getProcessingTime());
            }
            
            // System.out.println("MANAGING: " + bigJob.getCurrentStage().getName());

            // previous stages
            for(Stage s : bigJob.getCurrentStage().getPrev()){
                if(s.getCurrentState() == 1){
                    // previous stage is blocked
                    Scheduler.addToPriorityQueue(s, 0);
                    break;
                }
            }

            // next stages
            for(Stage s : bigJob.getCurrentStage().getNext()){
                // next stage is starved
                if(s.getCurrentState() == -1){
                    Scheduler.addToPriorityQueue(s, 0);
                    break;
                }
            }

            currentTime = bigJob.getCurrentTime();
        }

        // System.out.println("complete");
    }

    public String toString(){
        String output = "";

        output += "Production Stations:\n---------------------------------------------------------\n";
        output += "Stage\t\tWork[%]\t\tStarve[t]\tBlock[t]\n";
        output += S0a.toString();
        output += S0b.toString();
        output += S1.toString();
        output += S2.toString();
        output += S3a.toString();
        output += S3b.toString();
        output += S4.toString();
        output += S5a.toString();
        output += S5b.toString();
        output += "\n";
        

        output += "Storage Queues:\n----------------------------------------------------\n";
        output += "Store\t\tAvgTime[t]\t\tAvgItems\n";
        output += Q01.toString();
        output += Q12.toString();
        output += Q23.toString();
        output += Q34.toString();
        output += Q45.toString();
        output += Q56.toString();
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