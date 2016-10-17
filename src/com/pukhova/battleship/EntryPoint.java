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
    public static Map<Integer, Boolean> shipsPosition = new HashMap<>();
    public static List<Cell> ships = new ArrayList<>();
    public static List<Cell> cells = new ArrayList<>();
    public static List<Cell> bookedCells = cells;
    //public int[] n = new int[10];
    public static Set<Integer> randomNumbers = new HashSet<Integer>();
    public static List<Integer> sortedList = new ArrayList();
    // public Integer[] n = new Integer[randomNumbers.size()];
    //Iterator<Cell> itr = cells.iterator();
    public Cell currentCell;
    public Ship currentShip;
    private int shipsNumber = 1;
    public int cellsNumber = 1;
    public int counter = 1;
    public Cell.CellState state;

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
        for (Map.Entry<Integer, Boolean> entry : shipsPosition.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            System.out.println(key + " " + value);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.printf((frame[i][j]).isAShip()+ " ");
                System.out.printf((frame[i][j].state).toString() + " ");
                // System.out.printf((frame[i][j].state).toString() + " " + (frame[i][j]).getX() + " " + (frame[i][j]).getY() +  " " + frame[i][j].getIndex());
            }
            System.out.println();
        }

        sortedList = new ArrayList(randomNumbers);
        Collections.sort(sortedList);
        for (Integer i : sortedList) {
            System.out.printf(i + " ");
        }

        System.out.println();
        for (Cell cell : ships) {
            System.out.printf(String.valueOf(cell.getIndex()) + " ");
        }
        System.out.println();
        for (Cell cell : bookedCells) {
            System.out.printf(String.valueOf(cell.getState()) + " ");
        }
        System.out.println();
        for (Cell cell : cells) {
            System.out.printf(String.valueOf(cell.getState()) + " ");
        }
    }

    public void createShipsSet() {
//randomizing ships on the frame
        Cell[][] newFrame = new Cell[10][10];
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
            shipsPosition.put(currentShip.getIndex(), currentShip.isPosition());
            while (pickTheShipArray != null) {
                int random = r.nextInt(pickTheShipArray.size());
                currentShip.setCellsQuantity(pickTheShipArray.get(random));
                shipsSize.put(currentShip.getIndex(), currentShip.getCellsQuantity());
                pickTheShipArray.remove(random);
                break;
            }
            shipsNumber++;
        }
      /*  while(randomNumbers.size() < 10) {
            randomNumbers.add(getRandomNumberInRange(1, 100));
        }
        n = randomNumbers.toArray(n); */
        while (counter != 10) {
            //   for (int h = 1; h <=10; h++) {
            //int tempRandom = getRandomNumberInRange(1, 100);
            //randomNumbers.add(tempRandom);
            int random = r.nextInt(bookedCells.size());
            Cell cell = bookedCells.get(random);
            cell.setState(Cell.CellState.SHIP);
            cell.setAShip(true);
            ships.add(cell);
            // bookedCells.remove(random);

            //  currentShip.setCellsQuantity(pickTheShipArray.get(random));
            //  shipsSize.put(currentShip.getIndex(), currentShip.getCellsQuantity());
            //  pickTheShipArray.remove(random);

            boolean b = shipsPosition.get(counter);
            int k = shipsSize.get(counter);

            if (cell.getState() == Cell.CellState.SHIP && k > 1 && b == true) {
                switch (k) {
                    case 2:
                        cells.get(cell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 1).setAShip(true);
                        bookedCells.remove(cell.getIndex());
                        bookedCells.remove(cell.getIndex() + 1);
                        break;
                    case 3:
                        cells.get(cell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 2).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 1).setAShip(true);
                        cells.get(cell.getIndex() + 2).setAShip(true);
                        bookedCells.remove(cell.getIndex());
                        bookedCells.remove(cell.getIndex() + 1);
                        bookedCells.remove(cell.getIndex() + 2);
                        break;
                    case 4:
                        cells.get(cell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 2).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 3).setState(Cell.CellState.SHIP);
                        cells.get(cell.getIndex() + 1).setAShip(true);
                        cells.get(cell.getIndex() + 2).setAShip(true);
                        cells.get(cell.getIndex() + 3).setAShip(true);
                        bookedCells.remove(cell.getIndex());
                        bookedCells.remove(cell.getIndex() + 1);
                        bookedCells.remove(cell.getIndex() + 2);
                        bookedCells.remove(cell.getIndex() + 3);
                        break;
                }
            } else if (cell.getState() == Cell.CellState.SHIP && k > 1 && b == false) {
                switch (k) {
                    case 2:
                        if (cell.getIndex() <= 90) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            bookedCells.remove(cell.getIndex());
                            bookedCells.remove(cell.getIndex() + 10);
                            break;
                        } else return;
                    case 3:
                        if (cell.getIndex() <= 80) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 20).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            cells.get(cell.getIndex() + 20).setAShip(true);
                            bookedCells.remove(cell.getIndex());
                            bookedCells.remove(cell.getIndex() + 10);
                            bookedCells.remove(cell.getIndex() + 20);
                            break;
                        } else return;
                    case 4:
                        if (cell.getIndex() <= 70) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 20).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 30).setState(Cell.CellState.SHIP);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            cells.get(cell.getIndex() + 20).setAShip(true);
                            cells.get(cell.getIndex() + 30).setAShip(true);
                            bookedCells.remove(cell.getIndex());
                            bookedCells.remove(cell.getIndex() + 10);
                            bookedCells.remove(cell.getIndex() + 20);
                            bookedCells.remove(cell.getIndex() + 30);
                            break;
                        } else return;
                }
            }
            counter++;
        }

    }
          /*  for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (frame[i][j].getIndex() == tempRandom) {
                        frame[i][j].setState(Cell.CellState.SHIP);
                        frame[i][j].setAShip(true);
                        ships.add(frame[i][j]);
                    }
                }
            } */

//This block sets ships on chosen places
  /*      for (int l = 0; l < n.length; l++) {
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
        }     */


// this loop adding required cells to the ships
/*        for (int k = 0; k < ships.size(); k++) {
            int l = shipsSize.get(k + 1);
            boolean b = shipsPosition.get(k + 1);
            Cell thisCell = ships.get(k);
            //Cell thisCell = cells.get(k);
            if (thisCell.getState() == Cell.CellState.SHIP && l > 1 && b == true) {
                switch (l) {
                    case 2:
                        cells.get(thisCell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        break;
                    case 3:
                        cells.get(thisCell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        cells.get(thisCell.getIndex() + 2).setState(Cell.CellState.SHIP);
                        break;
                    case 4:
                        cells.get(thisCell.getIndex() + 1).setState(Cell.CellState.SHIP);
                        cells.get(thisCell.getIndex() + 2).setState(Cell.CellState.SHIP);
                        cells.get(thisCell.getIndex() + 3).setState(Cell.CellState.SHIP);
                        break;
                }
            }
        }                        */

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
       /*     for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //System.out.printf((frame[i][j]).isAShip()+ " ");
                    System.out.printf((newFrame[i][j].state).toString() + " ");
                    // System.out.printf((frame[i][j].state).toString() + " " + (frame[i][j]).getX() + " " + (frame[i][j]).getY() +  " " + frame[i][j].getIndex());

                }
                System.out.println();
            } */


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

    public void drawCounterpartysFrame() {    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

