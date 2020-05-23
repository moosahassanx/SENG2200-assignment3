// TAKEN FROM https://www.geeksforgeeks.org/singleton-class-java/ NEEDS TO BE CHANGED TO FIT ASSIGNMENT **************************
// THIS CLASS WILL NEED TO RETURN A UNIQUE STRING ID FOR THE ITEMS IN THIS PROGRAM

// Java program implementing Singleton class with getInstance() method 
public class getID 
{ 
    // static variable single_instance of type Singleton 
    private static getID single_instance = null; 
  
    // variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private getID() 
    { 
        s = "Hello I am a string part of Singleton class"; 
    } 
  
    // static method to create instance of Singleton class 
    public static getID getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new getID(); 
  
        return single_instance; 
    } 
} 