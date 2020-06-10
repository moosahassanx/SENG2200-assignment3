public class Stage {
    private double timeStart;
    private double timeFinish;
    private String name;

    // default constructor
    public Stage(){
        timeStart = 0;
        timeFinish = 0;
        name = "";
    }

    // main constructor
    public Stage(String n){
        name = n;
    }

    // T2 = T1 + P.
    public double processingTime(double p){
        // timeFinish = timeStart + p;
        return 2.3;
    }
    
    // fake toString() method
    public String toString(){
        String printer = "";  

        printer += name + "\t\t" + "0%" + "\t\t" + "00000.00" + "\t" + "00000.00" + "\n";

        return printer;
    }

    // TODO: 5. You will also keep a total number of items created by S0a and S0b that arrive at the end of the line.
    public int createdItems(){
        int numberOfItems;

        numberOfItems = 5;

        return numberOfItems;
    }

    // TODO: 6. Lastly, you will keep a total of the number of items that followed each path through Stage 3a/b and Stage 5a/b, that arrive at the end of the line
}