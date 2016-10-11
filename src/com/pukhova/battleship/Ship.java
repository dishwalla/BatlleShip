package com.pukhova.battleship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga_Pukhova on 10/11/2016.
 */
public class Ship implements Markable {
    private int index;
    private boolean position;
    private int cellsQuantity;
    public enum ShipState {DEFAULT, PADDED, KILLED};
    public static Map<Integer, Map<Boolean, Integer>> shipDetails = new HashMap<>();

    public Ship(int index, boolean position, int cellsQuantity){
        this.index = index;
        this.position = position;
        this.cellsQuantity = cellsQuantity;
    }

    @Override
    public void markShip(Ship.ShipState state) {

    }

    @Override
    public void markAsShip() {
    }

    @Override
    public void markAsVisited() {
    }

}
