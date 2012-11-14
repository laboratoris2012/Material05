/*
 * OBSERVER Pattern
 * http://www.oodesign.com/observer-pattern.html
 * 
 * Defines a one-to-many dependency between objects so that when one object 
 * changes state, all its dependents are notified and updated automatically.
 * 
 * OBSERVER: is the one that is notified by SUBJECT changes
 * 
 * This is the interface defining the operations to be used to notify this object.
 */
package Patterns.Observer;

public interface IObserver {
    public void update();
}
