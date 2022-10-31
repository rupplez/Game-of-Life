package gof.gui;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gof.core.Board;
import gof.core.Cell;
import gof.core.DisplayDriver;

public class GraphicsDriver extends JFrame implements DisplayDriver {
	private int x, y;
	private int size = 10;
	Color color = Color.black;
	
    Cell[][] grid;
	
	public void displayBoard(Board board) {
        setTitle("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        grid = board.getGrid();
        
        x = 0;
        y = 0;
        
        setContentPane(new DrawingArea());
        
        setSize(300,300);
        setVisible(true);
	}
    class DrawingArea extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            for (Cell[] row : grid) {
                for (Cell c : row) {
                   if(c.getState()) {
                       g.fillRect(x,y,size,size);
                   }
                   x+=size;
                   //System.out.println(x+" "+y);
                }
                x=0;
                y+=size;
            }
        }
    }
}
