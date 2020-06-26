// TITLE: 					Assignment3
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InterstageStorage {
    private String name;
    private int Qmax;
    private Queue<Item> carArray;
    private Queue<Double> carData;
    private double duration;
    private int itemCount;
    private ArrayList<Integer> averageArray;

    public InterstageStorage(String n, int q) {
        name = n;
        Qmax = q;
        new LinkedList<Integer>();
        carArray = new LinkedList<Item>();
        carData = new LinkedList<Double>();
        averageArray = new ArrayList<Integer>();
        itemCount = 0;
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
            updateItemAverage(carArray.size());
            carData.add(d);
            return true;
        }
    }

    public Item outputItem(double d){
        Item car = carArray.poll();

        if(car != null){
            double timeEntered = carData.poll();
            double duration = d - timeEntered;
            // itemCount++;
            updateItemAverage(carArray.size());
            concatenateDuration(duration);
        }

        return car;
    }

    private void updateItemAverage(int i) {
        averageArray.add(i);
    }

    public void concatenateDuration(double d) {
        duration += d;
        itemCount++;
    }

    public String calcAverage(){
        double average = duration / itemCount;
        return String.format("%4.2f", average);
    }

    // a. the average time an item spends in each queue
    public double averageTime(){
        double time;
        time = 0.1;
        return time;
    }

    // b. the average number of items in the queue at any time
    public String averageItems() {
        double total = 0;

        for(int i = 0; i < averageArray.size(); i++){
            total += averageArray.get(i);
        }

        double average = total / averageArray.size();

        return String.format("%4.2f", average);
    }

    // output
    public String toString(){
        String output = "";
        output += name + " \t" + calcAverage() + " \t" + averageItems() + "\n";
        return output;
    }
}