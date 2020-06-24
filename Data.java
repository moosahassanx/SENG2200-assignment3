public class Data {
    private double processingTime;
    private String stageName;

    // main constructor
    public Data(String s, double t){
        processingTime = t;
        stageName = s;
    }

    // accessors
    public String getName(){
        return stageName;
    }

    public double getProcessingTime(){
        return processingTime;
    }
}