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
    //创建当前游戏模式的地图
    TetrisMap map=new TetrisMap();

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
                    case KeyEvent.VK_LEFT:
                        System.out.println("测试：按下左键");
                        map.setDropBlock(map.showDropBlock());
                        //调用paint刷新
                        paintComponent(getGraphics());
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    //绘制当前版面
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //清空版面
        repaint();
        for(int i=0;i<TetrisMap.mapWidth;i++){
            //这里还是从0行开始画，单独把版面的框画在1处
            for(int t=0;t<=TetrisMap.mapHeight;t++){
                g.setColor(getColor(map.map[i][t]));
                //这里画块块
                g.fillRect((t+1)*20,i*20,20,20);
            }
        }
    }

    Color getColor(int colorNum){
        switch (colorNum){
            case 1:
                return Color.CYAN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.YELLOW;
            case 5:
                return Color.GREEN;
            case 6:
                return Color.RED;
            case 7:
                return Color.MAGENTA;
        }
        return Color.BLACK;
    }
}