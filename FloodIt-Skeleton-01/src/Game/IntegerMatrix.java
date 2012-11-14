/**
 * Class for handling a square matrix of integers.
 */
package Game;

import java.util.Random;

public class IntegerMatrix {
    int [][] data;
    int size;
    
    public IntegerMatrix(int size){
        data = new int[size][size];
        this.size = size;
    }
    
    public int getSize(){
        return size;
    }
    
    public int get(int x, int y){
        int value = -1;
        if (inBounds(x, y)){
            value = data[x][y];
        }
        return value;
    }
    
     
    public void set(int x, int y, int value){
        if (inBounds(x,y)){
            data[x][y] = value;
        }
    }

    private boolean inBounds(int x, int y){
        return (x < size && y < size);
    }
     
    public void fillRandom(int minValue, int maxValue){
        Random r = new Random();
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                set(i, j, r.nextInt(maxValue - minValue + 1) + minValue);
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++){
            sb.append("\n");
            
            for (int j=0; j<size; j++) {
                sb.append(get(i, j)).append("  ");
            }
        }
        return sb.toString();
    }
}
