import java.io.IOException;

public class MagicSquareDriver {
    /**
     * The main class from which the program is ran.
     * Uses command-line arguments to pass on to
     * constructor methods that create/check and
     * print the associated files. It requires
     * either 2 or 3 arguments depending on whether
     * or not the user is checking a file or creating
     * one.
     * @param args
     */
    public static void main(String[] args) {
        try{
            if(args.length < 2){
                System.out.println("INCORRECT NUMBER OF ARGUMENTS! USE EITHER 2 OR 3 ARGUMENTS!");
                return;
            }
            if(args.length > 3){
                System.out.println("TOO MANY ARGUMENTS! PLEASE USE LESS ARGUMENTS!");
                return;
            }
            int size;
            if(args[0].equals("-check")){
                MagicSquare readMagicSquare = new MagicSquare(args[1]);
                System.out.println(readMagicSquare);
            }
            if(args[0].equals("-create")){
                if(Integer.parseInt(args[2]) % 2 != 0 && Integer.parseInt(args[2]) > 0){
                    size = Integer.parseInt(args[2]);
                    MagicSquare writeMagicSquare = new MagicSquare(args[1], size);
                    System.out.println(writeMagicSquare);
                }else{
                    System.out.println("INVALID OPTION! PLEASE CHOOSE AN ODD INTEGER!");
                }
            }
        }catch (IOException e){
            System.out.println("IOException thrown.");
        }
    }
}
