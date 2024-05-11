import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row, column;
        System.out.println("\n*** WELCOME TO THE MINE SWEEPER GAME ***\nDetermine the size of board:");
        do {    //DEĞERLENDİRME 7
            Scanner input = new Scanner(System.in);
            System.out.print("Row Number: ");
            row = input.nextInt();
            System.out.print("Column Number: ");
            column = input.nextInt();

            if ((row < 2) || (column < 2)) {        //Check the board size is greater than 2*2
                System.out.println("\nPlease, enter the row and column numbers greater than 2!");
            }
        } while ((row < 2) || (column < 2));

        MineSweeper mineSweeper = new MineSweeper(row, column);
        mineSweeper.playGame();
    }
}