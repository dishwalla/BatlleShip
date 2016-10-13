package com.pukhova.battleship;

import java.util.*;
import java.util.List;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class EntryPoint {

    public static Cell[][] frame = new Cell[10][10];
    //public static Cell[][] counterpartysframe = new Cell[10][10];
    //public static Map<Integer, Integer> shipCoordinates = new HashMap<>();
    public static Map<Map<Integer, Integer>, Map<Integer, Boolean>> ships = Ship.shipDetails;
    public static Map<Integer, Integer> shipsSize = new HashMap<>();
    public static Map<Integer, Boolean> shipsPotition = new HashMap<>();
    //Ship.ship;
    public static Map<Integer, Map<Integer, Integer>> cellsDetails = Cell.cells;
    private int shipsNumber =1;
    public Ship.ShipState state;
    public Ship currentShip;

    public static void main(String s[]) {
        EntryPoint e = new EntryPoint();
        e.createShipsSet();
        System.out.println("\t");
        for (Map.Entry<Integer, Integer> entry : shipsSize.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println("\t");
        for (Map.Entry<Integer, Boolean> entry : shipsPotition.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            System.out.println(key + " " + value);
        }

    }

    public void createShipsSet(){
        Random r = new Random();
        int[] pickTheShip = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> pickTheShipArray = new ArrayList<Integer>();
        for (int i: pickTheShip) {
            pickTheShipArray.add(i);
        }
        for (int i=1; i<=10; i++){
            currentShip = new Ship();
            currentShip.setIndex(shipsNumber);
            // System.out.println(currentShip.getIndex());
            boolean b = r.nextBoolean();
            currentShip.setPosition(b);
            //System.out.println(currentShip.isPosition());
            shipsPotition.put(currentShip.getIndex(), currentShip.isPosition());
            while(pickTheShipArray != null){
                int random = r.nextInt(pickTheShipArray.size());
                currentShip.setCellsQuantity(pickTheShipArray.get(random));
                // System.out.println(currentShip.getCellsQuantity());
                shipsSize.put(currentShip.getIndex(), currentShip.getCellsQuantity());
                pickTheShipArray.remove(random);
                break;
            }
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
