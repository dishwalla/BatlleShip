package com.pukhova.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Olga_Pukhova on 10/11/2016.
 */
public class Ship implements Markable {

    private int index;
    private boolean position;
    private int cellsQuantity;
    public enum ShipState {DEFAULT, PADDED, KILLED};
    public ShipState state;
   //public static Map<Integer, Boolean> ship = new HashMap<>();
    public static Map<Map<Integer, Integer>, Map<Integer, Boolean>> shipDetails = new HashMap<>();
    public static Map<Integer, Integer> shipStartCoordinates = new HashMap<>();

    public Ship(){}

    public Ship(int index, boolean position, int cellsQuantity){
        this.index = index;
        this.position = position;
        this.cellsQuantity = cellsQuantity;
    }

    @Override
    public void markAsShip() {
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

    public void setPosition(boolean position) {
        this.position = position;
    }

    public int getCellsQuantity() {
        return cellsQuantity;
    }

    public void setCellsQuantity(int cellsQuantity) {
        this.cellsQuantity = cellsQuantity;
    }

    public boolean isPosition() {
        return position;
    }
}
