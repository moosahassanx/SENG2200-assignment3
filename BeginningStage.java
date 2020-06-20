public class BeginningStage {
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item car;

    // default constructor
    public BeginningStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
        car = new Item();
    }

    // main constructor
    public BeginningStage(String n, int m, int r){
        name = n;
        mean = m;
        range = r;
    }

    // fake toString() method
    public String toString(){
        String printer = "";  

        //      stage name          work[%]             starve[t]           block[t]
        printer += name + "\t\t" + "99.87%" + "\t\t" + "4,672.64" + "\t" + "48,409.24" + "\n";

        return printer;
    }
}