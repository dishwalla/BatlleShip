package com.pukhova.battleship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class Cell implements Markable{
    private int index;

    public enum CellState {EMPTY, VISITED, PADDED};
    public Map<Integer, Integer> cellCoordinates = new HashMap<>();
    public static Map<Integer, Map<Integer, Integer>> cells = new HashMap<>();

    public Cell(){};

    public Cell(int index, Map<Integer, Integer> coordinates){
        this.index = index;
        cells.put(index, coordinates);
    }
    @Override
    public void markCell(CellState state) {

    }

    @Override
    public void markAsShip() {
    }

    @Override
    public void markAsVisited() {
    }

}
