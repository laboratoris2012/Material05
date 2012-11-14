/**
 * Simple MVC Pattern Example for Flood It GAME
 */
package Game;

import Patterns.MVCGame.AbstractGameModel;
import Patterns.MVCGame.AbstractGameView;
import Patterns.MVCGame.AbstractGameController;

public class Main {


    public static void main(String[] args) {
        AbstractGameModel model;
        model = new FloodItModel();
        
        AbstractGameView view;
        view = new FloodItConsoleView();        
        view.setModel(model);
        
        AbstractGameController controller;
        controller = new FloodItController();
        controller.setModel(model);
        controller.setView(view);

        controller.run();
        
    }
}
