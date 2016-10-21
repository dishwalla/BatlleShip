package com.pukhova.battleship;

import java.util.*;
import java.util.List;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class EntryPoint {
    //public static Cell[][] counterpartysframe = new Cell[10][10];
    // public static List<Cell> bookedCells = cells;
    // public Integer[] n = new Integer[randomNumbers.size()];
    //Iterator<Cell> itr = cells.iterator();
    //public static List<Integer> sortedList = new ArrayList();
    public static Cell[][] frame = new Cell[10][10];
    public static Map<Integer, Integer> shipsSize = new LinkedHashMap<>();
    public static Map<Integer, Boolean> shipsPosition = new LinkedHashMap<>();
    public static List<Cell> chosenShips =  new ArrayList<>();
    public static List<Cell> cells = new ArrayList<>();
    public static List<Ship> ships = new ArrayList<>();
    public static Set<Integer> randomNumbers = new HashSet<Integer>();
    public static Set<Integer> randomNumbers2 = new HashSet<Integer>();

    public Cell currentCell;
    public Ship currentShip;
    private int shipsNumber = 0;
    public int cellsNumber = 0;
    public Cell.CellState state;

    public static void main(String s[]) {
        EntryPoint e = new EntryPoint();
        e.drawMyFrame();
        e.createShipsSet();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (frame[i][j].state == Cell.CellState.SHIP || frame[i][j].state == Cell.CellState.PADDED || frame[i][j].state == Cell.CellState.VISITED)
                    System.out.printf("X");
                else if (frame[i][j].state == Cell.CellState.EMPTY) System.out.printf("O");
                // System.out.printf((frame[i][j].state).toString() + " ");
                // System.out.printf((frame[i][j].state).toString() + " " + (frame[i][j]).getX() + " " + (frame[i][j]).getY() +  " " + frame[i][j].getIndex());
            }
            System.out.println();
        }
        System.out.println();
        for (Cell cell : chosenShips) {
            System.out.printf(String.valueOf(cell.getState()) + String.valueOf(cell.getIndex()) + " ");
        }
        System.out.println();
        System.out.println(chosenShips.size());
        System.out.println();
        for (Ship ship : ships) {
            System.out.printf(String.valueOf(ship.getIndex()) + " " + String.valueOf(ship.getCellsQuantity()) + " " +String.valueOf(ship.isPosition()) + "|");
        }
/*
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

        // sortedList = new ArrayList(randomNumbers);
        // Collections.sort(sortedList);
        //  for (Integer i : sortedList) {
        //      System.out.printf(i + " ");
        //  }

       for (Integer i : randomNumbers) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for (Integer i : randomNumbers2) {
            System.out.printf(i + " ");
        }
         System.out.println();
        for (Cell cell : cells) {
            System.out.printf(String.valueOf(cell.getState()) + String.valueOf(cell.getIndex()) + " ");
        }
       System.out.println();
        for (Cell cell : bookedCells) {
            System.out.printf(String.valueOf(cell.getState()) + " ");
        } */

    }

    public void createShipsSet() {
        Cell[][] newFrame = new Cell[10][10];
        Random r = new Random();
        int[] pickTheShip = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> pickTheShipArray = new ArrayList<Integer>();
        for (int i : pickTheShip) {
            pickTheShipArray.add(i);
        }
        for (int i = 0; i < 100; i++) {
            randomNumbers2.add(i);
        }
        for (int i = 0; i < 10; i++) {
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
            ships.add(currentShip);
            shipsNumber++;
        }

        while (randomNumbers.size() != 10) {
            int random = getRandomNumberInRange(0, 99);
            randomNumbers.add(random);
            Cell cell = cells.get(random);
            cell.setState(Cell.CellState.SHIP);
            cell.setAShip(true);
            chosenShips.add(cell);
            randomNumbers2.remove(random);
            boolean b = ships.get(randomNumbers.size()-1).isPosition();
            int k = ships.get(randomNumbers.size()-1).getCellsQuantity();
            if (k > 1 && b == true) {
                switch (k) {
                    case 2:
                        if (cell.getIndex()%10 <= 8) {
                            cells.get(cell.getIndex() + 1).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 1).setAShip(true);
                            break;
                        } else {}
                    case 3:
                        if (cell.getIndex()%10 <= 7) {
                            cells.get(cell.getIndex() + 1).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 2).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 1).setAShip(true);
                            cells.get(cell.getIndex() + 2).setAShip(true);
                            break;
                        } else {}
                    case 4:
                        if (cell.getIndex()%10 <= 6) {
                            cells.get(cell.getIndex() + 1).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 2).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 3).setState(Cell.CellState.PADDED);
                            cells.get(cell.getIndex() + 1).setAShip(true);
                            cells.get(cell.getIndex() + 2).setAShip(true);
                            cells.get(cell.getIndex() + 3).setAShip(true);
                            break;
                        } else {}
                }
            }
            else if (k > 1 && b == false) {
                switch (k) {
                    case 2:
                        if (cell.getIndex() < 90) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            break;
                        }
                        else {}
                    case 3:
                        if (cell.getIndex() < 80) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 20).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            cells.get(cell.getIndex() + 20).setAShip(true);
                            break;
                        }
                        else {}
                    case 4:
                        if (cell.getIndex() < 70) {
                            cells.get(cell.getIndex() + 10).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 20).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 30).setState(Cell.CellState.VISITED);
                            cells.get(cell.getIndex() + 10).setAShip(true);
                            cells.get(cell.getIndex() + 20).setAShip(true);
                            cells.get(cell.getIndex() + 30).setAShip(true);
                            break;
                        } else {}
                }
            }
        }
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

