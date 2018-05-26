import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Board extends JComponent implements KeyListener {


    Hero heroO = new Hero();
    PositionedImage hero = new PositionedImage("hero-down.png", 0 ,0);


    public Board() {


        // set the size of your draw board
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        //graphics.fillRect(testBoxX, testBoxY, 100, 100);
        // here you have a 720x720 canvas
        // you can create and draw an image using the class below e.g.
        Maze maze = new Maze();
        maze.drawMaze(graphics);

        hero.draw(graphics);


    }

    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyPressed(KeyEvent e) {
        BoadOperation boadOperation = new BoadOperation(hero.posX,hero.posY);

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (hero.posY - 72 >= 0 && boadOperation.isPath(hero.posX,hero.posY-72)) {
                hero.posY -= 72;
                hero = new PositionedImage("hero-up.png", hero.posX, hero.posY);
            }

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            if (hero.posY + 72 <= 720 && boadOperation.isPath(hero.posX,hero.posY+72)) {
                hero.posY += 72;
                hero = new PositionedImage("hero-down.png", hero.posX, hero.posY);
           }


        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

           if ((hero.posX+72 <= 720) && boadOperation.isPath(hero.posX+72,hero.posY) ) {
                hero.posX += 72;
                hero = new PositionedImage("hero-right.png",hero.posX,hero.posY);
        }


        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

           if ((hero.posY-72 <= 0) && boadOperation.isPath(hero.posX-72,hero.posY)) {
                hero.posX -= 72;
                hero = new PositionedImage("hero-left.png",hero.posX,hero.posY);}

        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }



        }