import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row, column;
        char player = 'X';

        //create 2 dimensional array for tic tac toe board
        char[][] board = new char[3][3];
        char ch = '1';
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                board[i][j] = ch++;
            }
        }
        displayBoard(board);
        while(!winner(board) == true){

            //get input for row/column
            System.out.println("Enter a row and column (0, 1, or 2); for player " + player + ":");
            row = in.nextInt();
            column = in.nextInt();

            //occupied
            while (board[row][column] == 'X' || board[row][column] == 'O') {
                System.out.println("This spot is occupied. Please try again");
            }
            //place the X
            board[row][column] = player;
            displayBoard(board);

            if (winner(board)){
                System.out.println("Player " + player + " is the winner!");
            }

            //time to swap players after each go.
            if (player == 'O') {
                player = 'X';

            }
            else {
                player = 'O';
            }
            if (winner(board) == false) {
            System.out.println("The game is a draw. Please try again.");

        }

    }

    private static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == board[i].length - 1) System.out.print(board[i][j]);
                else System.out.print( board[i][j] + " | ");
            }
            System.out.println();
        }


    }
    //method to determine whether there is an x or an o in the spot
    public static Boolean winner(char[][] board){
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' || board[i][j] == 'X') {
                    return false;
                }
            }
        }

        return (board[0][0] == board [0][1] && board[0][0] == board [0][2]) ||
            (board[0][0] == board [1][1] && board[0][0] == board [2][2]) ||
            (board[0][0] == board [1][0] && board[0][0] == board [2][0]) ||
            (board[2][0] == board [2][1] && board[2][0] == board [2][2]) ||
            (board[2][0] == board [1][1] && board[0][0] == board [0][2]) ||
            (board[0][2] == board [1][2] && board[0][2] == board [2][2]) ||
            (board[0][1] == board [1][1] && board[0][1] == board [2][1]) ||
            (board[1][0] == board [1][1] && board[1][0] == board [1][2]);
    }
}