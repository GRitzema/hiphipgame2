package game;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class PlayGame {
    
    public static void main(String[] args) {
        System.out.println("Welcome to SPHINX.  Please type \"help\" for possible commands");
        Game game = new Game();   // reference to the game object
        Parser parser = new Parser(game); // reference to the actions that can be taken

        while (! game.isOver()) 
            parser.executeTurn(game);
    }
    
}
