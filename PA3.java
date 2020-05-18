// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					15/05/2020
// DESCRIPTION: 			main file used for text scanning and final display

// importing java libraries (file scanner and string output)
import java.io.*;
import java.util.Scanner;

class PA2{
    public static void main(final String[] args) throws IOException
    {
        Scanner Console = new Scanner(System.in);
        String name;
        System.out.print("Enter name: ");
        name = Console.nextLine();
        System.out.println("Name = " + name);
        Console.close();
	}
}