package com.pukhova.battleship;

import java.awt.*;
import java.util.*;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class EntryPoint {

    //public Map<Integer, Integer> ships = new HashMap<>();
    public static Cell[][] frame = new Cell[10][10];
    public static Cell[][] counterpartysframe = new Cell[10][10];
    //public static Map<Map<Integer, Integer>, Integer> ships = new HashMap<>();
    //public static Map<Integer, Integer> shipCoordinates = new HashMap<>();
    public static Map<Integer, Boolean> shipDetails = new HashMap<>();
    public static Map<Integer, Map<Boolean, Integer>> ship = Ship.shipDetails;
    public static Map<Integer, Map<Integer, Integer>> cellsDetails = Cell.cells;
    private int shipsNumber =1;

   /* public static void main(String s[]) {
         Frame f = new Frame();
         f.drawFrame();
        // System.out.println(f.getCellsNumber());
    }

    /*public static void main(String[] args) {
        EntryPoint ep = new EntryPoint();
        ep.ships.put(1, 4);
        ep.ships.put(2, 3);
        ep.ships.put(3, 2);
        ep.ships.put(4, 1);
    } */

    public void placeTheShips(){
        Random r = new Random();

        for (int i=0; i<10; i++){
            shipDetails.put(shipsNumber, r.nextBoolean());
            shipsNumber++;
        }

        for (int i=0; i<10; i++){
            int k =(getRandomNumberInRange(1, 100));
            cellsDetails.get(k);
            //ship.put(cellsDetails.get(k), ship(k, ));
        }


    }
    public void drawMyFrame(){

    }

    public void drawCounterpartysFrame(){

    }
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
