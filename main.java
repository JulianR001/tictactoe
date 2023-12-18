import java.util.Scanner;
public class main {
    //variables
    static int playernum = 0;
    static Scanner input = new Scanner(System.in);
    static String response = new String();
    static int[] playerMove = new int[2];
    static int x, y;
    static String XO = "X";
    static String[][] board = new String[3][3];
    public static void runboard() {
        System.out.println("Lets play TicTacToe");      
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = "[ ]";
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println("Player X make the first move, (row, column)");
       
        while(HasWon() == false) {
            printBoard();
        }
        
        if(XO.equals("X")) XO = "O"; else XO = "O";
        System.out.println("player " + XO + " Has won the game, would you like to play agian Y/N");
        //end of game
        response = input.nextLine(); 
        if(response.equals("Y")) runboard(); else System.out.print("goodbye");
    }

    public static int[] GetResponse() {
        response = input.nextLine();
        boolean done = false;;
        while(!done) {
            done = true;
            //if move is within range
            if((playerMove[0] > 2 || playerMove[0] < 0) || (playerMove[1] > 2 || playerMove[1] < 0)) 
                done = false;
            //assigns coordinates to array
            playerMove[0] = Integer.parseInt(response.substring(0,1));
            playerMove[1] = Integer.parseInt(response.substring(3));
           
            //checks if current move has been been made
            if(board[playerMove[0]][playerMove[1]] != "[ ]") done = false;
            if(done == false) {
                System.out.println("invalid input, re try, (row, column)");
                response = input.nextLine();
            }
        }
        return playerMove;
    }

    public static boolean HasWon() {
        for(int x = 0; x < 3; x++) {
            //checks columns and rows
            if(board[x][0].equals(board[x][1]) && board[x][1].equals(board[x][2]) && !board[x][0].equals("[ ]")) return true;
            if(board[0][x].equals(board[1][x]) && board[1][x].equals(board[2][x]) && !board[0][x].equals("[ ]")) return true;
        }
        //checks diagnols
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("[ ]")) return true;
        if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("[ ]")) return true;
        return false;
    }

    public static void printBoard() {
        GetResponse();
        x = playerMove[0];
        y = playerMove[1];
        board[x][y] = "[" + XO + "]";
        if(playernum%2 == 1) XO = "X"; else XO = "O";
        playernum++; //advance rounds
        //print new board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println("make your move player " + XO + " (row, column)");
    }
}
