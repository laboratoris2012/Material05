/**
 * MVC Pattern: VIEW
 * http://www.oracle.com/technetwork/articles/javase/mvc-136693.html
 * 
 * The view renders the contents of a model. It specifies exactly how the 
 * model data should be presented. 
 * 
 * If the model data changes, the view must update its presentation as needed. 
 * This can be achieved by using a push model, in which the view registers 
 * itself with the model for change notifications, or a pull model, in which 
 * the view is responsible for calling the model when it needs to retrieve 
 * the most current data.
 * 
 * In this case, the View is an OBSERVER for the Model and a observation SUBJECT for 
 * the Controller
 */
package Patterns.MVCGame;

import Patterns.Observer.IObserver;
import Patterns.Observer.AbstractSubject;
import Game.IntegerMatrix;


public abstract class AbstractGameView  extends AbstractSubject implements IObserver {      
    
    // Game specific methods
    public abstract void show();
    public abstract void showMessage(String message);
    public abstract void refresh();
    public abstract void setDisplayData(IntegerMatrix data);
    public abstract int getLastMove();

    /**
     * Classic MVC
     */ 
    protected AbstractGameModel model;
    
    public void setModel(AbstractGameModel model){
        this.model = model;
        this.model.attachObserver(this);
    }
}
