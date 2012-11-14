/**
 * MVC Pattern: CONTROLLER
 * http://www.oracle.com/technetwork/articles/javase/mvc-136693.html
 * http://msdn.microsoft.com/en-us/library/ff649643.aspx
 * 
 * The controller translates the user's interactions with the view into 
 * actions that the model will perform. 
 * 
 * Depending on the context, a controller may also select a new view 
 * to present back to the user.
 */
package Patterns.MVCGame;

import Patterns.Observer.IObserver;
import Patterns.Observer.AbstractSubject;

public abstract class AbstractGameController extends AbstractSubject implements IObserver{    
    
    public abstract void run();

    /**
     * Classic MVC
     */
    protected AbstractGameModel model;
    protected AbstractGameView view;
    
    public void setModel(AbstractGameModel model){
        this.model = model;
    }
    
    public void setView(AbstractGameView view){
        this.view = view;
        this.view.attachObserver(this);
    }

    
}
