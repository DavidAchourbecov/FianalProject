package src;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class FirstLevel extends JPanel {
    private Player player;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
   // private ImageIcon alienLevel1=new ImageIcon("images/alien.gif");
   private ImageIcon alienLevel1=new ImageIcon("images/alienfirst.gif");
    private Image backGround = new ImageIcon("images/space.jpg").getImage();

    public FirstLevel() {
        this.setBounds(0,0,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        this.setDoubleBuffered(true);
        this.player = new Player(Constants.PLAYER_X, Constants.PLAYER_Y);
        this.enemy1 = new Enemy(Constants.ENEMY1_X, Constants.ENEMY1_Y, Constants.ENEMY1_SIZE, Constants.ENEMY1_SIZE);
        this.enemy2 = new Enemy(Constants.ENEMY2_X, Constants.ENEMY2_Y, Constants.ENEMY2_SIZE, Constants.ENEMY2_SIZE);
        this.enemy3 = new Enemy(Constants.ENEMY3_X, Constants.ENEMY3_Y, Constants.ENEMY3_SIZE, Constants.ENEMY3_SIZE);
        this.enemy4 = new Enemy(Constants.ENEMY4_X, Constants.ENEMY4_Y, Constants.ENEMY4_SIZE, Constants.ENEMY4_SIZE);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
                 Graphics2D createGraphics = (Graphics2D) g;
                 createGraphics.setFont( new Font("Ariel", Font.BOLD, 50));
                 createGraphics.setPaint( Color.WHITE );
                 createGraphics.drawString("level 1 ",400,100);

                    g.drawImage(backGround, 0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, this);
                    this.player.paintFirst(g,this);
                    this.enemy1.paint(g);
                    this.enemy2.paint(g);
                    this.enemy3.paint(g);
                    this.enemy4.paint(g);
                    g.drawImage(alienLevel1.getImage(), Constants.ALIEN1_X, Constants.ALIEN1_Y, Constants.ALIEN_Y_LEVEL2, Constants.ALIEN_Y_LEVEL2, null);



    }


    public int random() {
        Random random = new Random();

        return random.nextInt(2);
    }

    public boolean collision(Player player, Enemy enemy) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY());
        Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        boolean collision = playerRectangle.intersects(enemyRectangle);
        return collision;

    }

    public boolean playerMeetAlien(Player player, ImageIcon alien) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY());
        Rectangle alienRectangle = new Rectangle(Constants.ALIEN1_X, Constants.ALIEN1_Y, Constants.ALIEN_Y_LEVEL2, Constants.ALIEN_Y_LEVEL2);
        boolean meeting = playerRectangle.intersects(alienRectangle);
        return meeting;

    }

    public void startOverAfterCollision() {
        if (collision(player, enemy1) || collision(player, enemy2) || collision(player, enemy3) || collision(player, enemy4)) {
            JFrame startOverButton = new JFrame();
            startOverButton.setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(startOverButton, "first level: You are died!!,Please press OK if you want to stars Over");
           resetPlayerAndEnemiesAfterCollision();

        }



    }private void resetPlayerAndEnemiesAfterCollision() {
            this.player.setX(Constants.PLAYER_X);
            this.player.setY(Constants.PLAYER_Y);
            this.enemy1.setX(Constants.ENEMY1_X);
            this.enemy1.setY(Constants.ENEMY1_Y);
            this.enemy2.setX(Constants.ENEMY2_X);
            this.enemy2.setY(Constants.ENEMY1_Y);
            this.enemy3.setX(Constants.ENEMY3_X);
            this.enemy3.setY(Constants.ENEMY3_Y);
            this.enemy4.setX(Constants.ENEMY4_X);
            this.enemy4.setY(Constants.ENEMY4_Y);

        }

    public boolean moveToNextLevel() {
        if (playerMeetAlien(this.player,this.alienLevel1)) {
            this.player.setX(Constants.PLAYER_X);
            this.player.setY(Constants.PLAYER_Y);

            return true;
        } else
            return false;


        //JFrame winButton = new JFrame();
        //winButton.setLocationRelativeTo(null);
        //JOptionPane.showMessageDialog(winButton, "You are winner!!, press 'OK' TO MOVE TO NEXT LEVEL " );
        //this.player.setX(Constants.ENEMY1_X);
        //this.player.setY(Constants.ENEMY1_Y);

           /* nextLevel=new JButton("Next Level");
            nextLevel.setVisible(true);
            nextLevel.setLayout(null);
            nextLevel.setBounds(400,300,200,50);
            nextLevel.setFont(new Font("Comic con",Font.BOLD,20));
            nextLevel.setForeground(Color.BLUE);
            nextLevel.setBackground(Color.YELLOW);
            nextLevel.addActionListener(e -> {
                System.out.println("checked if pressed");
                sceneId=2;
              //nextLevel.setEnabled(false);


           });
            this.add(nextLevel);


            */


    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(Enemy enemy1) {
        this.enemy1 = enemy1;
    }

    public Enemy getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(Enemy enemy2) {
        this.enemy2 = enemy2;
    }

    public Enemy getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(Enemy enemy3) {
        this.enemy3 = enemy3;
    }

    public Enemy getEnemy4() {
        return enemy4;
    }

    public void setEnemy4(Enemy enemy4) {
        this.enemy4 = enemy4;
    }

    public void setAlien(ImageIcon alien) {
        this.alienLevel1 = alien;
    }

    public ImageIcon getAlien() {
        return alienLevel1;
    }

    public Image getBackGround() {
        return backGround;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }
}
