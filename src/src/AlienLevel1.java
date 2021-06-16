package src;

import javax.swing.*;
import java.awt.*;

public class AlienLevel1 {
    private int x;
    private int y;
    private ImageIcon alienLevel1;


        public AlienLevel1(int x, int y) {
            this.x=x;
            this.y=y;
            alienLevel1=new ImageIcon("images/alienfirst.gif");
        }


        public void paint(Graphics graphics,FirstLevel firstLevel) {
            this.alienLevel1.paintIcon(firstLevel,graphics,this.x,this.y);

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

    public ImageIcon getAlienLevel1() {
        return alienLevel1;
    }

    public void setAlienLevel1(ImageIcon alienLevel1) {
        this.alienLevel1 = alienLevel1;
    }
}

