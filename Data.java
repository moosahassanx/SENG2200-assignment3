public class Data {
    private double processingTime;
    private String stageName;

    // main constructor
    public Data(String s, double t){
        processingTime = t;
        stageName = s;
    }

    // mutators
    public void setStageName(String s){
        stageName = s;
    }
    public void setProcessingTime(double p){
        processingTime = p;
    }

    // accessors
    public String getStageName(){
        return stageName;
    }
    public double getProcessingTime(){
        return processingTime;
    }
}