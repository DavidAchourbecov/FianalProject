package src;

import javax.swing.*;
import java.awt.*;

public class CurrenScene extends JPanel {
    private FirstLevel firstLevel;
    private SecondLevel secondLevel;
    private int sceneId;

    public CurrenScene(){
        firstLevel=new FirstLevel();
        secondLevel=new SecondLevel(firstLevel.getPlayer(),firstLevel.getEnemy1(),firstLevel.getEnemy2(),firstLevel.getEnemy3(),firstLevel.getEnemy4());
        sceneId=Constants.FIRST_LEVEL;
        this.add(firstLevel);
        this.add(secondLevel);
         this.mainGameLoop();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
            switch (this.sceneId) {

                case Constants.FIRST_LEVEL:
                    firstLevel.paint(g);
                    Graphics2D createGraphics = (Graphics2D) g;
                    if (firstLevel.getPlayer().getX()==Constants.PLAYER_X && firstLevel.getPlayer().getY()==Constants.PLAYER_Y){
                        createGraphics.setFont( new Font("David", Font.BOLD, 50));
                        createGraphics.setPaint( Color.WHITE );
                        createGraphics.drawString("LEVEL 1",200,100);
                        createGraphics.dispose();
                    }
                    //createGraphics.drawString("To start game, press space key",200,600);

                    break;
                case Constants.SECOND_LEVEL:
                    secondLevel.paint(g);
                     createGraphics = (Graphics2D) g;
                    if (secondLevel.getPlayer().getX()==Constants.PLAYER_X && secondLevel.getPlayer().getY()==Constants.PLAYER_Y){
                        createGraphics.setFont( new Font("David", Font.BOLD, 50));
                        createGraphics.setPaint( Color.WHITE );
                        createGraphics.drawString("LEVEL 2",200,100);
                        createGraphics.dispose();
                    }
                    break;
            }


    }
    public void mainGameLoop() {
        new Thread(() -> {
            while (true) {


                    repaint();
                    switch (this.sceneId){
                        case Constants.FIRST_LEVEL:
                            this.firstLevel.getEnemy1().move(0);
                            this.firstLevel.getEnemy2().move(0);
                            this.firstLevel.getEnemy3().move(0);
                            this.firstLevel.getEnemy4().move(0);
                            if (this.firstLevel.getPlayer().getX() != Constants.PLAYER_X && this.firstLevel.getPlayer().getY() != Constants.PLAYER_Y) {
                                firstLevel.startOverAfterCollision();
                            }

                            if (firstLevel.moveToNextLevel()) {
                                this.sceneId = Constants.SECOND_LEVEL;
                            }
                            break;


                        case Constants.SECOND_LEVEL:
                            this.firstLevel.getEnemy1().move(0);
                            this.firstLevel.getEnemy2().move(0);
                            this.firstLevel.getEnemy3().move(0);
                            this.firstLevel.getEnemy4().move(0);
                            this.secondLevel.getEnemy5().move(0);
                            this.secondLevel.getEnemy6().move(0);
                            this.secondLevel.getEnemy7().move(0);
                            if (this.secondLevel.getPlayer().getX() != Constants.PLAYER_X && this.secondLevel.getPlayer().getY() != Constants.PLAYER_Y) {
                                secondLevel.startOverAfterCollision2();
                            } if (secondLevel.isWinner()) {
                                Object[] options = {"Yes", "No", "ask later"};
                            int n = JOptionPane.showOptionDialog(this, "You Won Do You want to start over", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                            if (n == 1) {
                                System.exit(0);
                            } else if (n == 0) {
                                this.sceneId=Constants.FIRST_LEVEL;

                            }
                        }


                            break;
                    }



                       /*
                        this.secondLevel.getEnemy1().move(0);
                        this.secondLevel.getEnemy2().move(0);
                        this.secondLevel.getEnemy3().move(0);
                        this.secondLevel.getEnemy4().move(0);
                        this.secondLevel.getEnemy5().move(0);
                        this.secondLevel.getEnemy6().move(0);
                        this.secondLevel.getEnemy7().move(0);
                        if (this.secondLevel.getPlayer().getX() != Constants.PLAYER_X && this.secondLevel.getPlayer().getY() != Constants.PLAYER_Y) {
                            secondLevel.startOverAfterCollision2();
                        }

                        */
                        /*if (secondLevel.isWinner()) {
                            this.sceneId = Constants.FIRST_LEVEL;

                            break;
                        }

                         */



                    try {
                    Thread.sleep(Constants.FRAMES_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        }



    public FirstLevel getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(FirstLevel firstLevel) {
        this.firstLevel = firstLevel;
    }

    public SecondLevel getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(SecondLevel secondLevel) {
        this.secondLevel = secondLevel;
    }



        }














