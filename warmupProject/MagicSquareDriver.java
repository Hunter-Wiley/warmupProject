import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MagicSquareDriver {
    // When creating a file make sure that the command line is odd.
    // Have some sort of try/catch statement for that?

    // First order of business: Create a MagicSquare object

    // Second order: Have that object read from input
    File file = new File(filename);
    PrintWriter outfile = new PrintWriter(file);

    // Third order: Check command-line arguments to both create/read.
    // Be sure to check to see if the filename already exists.
    // In addition, when creating a file have it print out the newly created file and see if it is a magic square.
    // Java will run the program from the command line as follows  -->  java MagicSquareDriver <-check | -create> <filename> < |size> 
    // It uses args[i] to check what is being done. Ex: size = args[5]
    
    public static void main(String[] args) {
        Boolean isRightCommand = false;
        while(isRightCommand == false){
            if((int)args[5] % 2 == 0){
                System.out.println("Invalid size!");
            }else{
                int size = args[5]; // Use this for creating the Magic Square.
            }
        
        }

        //System.out.println(MagicSquare.finalString());
        if(magicSquare == true){
            System.out.println("is a magic square.");
        }else{
            System.out.println("is not a magic square.");
        }
    }
}
