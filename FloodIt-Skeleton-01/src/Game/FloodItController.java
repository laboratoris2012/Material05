package Game;

import Patterns.MVCGame.AbstractGameController;

public class FloodItController extends AbstractGameController{
    
    @Override
    public void run() {     
        model.createNewGame();        
        view.show();
    }

     /**
     * from IObserver interface, because the Controller is an Observer for the View.
     * 
     * This function is called when the View sends a change event 
     * to the Controller. 
     * 
     * In our case, the only thing that is send is the selected move
     */
    @Override
    public void update(){
        int move = view.getLastMove();
        model.makeMove(move);
    }
}
