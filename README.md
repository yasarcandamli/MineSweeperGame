# Mine Sweeper Game

## Introduction
This project is a Mine Sweeper game developed using the Java programming language. In this game, the user tries to uncover hidden mines on a game board while avoiding clicking on them. The game ends when the user either uncovers all mines or clicks on a mine.

## Features
- Customizable game board size: The user can specify the size of the game board.
- Mine placement: Mines are randomly placed on the game board.
- User input validation: The user input is validated to prevent incorrect inputs.
- Game state representation: The game board is shown to the user at each step.
- End game and win condition check: The game ends when all mine-free cells are uncovered without clicking on a mine or when the user clicks on a mine.

## How to Run
1. Copy the project files to a directory.
2. Open a terminal or command prompt.
3. Navigate to the directory where the project is located.
4. Compile the Java files by entering the command `javac Main.java MineSweeper.java`.
5. Run the compiled files by entering the command `java Main`.
6. The game will start, and instructions will be displayed on the screen.

## User Input Instructions
- When the game starts, the user is prompted to specify the size of the game board.
- After entering the number of rows and columns, the game begins.
- Row and column numbers are indexed starting from zero.
- To select a cell, the user must input the row and column numbers.
