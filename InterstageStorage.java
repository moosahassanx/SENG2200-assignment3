// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			place for items to be stored for temporarily. allows for stages to pull and
//                          push items from here
import java.util.LinkedList;
import java.util.Queue;

public class InterstageStorage {
    private String name;
    private double averageItems;
    private int Qmax;
    private Queue<Item> carArray;
    private Queue<Double> carData;
    private double duration;
    private double itemCount;

    public InterstageStorage(String n, int q) {
        name = n;
        averageItems = 0;
        Qmax = q;
        new LinkedList<Integer>();
        carArray = new LinkedList<Item>();
        carData = new LinkedList<Double>();
    }

    public String getName(){
        return name;
    }

    public boolean isFull(){
        // interstage storage is full
        if(carArray.size() == Qmax) {
            return true;
        }

        // theres space in the interstage storage
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(carArray.size() == 0){
            return true;
        }

        else{
            // System.out.println(name + " is not empty");
            return false;
        }
    }

    public boolean inputItem(Item inputCar, double d){
        // System.out.println("inputting " + inputCar.getName() + " in " + name);

        // storage is full
        if(isFull() == true){
            return false;       // failed to insert car
        }

        // theres room
        else{
            carArray.add(inputCar);
            carData.add(d);
            return true;
        }
    }

    public Item outputItem(double d){
        Item car = carArray.poll();

        if(car != null){
            double timeEntered = carData.poll();
            double duration = d - timeEntered;
            itemCount++;
            concatenateDuration(duration);
        }

        return car;
    }

    public void concatenateDuration(double d){
        duration += d;
    }

    public double calcAverage(){
        return duration / itemCount;
    }

    // a. the average time an item spends in each queue
    public double averageTime(){
        double time;

        time = 0.1;

        return time;
    }

    // b. the average number of items in the queue at any time (this statistic will require some thought).
    public int averageItems(){
        int numberOfItems;

        numberOfItems = 4;

        return numberOfItems;
    }

    // fake output
    public String toString(){
        String output = "";

        output += name + "\t\t" + calcAverage() + "          \t" + averageItems + "\n";

        return output;
    }
}