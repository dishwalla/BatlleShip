package com.pukhova.battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olga_Pukhova on 10/10/2016.
 */
public class Frame extends JApplet{

    final static BasicStroke stroke = new BasicStroke(1.0f);
    private Cell[][] frame = EntryPoint.frame;
   // public static Map<Integer, Integer> coordinates = Cell.cellCoordinates;
    //public static Map<Map<Integer, Integer>, Integer> cells = new HashMap<>();
    public int cellsNumber = 1;
    public Cell.CellState state;
    public Cell currentCell;

   public static void main(String s[]) {
    /*    Frame frame = new Frame();
       JFrame myFrame=new JFrame("Test");
       myFrame.add(frame);
       myFrame.pack();
       myFrame.setVisible(true);
       frame.init();*/
       // System.out.println("test");
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);
        int y = 5;
        g2.setStroke(stroke);
        for (int i = 0; i <=frame.length-1; i++) {
            int x = 5;
            if (i>0) y += 20;
            for (int j = 0; j <= frame.length-1; j++) {
                g2.draw(new Rectangle2D.Double(x, y, 20, 20));
                //  if (i%2 ==0 && j%2==0) {g2.setColor(Color.RED);} else g2.setPaint(Color.gray);
                x += 20;
                currentCell = frame[i][j];
                currentCell = new Cell();
               state = Cell.CellState.EMPTY;
               currentCell.setState(state);

             //  Cell.cellCoordinates.put(x, y);
             //   Cell.cells.put(cellsNumber, Cell.cellCoordinates);
                if (cellsNumber == 100) break; else
                    cellsNumber++;
            }
        }
        System.out.println(cellsNumber);
        System.out.println(currentCell.getState());
       //System.out.println(Cell.cellCoordinates);


        // System.out.println(Cell.cellCount);
        //  for (int i = 0; i <= frame.length - 1; i++) {
        //    for (int j = 0; j <= frame.length - 1; j++)
        // System.out.println(coordinates.size());

    }

    public void init() {
        setBackground(Color.white);
        setForeground(Color.white);
    }

    public void drawFrame() {
                JFrame f = new JFrame("");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet = new Frame();
        Frame frame = new Frame();
        f.add(frame);
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(220, 220));
       /* Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //applet.method();
            }
        });
        t.start(); */
    }

    public void drawVisitedCell(){

    }

    public void drawPaddedCell(){

    }

}
