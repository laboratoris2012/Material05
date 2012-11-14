/*
 * OBSERVER Pattern
 * http://www.oodesign.com/observer-pattern.html
 * 
 * Defines a one-to-many dependency between objects so that when one object 
 * changes state, all its dependents are notified and updated automatically.
 * 
 * SUBJECT: the object that can be observed. It will notify all it's observers
 * when the observed data changed.
 * 
 * this is the abstract class defining the operations for attaching 
 * and de-attaching observers to the client
 */
package Patterns.Observer;

import java.util.ArrayList;

public abstract class AbstractSubject {
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();
    
    public void attachObserver(IObserver obs){
        observers.add(obs);
    }
    
    public void detachObserver(IObserver obs){
        if (observers.contains(obs)){
            observers.remove(obs);
        }
    }
    
    public void notifyObservers(){
        for(IObserver obs : observers){
            obs.update();
        }
    }
}

