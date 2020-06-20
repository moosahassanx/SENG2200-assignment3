// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					15/05/2020
// DESCRIPTION: 			main file used for text scanning and final display

// importing java libraries (file scanner and string output)
import java.io.*;
import java.util.Scanner;

class PA3{
    public static void main(final String[] args) throws IOException{
        // declaring variables and user input scanner
        Scanner Console = new Scanner(System.in);
        Controller controller;
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
        controller = new Controller(m, n, qMax);
        controller.run();

        // outputting results
        System.out.println(controller.toString());
	}
}

/*
Production Stations:
--------------------------------------------
Stage:  Work[%]     Starve[t]       Block[t]
S0a      47.96%          0.00     103,601.39
S0b      48.65%          0.00     101,127.90
S1       99.87%      4,672.64      48,409.24
S2       98.87%     94,264.24      18,346.11
S3a      72.40%  2,236,949.88     522,533.24
S3b      63.02%  2,943,353.53     754,801.25
S4       98.61%    136,951.46       2,206.19
S5a      62.96%  2,957,251.09     746,649.33
S5b      72.32%  2,226,450.41     540,988.14
S6       98.82%    118,226.16           0.00

Storage Queues:
------------------------------
Store   AvgTime[t]  AvgItems
Q01       3,674.47      3.12
Q12       3,734.88      3.11
Q23         515.32      0.40
Q34       4,085.28      3.39
Q45         414.71      0.29
Q56       4,011.52      3.31

Production Paths:
------------------
S3a -> S5a: 2,296
S3a -> S5b: 1,321
S3b -> S5a: 3,973
S3b -> S5b: 2,272

Production Items:
------------------
S0a: 2,296
S0b: 1,321
*/