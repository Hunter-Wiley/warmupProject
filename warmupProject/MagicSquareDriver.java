import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**public class MagicSquareDriver {
    // When creating a file make sure that the command line is odd.

    // First order of business: Create a MagicSquare object

    // Second order: Have that object read from input

    // Third order: Check command-line arguments to both create/read.
    // Be sure to check to see if the filename already exists.
    // In addition, when creating a file have it print out the newly created file and see if it is a magic square.
    // Java will run the program from the command line as follows  -->  java MagicSquareDriver <-check | -create> <filename> < |size> 
    // It uses args[i] to check what is being done. Ex: size = args[5]
    
    public static void main(String[] args) {
        Boolean isRightCommand = false;
        while(isRightCommand == false){
            if((int)args[3] % 2 == 0){
                System.out.println("Invalid size!");
            }else{
                int size = args[3]; // Use this for creating the Magic Square.
            }
        
        }
        // Have it run MagicSquare here.
    }
}*/
