package com.pukhova.battleship;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public interface Markable {

    public void markAsShip();
    public void markAsVisited();
    default void markCell(Cell.CellState state){};
  //  default void markShip(Ship.ShipState state){};
}
