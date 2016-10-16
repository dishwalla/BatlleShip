package com.pukhova.battleship;

import java.util.*;
import java.util.List;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class EntryPoint {

    //public static Cell[][] counterpartysframe = new Cell[10][10];
    public static Cell[][] frame = new Cell[10][10];
    public static Map<Integer, Integer> shipsSize = new HashMap<>();
    public static Map<Integer, Boolean> shipsPotition = new HashMap<>();
    public static List<Cell> ships = new ArrayList<>();
    public static List<Cell> cells = new ArrayList<>();
    public int[] n = new int[10];
    Iterator<Cell> itr = cells.iterator();

    private int shipsNumber = 1;
    public Ship.ShipState shipState;
    public Ship currentShip;

    public int cellsNumber = 1;
    public Cell.CellState state;
    public Cell currentCell;

    public static void main(String s[]) {
        EntryPoint e = new EntryPoint();
        e.drawMyFrame();
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

       /* for (Cell[] arr : frame) {
            System.out.println(Arrays.toString(arr));
        }*/

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.printf((frame[i][j]).isAShip()+ " ");
                System.out.printf((frame[i][j].state).toString() + " ");
                // System.out.printf((frame[i][j].state).toString() + " " + (frame[i][j]).getX() + " " + (frame[i][j]).getY() +  " " + frame[i][j].getIndex());

            }
            System.out.println();
        }
        for (Cell cell : ships) {
            System.out.printf(String.valueOf(cell.getIndex()) + " ");
        }
        for (Cell cell : cells) {
            System.out.printf(String.valueOf(cell.getState()) + " ");
        }

    }

    public void createShipsSet() {
        Random r = new Random();
        int[] pickTheShip = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> pickTheShipArray = new ArrayList<Integer>();
        for (int i : pickTheShip) {
            pickTheShipArray.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            currentShip = new Ship();
            currentShip.setIndex(shipsNumber);
            boolean b = r.nextBoolean();
            currentShip.setPosition(b);
            shipsPotition.put(currentShip.getIndex(), currentShip.isPosition());
            while (pickTheShipArray != null) {
                int random = r.nextInt(pickTheShipArray.size());
                currentShip.setCellsQuantity(pickTheShipArray.get(random));
                shipsSize.put(currentShip.getIndex(), currentShip.getCellsQuantity());
                pickTheShipArray.remove(random);
                break;
            }
            shipsNumber++;
        }

        for (int k = 0; k < 10; k++) {
            n[k] = (getRandomNumberInRange(1, 100));
            // System.out.println(n[k]);
        }

        for (int l = 0; l < n.length; l++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (frame[i][j].getIndex() == n[l]) {
                        frame[i][j].setState(Cell.CellState.SHIP);
                        frame[i][j].setAShip(true);
                        ships.add(frame[i][j]);
                        cells.add(frame[i][j].getIndex(), frame[i][j]);
                    }
                }
            }
        }

      /*  for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (frame[i][j].getState() == Cell.CellState.SHIP){
                    for (int k=1; k<=shipsSize.size(); k++){
                        int l =shipsSize.get(k);
                        boolean b = shipsPotition.get(k);
                        if (l == 1) {break;}
                        else if (l >1 && b == true){
                            frame[i+1][j].setState(Cell.CellState.SHIP);
                            frame[i+1][j].setAShip(true);
                        }
                    }
                }
            }} */


        for (int k = 0; k < ships.size(); k++) {
            int l = shipsSize.get(k + 1);
            boolean b = shipsPotition.get(k + 1);
            Cell thisCell = ships.get(k);
            if (thisCell.getState() == Cell.CellState.SHIP && l > 1 && b == true) {
                //thisCell.getIndex();
                  //     cells.get(thisCell.getIndex());

                            //   iterator().next().setState(Cell.CellState.SHIP);
                //thisCell.setState(Cell.CellState.PADDED);
                //       while(itr.hasNext()){
                //       itr.next().setState(Cell.CellState.PADDED);}
                //   }
                // itr.next().setState(Cell.CellState.PADDED);
                //   e.next().setState(Cell.CellState.PADDED);
                //for (int i = 0; i < 10; i++) {
                //for (int j = 0; j < 10; j++) {
                //frame[i][j].setState(Cell.CellState.PADDED);
                //frame[i][j].setAShip(true);
                //}
                //}
            }
            }
       // }
          /*  for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (frame[i][j].getState() == Cell.CellState.SHIP){
                        if (l == 1) {break;}
                        else if (l >1 && b == true){
                            frame[i+1][j].setState(Cell.CellState.SHIP);
                            frame[i+1][j].setAShip(true);
                        }
                    }
                }
            }*/
    }

    public void drawMyFrame() {
        char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int y = 5;
        char c = 'A';
        for (int i = 0; i <= frame.length - 1; i++) {
           // System.out.println(letters[i]);
            int x = 5;
            if (i > 0) y += 20;
            for (int j = 0; j <= frame.length - 1; j++) {
                // System.out.println(1);
                //  g2.draw(new Rectangle2D.Double(x, y, 20, 20));
                //  if (i%2 ==0 && j%2==0) {g2.setColor(Color.RED);} else g2.setPaint(Color.gray);
                x += 20;
                currentCell = new Cell(cellsNumber, x, y);
                frame[i][j] = currentCell;
                state = Cell.CellState.EMPTY;
                currentCell.setState(state);
                cells.add(currentCell);
                if (cellsNumber == 100) break;
                else
                    cellsNumber++;
            }
        }
    }

    public void drawCounterpartysFrame() {

    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

