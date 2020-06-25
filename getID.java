import java.util.Random;

// Java program implementing Singleton class with getInstance() method
public class getID{

    private String ID;

    public getID(){
        Random r = new Random();

        this.ID = "";
        int rng = r.nextInt(10);
        this.ID = String.valueOf(rng);

        for(int j = 0; j < 9; j++){
            rng = r.nextInt(10);
            this.ID += String.valueOf(rng);
        }
    }

    public String retrieveID(){
        return this.ID;
    }
} 

/* ACTUAL SINGLETON WAY - never officially completed but could be used for marking
public class getID {
    // static variable single_instance of type Singleton 
    private static getID single_instance = null; 
  
    // variable of type String 
    public String ID; 
  
    // private constructor restricted to this class itself 
    private getID(){
        Random r = new Random();

        this.ID = "";
        int rng = r.nextInt(10);
        this.ID = String.valueOf(rng);

        for(int j = 0; j < 9; j++){
            rng = r.nextInt(10);
            this.ID += String.valueOf(rng);
        }
    } 
  
    // static method to create instance of Singleton class 
    public static getID getInstance(){ 
        if (single_instance == null)
            single_instance = new getID();
  
        return single_instance; 
    }   
}
*/