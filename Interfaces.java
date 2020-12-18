package view;

import date.Money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.PaintEvent;

/**
 * @author 高宇博
 * @ID 2503190213
 * 主菜单
 */

public class Interfaces extends Thread {
    @Override
    public void run() {
        new Interfaces();
    }

    JFrame frame = new JFrame("主界面");
    JPanel panel = new JPanel();
    //创建主界面
    JButton buttonGraphQuery = new JButton("查询");
    JButton buttonDeposition = new JButton("存款");
    JButton buttonWithdrawals = new JButton("取款");
    JButton buttonExit = new JButton("退出");
    JTextArea textArea = new JTextArea();

    //设置主面板
    public Interfaces() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //关闭窗口随机退出程序
        frame.setVisible(true);
        //使窗体可见
        frame.setSize(400, 300);
        //设置及窗体尺寸
        frame.setLocationRelativeTo(null);
        //窗体居中显示
        frame.setLayout(new FlowLayout());
        //设置面板布局为流式布局
        frame.add(panel);
        //将面板添加进窗体容器中
        placeComponents(panel);
    }

    //将文本框和按钮等组件添加进面板容器中
    private void placeComponents(JPanel panel) {
        panel.add(buttonGraphQuery);
        panel.add(buttonDeposition);
        panel.add(buttonWithdrawals);
        panel.add(buttonExit);
        panel.add(textArea, FlowLayout.TRAILING);
        Event();
    }

    //创建按钮事件方法
    public void Event() {
        //创建查询按纽激发的事件
        buttonGraphQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("余额为:" + new Money().getBalance());
                //接收Money类中getBalance()方法，并添加到textArea中显示出来
            }
        });
        //创建存款按纽激发的事件
        buttonDeposition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deposition().start();
                //TODO 存款界面以新线程启动
            }
        });
        //创建取款按纽激发的事件
        buttonWithdrawals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Withdrawals().start();
                //TODO 取款界面以新线程启动
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("关闭Java虚拟机");
                System.exit(0);
                //TODO 结束程序，关闭JVM
            }
        });
    }
}
