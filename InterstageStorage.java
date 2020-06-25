import java.util.LinkedList;
import java.util.List;

public class InterstageStorage {
    private String name;
    private double averageTime;
    private double averageItems;
    private int Qmax;
    private Item[] carArray;

    private int count;                  // number of items in the storage
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

    public String getName(){
        return name;            // mainly used for testing
    }

    public boolean isFull(){
        // interstage storage is full
        if(count == 7) {
            return true;
        }

        // theres space in the interstage storage
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }

        else{
            return false;
        }
    }

    public void inputItem(Item inputCar){
        System.out.println("inputting " + inputCar.getName() + " in " + name);

        for(int i = 0; i < Qmax; i++){
            if(carArray[i] == null){
                carArray[i] = inputCar;
                count++;
                return;
            }
        }
    }

    public Item outputItem(){
        Item outputCar = null;

        outputCar = carArray[0];

        carArray[0] = carArray[1];

        // shuffling arrays down the order
        if(carArray[2] != null){
            carArray[1] = carArray[2];
        }
        if(carArray[3] != null){
            carArray[2] = carArray[3];
        }
        if(carArray[4] != null){
            carArray[3] = carArray[4];
        }
        if(carArray[5] != null){
            carArray[4] = carArray[5];
        }
        if(carArray[6] != null){
            carArray[5] = carArray[6];
        }

        return outputCar;

        /*
        // setup
        Item outputItem = carArray[0];
        int originalLength = carArray.length;
        carArray[0] = null;

        // shuffle array downwards
        for(int i = 0; i < originalLength; i++){
            if(carArray[i+1] != null){
                carArray[i] = carArray[i+1];
            }

            else{
                // return
                return outputItem;
            }
        }

        // return
        return outputItem;
        */
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