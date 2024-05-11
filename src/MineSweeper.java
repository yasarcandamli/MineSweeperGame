import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    String[][] gameMap;         //2D array representing the game map
    String[][] gameBoard;       //2D array representing the game board
    int row;                    //Numbers of rows of the game map
    int column;                 //Numbers of columns of the game map
    int selectedRow;            //User selected row coordinate
    int selectedColumn;         //User selected column coordinate
    int size;                   //Total number of cells on the game map
    int mineAmount;             //Number of mines on the game map
    int roundNumber;            //Number of game rounds
    //Constructor method called when the game is started
    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.gameMap = new String[row][column];
        this.gameBoard = new String[row][column];
        this.size = row * column;
        this.mineAmount = size / 4;             //Calculating the number of mines
        this.roundNumber = size - mineAmount;   //Calculating the number of game rounds
    }
    //The method of for playing the game
    public void playGame() {
        initializeGameMap();
        placeMines();
        printGameMap();         //Game map was printed at the beginning for ease of control of the project!
        initializeGameBoard();
        //Continue until the game is finished
        while (!isGameFinished()) {     //DEĞERLENDİRME 11
            printGameBoard();
            takeUserInput();
            if (isValidUserInput()) {       //Check if the inputs from the user are valid
                if (isMineSelected()) {     //Check for mines in the selected cell
                    countAdjacentMines();   //Count the mines in the adjacent cells
                } else {
                    break;                  //If a mine was found, get out of the loop
                }
            } else {
                continue;                   //If inputs from the user are invalid, continue the loop
            }
            roundNumber--;                  //Reduce the number of rounds
        }
    }
    //The method for initializing the game map
    public void initializeGameMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                gameMap[i][j] = " - ";
            }
        }
    }
    //The method for placing mines randomly
    public void placeMines() {      //DEĞERLENDİRME 8
        Random random = new Random();
        while (mineAmount > 0) {
            int randomRow = random.nextInt(row);
            int randomColumn = random.nextInt(column);

            if (!(gameMap[randomRow][randomColumn].equals(" * "))) {
                gameMap[randomRow][randomColumn] = " * ";   //Place a mine in a random cell
                mineAmount--;
            }
        }
    }
    //The method for printing the game map
    public void printGameMap() {
        System.out.println("\nGAME MAP:");
        for (String[] row : gameMap) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    //The method for initializing the game board
    public void initializeGameBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                gameBoard[i][j] = " - ";
            }
        }
    }
    //The method for printing the game board
    public void printGameBoard() {
        System.out.println("\nGAME BOARD:");
        for (String[] row : gameBoard) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    //The method for receiving input from the user
    public void takeUserInput() {       //DEĞERLENDİRME 9
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease, enter the coordinates of the cell you want to select.\nRow \t(Between 0 - " + (row - 1) + "): ");
        selectedRow = input.nextInt();
        System.out.print("Column \t(Between 0 - " + (column - 1) + "): ");
        selectedColumn = input.nextInt();
    }
    //The method for checking the validity of user input
    public boolean isValidUserInput() {
        if ((selectedRow >= 0 && selectedRow < row) && (selectedColumn >= 0 && selectedColumn < column)) {
            if (gameBoard[selectedRow][selectedColumn].equals(" - ")) {     //DEĞERLENDİRME 10
                return true;
            } else {
                System.out.println("\nYou've already selected this cell! Please, select another cell.");
                return false;
            }
        } else {
            System.out.println("\nInvalid input! Row and column must be within the board limits.");
            return false;
        }
    }
    //The method for checking the mine in the selected cells
    public boolean isMineSelected() {       //DEĞERLENDİRME 13
        if (gameMap[selectedRow][selectedColumn].equals(" * ")) {
            System.out.println("\n*** YOU SELECTED THE CELL CONTAINS MINE! GAME OVER! ***");       //DEĞERLENDİRME 15
            printGameMap();
            return false;       //Mine selected, end of the game
        } else {
            return true;        //Mine isn't selected, game continues
        }
    }
    //The method for counting the mines in adjacent cells of the selected cell
    public void countAdjacentMines() {      //DEĞERLENDİRME 12
        int mineCounter = 0;
        for (int i = selectedRow - 1; i <= selectedRow + 1; i++) {
            for (int j = selectedColumn - 1; j <= selectedColumn + 1; j++) {
                if ((i >= 0) && (i < row) && (j >= 0) && (j < column) && (gameMap[i][j].equals(" * "))) {
                    mineCounter++;
                }
            }
        }
        gameBoard[selectedRow][selectedColumn] = " " + mineCounter + " ";
    }
    //The method for checking the game is finished
    public boolean isGameFinished() {       //DEĞERLENDİRME 14
        if (roundNumber > 0) {
            return false;
        } else {
            System.out.println("\n*** CONGRATULATIONS YOU WIN! ***");       //DEĞERLENDİRME 15
            printGameMap();
            return true;
        }
    }
}