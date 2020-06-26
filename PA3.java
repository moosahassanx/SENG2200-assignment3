// TITLE: 					Assignment3
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					26/06/2020
// DESCRIPTION: 			takes input values and sends it to the main controller
import java.io.*;
import java.util.Scanner;

class PA3{
    public static void main(final String[] args) throws IOException{
        // declaring variables and user input scanner
        Scanner Console = new Scanner(System.in);
        ProductionLine ProductionLine;
        int m, n, qMax;

        // taking in data from user
        m = Integer.parseInt(args[0]);
        n = Integer.parseInt(args[1]);
        qMax = Integer.parseInt(args[2]);
        Console.close();

        // • The inter-stage storage capacities (Qmax) will be always greater than 1.
        while(qMax < 1){
            System.out.println("ERROR: Qmax input must be greater than 1.");
            return;
        }

        // sending information to controller
        ProductionLine = new ProductionLine(m, n, qMax);
        ProductionLine.run();

        // outputting results
        System.out.println(ProductionLine.toString());
	}
}