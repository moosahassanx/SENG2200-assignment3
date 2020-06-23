import java.util.LinkedList;
import java.util.List;

public class BeginningStage extends Stage{
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item car;
    private int numberOfItems;

    private String nextQueue;

    protected List<Stage> nextStage;

    // default constructor
    public BeginningStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
        car = new Item();
        nextStage = new LinkedList<Stage>();
    }

    // main constructor
    public BeginningStage(String n, int m, int r, int amount, String AorB){
        name = n;
        mean = m;
        range = r;
        numberOfItems = amount;

        for(int i = 0; i < numberOfItems; i++){
            car = new Item(AorB);
        }

        nextStage = new LinkedList<Stage>();
    }

    public void setNext(Stage after){
        nextStage.add(after);
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