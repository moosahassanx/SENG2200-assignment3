public class Item {
    private String uniqueID;
    private Data[] dataArray;

    public Item(String AorB) {
        dataArray = new Data[7];

        getID generateID = new getID();
        uniqueID = generateID.retrieveID() + AorB;
    }

    public void addData(String name, double processingTime){
        // iterate through every stage array
        for(int i = 0; i < 7; i++){
            // null checker
            if(dataArray[i] != null){
                // add the data
                dataArray[i] = new Data(name, processingTime);
                return;
            }
        }
    }

    public String getName(){
        return uniqueID;
    }
}