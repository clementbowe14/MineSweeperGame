
import java.util.*;

public class MineSweeper{

    private final int BOARD_ROWS = 4;
    private final int BOARD_COLS = 4;
    private int remainder;
    private int [][] matrix;
    private boolean [][] visited;
    boolean game;
    private int score;

    public MineSweeper(){
        remainder = 11;
        matrix = new int[BOARD_ROWS][BOARD_COLS];
        visited = new boolean[BOARD_ROWS][BOARD_COLS];
        score = 0;
        
        //initial values for the board
        for(int i = 0; i < BOARD_ROWS; i++){
            for(int j = 0; j < BOARD_COLS; j++){
                matrix[i][j] = (int)(Math.random()*9)+1;
            }
        }
        
        //placing the bombs in random locations within the matrix
        for(int i = 0; i < 5; i++){
            int x = (int)(Math.random()*4);
            int y = (int)(Math.random()*4);
            matrix[x][y] = -1;
        }

        displayBoard();
    }

    public int getScore(){
        return this.score;
    }

    public int getRemainder() {
        return this.remainder;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isGameOver() {
        return this.game;
    }

    public boolean getGame() {
        return this.game;
    }

    public void setGameOver() {
        this.game = !game;
    }

    public void move(int x, int y){
        if(x < 0 || y < 0 || x > matrix.length-1 || y > matrix.length-1 || visited[x][y]){
            System.out.println("Invalid move. Please try again.");
            return;
        }
        if(matrix[x][y] == -1){
            setGameOver();
            visited[x][y] = true;
            displayBoard();
            isWinner();
        }
        else{
            remainder--;
            visited[x][y] = true;
            score += matrix[x][y];
            displayBoard();
        }

        if(remainder == 0){
            setGameOver();
            isWinner();
        }
    }

    public void displayBoard(){
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j])
                    System.out.print(matrix[i][j] + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    public void isWinner(){
        if(game && remainder == 0){
            System.out.println("Congrats You won the game!");
        }
        else{
            System.out.println("Game Over.");
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
    
}