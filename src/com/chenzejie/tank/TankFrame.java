package com.chenzejie.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame() throws HeadlessException {
        setSize(800,600); // 设置窗口f的大小
        setResizable(false); // 设置窗口f不能改变大小
        setTitle("tank war"); // 设置窗口标题文字
        setVisible(true); // 显示窗口
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
        // g为一只画笔
        g.fillRect(200,200,50,50);
    }
}
