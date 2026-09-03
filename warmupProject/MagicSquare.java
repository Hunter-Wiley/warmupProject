import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MagicSquare implements MagicSquareInterface{

    private int dimension;
    private int[][] magicSquareArray = new int[dimension][dimension];

    /**
     * The priamary constructor for reading 2DArray information from
     * a given filename, then printing it into the console.
     * @param filename
     * @throws FileNotFoundException
     */
    public MagicSquare(String filename) throws FileNotFoundException{
        this.magicSquareArray = readMatrix(filename);
    }
    
    /**
     * The readMatrix method's primary function is to be given a filename,
     * then read the 2DArray information from that file to copy
     * into a 2DArray that is returned for a constructor.
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
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

    /**
     * The MagicSquare constructor both calls upon
     * the writeMatrix function, and also provides a mathematical
     * formula for creating a Magic Square 2DArray, which is passed
     * on to writeMatrix, along with a filename to be written to.
     * @param filename
     * @param dimension
     * @throws IOException
     */
    public MagicSquare(String filename, int dimension) throws IOException{
        this.dimension = dimension;
        int[][] newMatrix = new int[dimension][dimension];
        int row = dimension - 1;
        int col = dimension / 2;
        int oldRow;
        int oldCol;
        for (int i = 1; i <= Math.pow(dimension,2); i++) {
            newMatrix[row][col] = i; // This keeps throwing an Index out of bounds error. Ask about it.
            oldRow = row;
            oldCol = col;
            row++;
            col++;
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
            if(row == -1){
                row = oldRow;
            }
        }
        magicSquareArray = newMatrix;
        writeMatrix(newMatrix, filename);
    }

    /**
     * The writeMatrix method is used inside of a two parameter
     * constructor, and it's primary purpose is to write information
     * to a designated file provided by the constructor.
     * @param matrix
     * @param filename
     * @throws IOException
     */
    private void writeMatrix(int[][] matrix, String filename) throws IOException{
        try {
            File file = new File(filename);
            PrintWriter outfile = new PrintWriter(file);
            outfile.println(matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    outfile.print(matrix[i][j] + "\t");
                }
                outfile.println();
            }
            outfile.close();
        } catch (IOException e) {
            System.out.println("INCORRECT INPUT OUTPUT!");
            throw e;
        }
        
    }

    @Override
    public boolean isMagicSquare(){
        int prevElement = 0;
        double magicNum = 0;
        Boolean magicSquare = true;
        double trueMagicNum = dimension * (Math.pow(dimension,2) + 1) / 2;
        for (int row = 0; row < magicSquareArray.length; row++) {
            if(magicSquare == false){
                return magicSquare;
            }
            for (int col = 0; col < magicSquareArray[row].length; col++) {
                if(prevElement != magicSquareArray[row][col]){
                    magicNum += magicSquareArray[row][col];
                    prevElement = magicSquareArray[row][col];
                }else{
                    magicSquare = false;
                    break;
                }
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
        for (int i = 0; i < magicSquareArray.length; i++){
            if(magicSquare == false){
                return magicSquare;  
            }
            magicNum += magicSquareArray[i][i];
            if(magicNum != trueMagicNum){
                magicSquare = false;
            }
            if(magicNum == trueMagicNum){
                magicSquare = true;
            }
            magicNum = 0;
        }
        int j = 0;
        for (int i = dimension - 1; i > -1; i--){
            if(magicSquare == false){
                return magicSquare;  
            }
            magicNum += magicSquareArray[i][j];
            j++;
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
    public int[][] getMatrix(){
        dimension = magicSquareArray.length;
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
        String finalString = "The matrix\n";
        for (int i = 0; i < magicSquareArray.length; i++){
            finalString += ("\t");
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