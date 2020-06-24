// DESCRIPTION: consists of a number of production stages separated by interstage storage in the form of queues
//              of finite length (size Qmax). Those interstage stoirages will have varied time taken to process
//              an item because of the randomisers. This production line is balanced in that the average time
//              taken at any stage would essentiall be the same.

import java.util.Random;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import jdk.jfr.Event;

import java.lang.Thread;
import java.util.PriorityQueue;

public class ProductionLine {
    private int averageTime;
    private int timeRange;
    private int Qmax;

    private ArrayList<Stage> stageList;
    private ArrayList<InterstageStorage> interstageStorageList;
    private PriorityQueue<Job> priorityQueue;
    
    private InterstageStorage Q01, Q12, Q23, Q34, Q45, Q56;
    private Stage S0b, S3a, S3b, S5a, S5b;                           // 2M, 2N
    private Stage S0a, S1, S2, S4, S6;                               // 1M, 1N
    
    private double timeLimit = 10000000;

    private double d;       // random number between 0 and 1

    private EventManager EventManager;

    public ProductionLine(int m, int n, int qMax){
        averageTime = m;
        timeRange = n;
        Qmax = qMax;
        stageList = new ArrayList<Stage>();
        interstageStorageList = new ArrayList<InterstageStorage>();
        priorityQueue = new PriorityQueue<Job>();
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
        S0a = new StartStage("S0a", averageTime*2, timeRange*2, Q01);
        S0b = new StartStage("S0b", averageTime, timeRange, Q01);
        S1 = new MiddleStage("S1", averageTime, timeRange, Q12);
        S2 = new MiddleStage("S2", averageTime, timeRange, Q23);
        S3a = new MiddleStage("S3a", averageTime*2, timeRange*2, Q34);              // TODO: take out averagetime stuff cos im dumb lol
        S3b = new MiddleStage("S3b", averageTime*2, timeRange*2, Q34);
        S4 = new MiddleStage("S4", averageTime, timeRange, Q45);
        S5a = new MiddleStage("S5a", averageTime*2, timeRange*2, Q56);
        S5b = new MiddleStage("S5b", averageTime*2, timeRange*2, Q56);
        S6 = new FinishStage("S6", averageTime, timeRange);

        // setting stage times
        S0a.setProcessingTime(averageTime*2, timeRange*2);
        S0b.setProcessingTime(averageTime, timeRange);
        S1.setProcessingTime(averageTime, timeRange);
        S2.setProcessingTime(averageTime, timeRange);
        S3a.setProcessingTime(averageTime*2, timeRange*2);
        S3b.setProcessingTime(averageTime*2, timeRange*2);
        S4.setProcessingTime(averageTime, timeRange);
        S5a.setProcessingTime(averageTime*2, timeRange*2);
        S5b.setProcessingTime(averageTime*2, timeRange*2);
        S6.setProcessingTime(averageTime, timeRange);

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
        stageList.add(S0a);
        stageList.add(S0b);
        stageList.add(S1);
        stageList.add(S2);
        stageList.add(S3a);
        stageList.add(S3b);
        stageList.add(S4);
        stageList.add(S5a);
        stageList.add(S5b);
        stageList.add(S6);

        EventManager = new EventManager();

        // biggest checker, stop the process once the productionline reaches 10 000 000 time units
        while(EventManager.timeNow() < timeLimit){

            // process at every stage
            for(Stage s : stageList){
                // process all the items at this current time
                s.processItem(EventManager.timeNow());
            }

            System.out.println();

            /*
            // finish phase
            stageFinished = EventManager.nextAction();

            // update stage state durations
            for(Stage p : stageList){
                if(p != stageFinished){
                    p.incStateDur(EventManager.timeNow());
                }
            }

            // stamp average items
            for(InterstageStorage q : interstageStorageList){
                //
            }
            */
        }
    }

    public String toString() {
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