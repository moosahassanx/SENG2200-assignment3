import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StartStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item tempItem;

    private int numberOfItems;

    private InterstageStorage nextQueue;

    // default constructor
    public StartStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
    }

    // main constructor
    public StartStage(String n, int m, int r, InterstageStorage q){
        name = n;
        mean = m;
        range = r;

        InterstageStorage nextQueue = q;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        System.out.println("StartStage processItem() loaded.");

        Item car = new Item();
        System.out.println("starting new car production");

        Random r = new Random();
        double d = r.nextDouble();
        System.out.println("d: " + d);

        // P = M + N x (d - 0.5)
        double processingTime = mean + range * (d - 0.5);
        System.out.println("processingTime: " + processingTime);

        car.addData(name, processingTime);

        // temporarily store so the next method can call it
        storeToQueue(car);
    }

    public void storeToQueue(Item tempCar){
        nextQueue.inputItem(tempCar);
    }
    public Item getTempItem(){
        return tempItem;
    }

    public void FinishItem(){
        System.out.println("FinishItem() called");
    }

    // for printing stats
    public String toString(){
        String printer = "";  

        //      stage name          work[%]              starve[t]           block[t]
        printer += name + "\t\t" + getWork() + "\t\t" + getStarve() + "\t" + getBlock() + "\n";

        return printer;
    }

    public String getWork(){
        String work = "00.00%";

        return work;
    }

    public String getStarve(){
        String starve = "0,000.00";

        return starve;
    }

    public String getBlock(){
        String block = "00,000.00";

        return block;
    }
}