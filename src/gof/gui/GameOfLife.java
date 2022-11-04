package gof.gui;

import java.util.Scanner;

import gof.core.Board;
import gof.core.DisplayDriver;

public class GameOfLife {

    public static void main(String[] args) throws Exception {
//        System.out.print("Please enter number of iterations to run: ");
//        Scanner in = new Scanner(System.in);
//        int iterations = in.nextInt();
//        in.close();
        DisplayDriver dd = Display.getDriver();
        Board b = new Board(80, 80, 0.3);

        while(true) {
            dd.displayBoard(b);
            b.update();
            Thread.sleep(100);
        }
    }
}
