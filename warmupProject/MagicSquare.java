import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MagicSquare implements MagicSquareInterface{

    File file = new File(filename);
    PrintWriter outfile = new PrintWriter(file);
    Boolean magicSquare = true;

    public void MagicSquare(File "*.txt"){
        try {
            
        } catch (Exception e) {
            System.out.println("INVALID FILE FORMAT/FILE UNABLE TO BE OPENED!");
        }
    } 

    @Override
    public boolean isMagicSquare() {
        int magicNum = 0;
        int totalNum = 0;

        for (int row = 0; row < intArray[row]; row++) {
            if(magicSquare = false){
                break;
            }
            for (int col = 0; col < intArray[row][col]; col++) {
            magicNum += intArray[row][col];
            totalNum += intArray[row][col];
            }
            if(magicNum != magicNum * (Math.pow(magicNum,2) + 1) / 2){
                magicSquare = false;
            }
        }
        magicNum = 0;
        for (int col = 0; col < intArray[col]; col++) {
            if(magicSquare = false){
                break;
            }
            for (int row = 0; row < intArray[row][col]; row++) {
            magicNum += intArray[row][col];
            }
            if(magicNum != magicNum * (Math.pow(magicNum,2) + 1) / 2){
                magicSquare = false;
            }
        }
        if(totalNum / magicNum == magicNum * (Math.pow(magicNum,2)+1)/2){ // This makes sure that ALL integers are correct.
            magicSquare = true;
        }
    }

    @Override
    public int[][] getMatrix() {
        //
        throw new UnsupportedOperationException("Unimplemented method 'getMatrix'");
    }

    @Override // Use the given algorithm in the description of the assignment.
    public String finalString() {
        // returns a string showing the matrix and whether or not it was successful.
        System.out.println("The matrix:");
        // find a way to have this be printed out properly. Ask Kount Learning Center
        for (int i = 0; placeholder[i][j]; i++){ // Iterate through each row and column, printing out each object.
            System.out.print("\t");
            for (int j = 0; j < placeholderArray[i][j]; j++) {
                System.out.print(placeholderArray[i][j] + " ");
            }
            System.out.println();
        }
        if(magicSquare = true){
            System.out.println("is a magic square");
        }else{
            System.out.println("is not a magic square");
        }
    }
}