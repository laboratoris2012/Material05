package Game;

import Patterns.MVCGame.AbstractGameModel;

public class FloodItModel extends AbstractGameModel {
    private IntegerMatrix gameBoard;
    private int boardSize;
    private int nrOfColors;
 
    public FloodItModel(){
        boardSize = 5;
        nrOfColors = 6;
        gameBoard = new IntegerMatrix(boardSize);  
    }
    
    @Override
    public void createNewGame() {
        gameBoard.fillRandom(1, nrOfColors);
        notifyObservers();  
    }

    @Override
    public void makeMove(int move) {
        Flood(move);
        notifyObservers();
    }

    @Override
    public IntegerMatrix getGameBoard() {
        return gameBoard;
    }
   
    /**
     * Begins flooding with a specific color, from the top most coordinate.
     * 
     * @param floodColor the flooding color :) 
     */
    private void Flood(int floodColor){
        int oldColor = gameBoard.get(0, 0);     
        
        FloodFill(0, 0, oldColor, floodColor);
    }
    
    /**
     * One variation of the FloodFill algorithm as described on Wikipedia:
     * http://en.wikipedia.org/wiki/Flood_fill#The_algorithm
     * 
     * @param x The x axis coordinate of the starting flood point
     * @param y The y axis coordinate of the starting flood point
     * @param oldColor  The color that must be flooded (needs to be replaced)
     * @param newColor  The flooding color.
     */
    private void FloodFill(int x, int y, int oldColor, int newColor){
        if (x >= 0 && x < gameBoard.getSize() &&
            y >= 0 && y < gameBoard.getSize() &&
            oldColor != newColor){
        
            if (gameBoard.get(x, y) == oldColor){
                gameBoard.set(x, y, newColor);
                
                FloodFill (x+1, y, oldColor, newColor);
                FloodFill (x, y+1, oldColor, newColor);
                FloodFill (x-1, y, oldColor, newColor);
                FloodFill (x, y-1, oldColor, newColor);        
            }
        }
    }
    

}
