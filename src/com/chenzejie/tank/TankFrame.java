package com.chenzejie.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;

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
        System.out.println("paint");
        // g为一只画笔
        g.fillRect(x,y,50,50); // 画一个黑方块
        // 让黑方块动起来
        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            x += 20;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
