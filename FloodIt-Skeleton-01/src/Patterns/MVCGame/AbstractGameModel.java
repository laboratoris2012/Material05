/**
 * MVC Pattern: MODEL
 * http://www.oracle.com/technetwork/articles/javase/mvc-136693.html
 * http://msdn.microsoft.com/en-us/library/ff649643.aspx
 * 
 * The model represents data AND the rules that govern access to and updates 
 * of this data. 
 * 
 * The model manages the behavior and data of the application domain, 
 * responds to requests for information about its state (usually from the view), 
 * and responds to instructions to change state (usually from the controller).
 * 
 * The model does NOT depend on the controller or the view.
 */
package Patterns.MVCGame;

import Game.IntegerMatrix;
import Patterns.Observer.AbstractSubject;

public abstract class AbstractGameModel extends AbstractSubject{
   
    // Game specific methods
   public abstract void createNewGame();
   public abstract void makeMove(int move);
   public abstract IntegerMatrix getGameBoard();        
}
