import java.util.LinkedList;
import java.util.List;

public class FinishStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item car;
    private int numberOfItems;

    private String nextQueue;

    // default constructor
    public FinishStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
        car = new Item();
    }

    // main constructor
    public FinishStage(String n, int m, int r){
        name = n;
        mean = m;
        range = r;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void processItem(double currentTime){
        System.out.println("FinishStage ProcessItem() loaded.");
    }

    public void FinishItem(){
        System.out.println("FinishItem() called");
    }

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