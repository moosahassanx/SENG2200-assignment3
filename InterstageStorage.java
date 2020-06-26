import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InterstageStorage {
    private String name;
    private double averageTime;
    private double averageItems;
    private int Qmax;
    private Queue<Item> carArray;

    private int count;
    
    public InterstageStorage(String n, int q) {
        name = n;
        averageTime = 0;
        averageItems = 0;
        Qmax = q;
        new LinkedList<Integer>();
        count = 0;
        carArray = new LinkedList<Item>();
    }

    public String getName(){
        return name;
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

    public boolean inputItem(Item inputCar){
        // System.out.println("inputting " + inputCar.getName() + " in " + name);

        // storage is full
        if(isFull() == true){
            return false;       // failed to insert car
        }

        // theres room
        else{
            carArray.add(inputCar);
            return true;
        }
    }

    public Item outputItem(){
        return carArray.poll();
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
}