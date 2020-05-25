public class Stage {
    private String test;
    private double timeStart;
    private double timeFinish;

    // constructor
    public Stage(){
        test = "";
    }

    public void setTest(String t){
        test = t;
    }

    // T2 = T1 + P.
    public double processingTime(double p){
        // timeFinish = timeStart + p;
        return 2.3;
    }
    
    public String toString(){
        String printer = "";

        printer += "";

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