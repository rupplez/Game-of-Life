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
	
	static int iter = 0;
	
    Cell[][] grid;
	
    public GraphicsDriver() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setContentPane(new DrawingArea());
        
        setSize(800,800);
        setVisible(true);
    }
	public void displayBoard(Board board) {
        setTitle("Game of Life"+" - Generation: "+iter);
		
        grid = board.getGrid();
        
        x = 0;
        y = 0;
        
        repaint();
        
        iter++;
        
	}
    class DrawingArea extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            for (Cell[] row : grid) {
                for (Cell c : row) {
                   if(c.getState()) {
                       g.fillRect(x,y,size,size);
                       //g.fillOval(x,y,size,size);
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
