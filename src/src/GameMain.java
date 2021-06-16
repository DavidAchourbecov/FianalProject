package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMain extends JFrame   {

    public static void main(String[] args) {
        GameMain gameMain = new GameMain();
        //optionPaneExample();

    }


    private static void optionPaneExample() {
        JFrame startButton = new JFrame();
        JFrame instruction = new JFrame();
        startButton.setLocationRelativeTo(null);
        instruction.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(startButton, "Hello, Welcome to 'RESCUE THE ALIEN '.");
        JOptionPane.showMessageDialog(instruction, "The rules are simple: " +
                "*You can not get out of the frame" +
                "\n *You must avoid the enemies" +
                "\n* in order to win the game you need to pick up the alien");
    }

    public GameMain() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Rescue The Alien");
        this.setResizable(false);
        CurrenScene currenScene = new CurrenScene();
        currenScene.setBounds(0,0,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        PlayerMovement playerMovement = new PlayerMovement(currenScene.getFirstLevel().getPlayer() );
        this.addKeyListener(playerMovement);
        this.add(currenScene);
    }


}