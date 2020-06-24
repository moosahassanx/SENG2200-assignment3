import java.util.LinkedList;
import java.util.List;

public class InterstageStorage {
    private String name;
    private double averageTime;
    private double averageItems;
    private int Qmax;
    private Item[] carArray;

    private int count;                  // counts the cmoun
    private List<Integer> countStamp;

    public InterstageStorage(String n, int q){
        name = n;
        averageTime = 0;
        averageItems = 0;
        Qmax = q;
        countStamp = new LinkedList<Integer>();
        count = 0;
        carArray = new Item[Qmax];
    }

    public void inputItem(Item inputCar){
        for(int i = 0; i < Qmax; i++){
            if(carArray[i] != null){
                carArray[i] = inputCar;
                return;
            }
        }
    }

    // TODO: a. the average time an item spends in each queue 
    public double averageTime(){
        double time;

        time = 0.1;

        return time;
    }

    // TODO: b. the average number of items in the queue at any time (this statistic will require some thought).
    public int averageItems(){
        int numberOfItems;

        numberOfItems = 4;

        return numberOfItems;
    }

    // fake output
    public String toString(){
        String output = "";

        output += name + "\t\t" + averageTime + "\t\t\t" + averageItems + "\n";

        return output;
    }

	public void stampCount() {
        countStamp.add(new Integer(count));
	}
}