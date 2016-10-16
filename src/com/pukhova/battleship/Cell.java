package com.pukhova.battleship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class Cell implements Markable{

    private int index;
    private boolean isAShip = false;
    public enum CellState {EMPTY, VISITED, PADDED, SHIP};
    public CellState state;
    private int x;
    private int y;
    //public Map<Integer, Integer> cellCoordinates = new HashMap<>();
    //public static Map<Integer, Map<Integer, Integer>> cells = new HashMap<>();

    public Cell(){}

    public Cell(int index, int x, int y){
        this.index = index;
        this.x = x;
        this.y = y;
    };

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    @Override
    public void markAsShip() {

    }

    public boolean isAShip() {
        return isAShip;
    }

    public void setAShip(boolean AShip) {
        isAShip = AShip;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void markAsVisited() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
