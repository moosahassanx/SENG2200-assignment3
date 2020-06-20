public class BeginningStage {
    private double timeStart;
    private double timeFinish;
    private String name;
    private int mean;
    private int range;

    private Item car;
    private int numberOfItems;

    // default constructor
    public BeginningStage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
        car = new Item();
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
    }

    // fake toString() method
    public String toString(){
        String printer = "";  

        //      stage name          work[%]             starve[t]           block[t]
        printer += name + "\t\t" + "00.00%" + "\t\t" + "0,000.00" + "\t" + "00,000.00" + "\n";

        return printer;
    }
}