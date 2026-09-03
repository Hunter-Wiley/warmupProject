import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MagicSquare implements MagicSquareInterface{

    int dimension;
    int[][] magicSquareArray;


    public MagicSquare(String filename) throws FileNotFoundException{
        magicSquareArray = readMatrix(filename);
    }
    
    private int[][] readMatrix(String filename) throws FileNotFoundException{
        int[][] tempMatrix = null;
        try {
            File file = new File(filename);
            Scanner readFile = new Scanner(file);
            dimension = readFile.nextInt();
            tempMatrix = new int[dimension][dimension];
            while(readFile.hasNextInt()){
                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {
                        tempMatrix[i][j] = readFile.nextInt();
                    }
                    
                }
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE CANNOT BE READ/INCORRECT FILE FORMAT");
            throw e;
        }
        return tempMatrix;

    }

    public MagicSquare(String filename, int dimension) throws IOException{
        int[][] newMatrix = new int[dimension][dimension];
        int row = dimension - 1;
        int col = dimension / 2;
        int oldRow;
        int oldCol;
        for (int i = 0; i < Math.pow(dimension,2); i++) {
            newMatrix[row][col] = i; // This keeps throwing an Index out of bounds error. Ask about it.
            oldRow = row;
            oldCol = col;
            if(row == dimension){
                row = 0;
            }
            if(col == dimension){
                col = 0;
            }
            if(newMatrix[row][col] != 0){
                row = oldRow;
                col = oldCol;
                row--;
            }
        }
        writeMatrix(newMatrix, filename);
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException{
        try {
            File file = new File(filename);
            PrintWriter outfile = new PrintWriter(file);
            outfile.println(matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    outfile.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            
            outfile.close();
        } catch (IOException e) {
            System.out.println("INCORRECT INPUT OUTPUT!");
            //throw e;
        }
        
    }

    @Override
    public boolean isMagicSquare() {
        double magicNum = 0;
        Boolean magicSquare = true;
        double trueMagicNum = dimension * (Math.pow(dimension,2) + 1) / 2; // Check to see if there are any duplicate #s.
        for (int row = 0; row < magicSquareArray.length; row++) {
            if(magicSquare == false){
                return magicSquare;
            }
            for (int col = 0; col < magicSquareArray[row].length; col++) {
                magicNum += magicSquareArray[row][col];
                
            }
            if(magicNum != trueMagicNum){
                magicSquare = false;
            }
            if(magicNum == trueMagicNum){
                magicSquare = true;
            }
            magicNum = 0;
        }
        magicNum = 0;
        for (int col = 0; col < magicSquareArray.length; col++) {
            if(magicSquare == false){
                return magicSquare;
            }
            for (int row = 0; row < magicSquareArray.length; row++) {
            magicNum += magicSquareArray[row][col];
            }
            if(magicNum != trueMagicNum){
                magicSquare = false;
            }
            if(magicNum == trueMagicNum){
                magicSquare = true;
            }
            magicNum = 0;
        }
        return magicSquare;
    }

    @Override
    public int[][] getMatrix() {
        int[][] copyMatrix = new int[dimension][dimension];
        for (int row = 0; row < magicSquareArray.length; row++) {
            for (int col = 0; col < magicSquareArray[row].length; col++) {
                copyMatrix[row][col] = magicSquareArray[row][col];
            }
        }
        return copyMatrix;
    }

    @Override
    public String toString() {
        // returns a string showing the matrix and whether or not it was successful.
        String finalString = "The matrix\n";
        for (int i = 0; i < magicSquareArray.length; i++){ // Iterate through each row and column, printing out each object.
            finalString += ("\t"); // Used for proper formatting
            for (int j = 0; j < magicSquareArray[i].length; j++) {
                finalString += (magicSquareArray[i][j] + " ");
            }
            finalString += "\n";
        }
        boolean magicSquare =  isMagicSquare();
        if(magicSquare == true){
            finalString += ("is a magic square.");
        }
        if(magicSquare == false){
            finalString += ("is not a magic square.");
        }
        return finalString;
    }
}