import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String choice = "";
        
        do {
            System.out.println("Welcome to the MineSweeper Game!");
            System.out.println("Get Ready to Play!\n\n");
            MineSweeper game = new MineSweeper();
            while(!game.isGameOver()){
                System.out.println("\n");
                System.out.println("Pick a position.");
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println("\n");
                game.move(x, y);
            }
            System.out.println("Final Score: " + game.getScore());
            System.out.println("Would you like to play again? Enter Y for Yes and N for no.");
            while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")){
                choice = in.next();
            }
        }while(!choice.equalsIgnoreCase("N"));
    }
}
