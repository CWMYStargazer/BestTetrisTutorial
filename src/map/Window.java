package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {
    public static void main(String[] args) {
        GameWindow game=new GameWindow();

    }
}

class GameWindow extends JFrame{
    GameWindow(){
        //设置基本属性
        setTitle("BestTetrisTutorial");
        setSize(600,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        drawGamePanel();
    }

    //绘制游戏主界面
    void drawGamePanel(){
        JPanel gamePanel=new GamePanel();
        getContentPane().add(gamePanel);
        //请求获取焦点，非常重要，在添加之后进行，不获取不能触发监听器
        gamePanel.requestFocusInWindow();
    }
}

class GamePanel extends JPanel{
    GamePanel(){
        //设置基本属性
        setBackground(Color.BLACK);
        setFocusable(true);
        setSize(600,800);
        //添加按键监听器
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_E:
                        System.out.println("测试：按下e键");
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    //绘制当前版面
    void drawMap(){

    }
}