package Game;

import Patterns.MVCGame.AbstractGameView;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloodItConsoleView extends AbstractGameView{
    private IntegerMatrix gameBoard;
    private int lastMove = 0;
    
    @Override
    public void setDisplayData(IntegerMatrix gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void refresh() {
        System.out.println(gameBoard.toString());
    }

    /**
     * Displays the view on screen.
     * In this case, it presents a classic text menu for the user 
     */
    @Override
    public void show() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = "";
        
        while (!key.toLowerCase().equals("0")) {
            System.out.println("\nEnter your move (or press '0' to quit): ");
            
            try {
                key = br.readLine();
                this.lastMove = Integer.parseInt(key);
                this.notifyObservers();
            } catch(Exception ex) {
                System.out.println("\nUnknown Action: " + key);
            }
        }
    }

    /**
     * from IObserver interface, because the View is an Observer for the Model.
     * 
     * This function is called when the Model sends a change event 
     * to the View. 
     * 
     * In our case, the only thing that changes is the game board.
     */
    @Override
    public void update() {
        
        setDisplayData(this.model.getGameBoard());
        refresh();
    }

    @Override
    public int getLastMove() {
        return this.lastMove;
    }

    @Override
    public void showMessage(String message) {
        System.out.println("\nMESSAGE: " + message);
    }
    
}
