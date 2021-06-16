package src;

import javax.swing.*;
import java.awt.*;

public class Player  {
    private int x;
    private int y;
    //private int width;

    private ImageIcon spaceShip;
    //private int height;
    private int speed;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        spaceShip=new ImageIcon("images/Myspaceship.gif");
        //this.width = width;
        //this.height = height;
        this.speed=10;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
/*
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

 */

    public void paint(Graphics graphics,SecondLevel secondLevel) {
       // graphics.setColor(Color.WHITE);
        //graphics.fillOval(this.getX(), this.getY());
         spaceShip.paintIcon( secondLevel,graphics,this.x,this.y);
    }
    public void paintFirst(Graphics graphics,FirstLevel firstLevel) {
        // graphics.setColor(Color.WHITE);
        //graphics.fillOval(this.getX(), this.getY());
        spaceShip.paintIcon( firstLevel,graphics,this.x,this.y);
    }


    public void move(int direction) {
        switch (direction) {
            case Constants.MOVE_RIGHT:
               this.x+=speed;

                break;
            case Constants.MOVE_LEFT:
                this.x-=speed;

                break;
            case Constants.MOVE_UP:
                this.y-=speed;

                break;
            case Constants.MOVE_DOWN:
                this.y+=speed;

                break;
        }
    }


}
