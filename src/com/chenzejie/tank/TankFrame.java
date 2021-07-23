package com.chenzejie.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public TankFrame() throws HeadlessException {
        setSize(800,600); // 设置窗口f的大小
        setResizable(false); // 设置窗口f不能改变大小
        setTitle("tank war"); // 设置窗口标题文字
        setVisible(true); // 显示窗口
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() { // 添加window监听器：监听window closing，匿名内部类
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 系统会自动调用这个paint方法
    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        // g为一只画笔
        g.fillRect(x,y,50,50); // 画一个黑方块
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        // 让黑方块动起来
//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
//            System.out.println(keyCode);
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) {
                dir = Dir.LEFT;
            }
            if (bU) {
                dir = Dir.UP;
            }
            if (bR) {
                dir = Dir.RIGHT;
            }
            if (bD) {
                dir = Dir.DOWN;
            }
        }
    }
}
