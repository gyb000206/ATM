package view;

import date.Money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 高宇博
 * @ID 2503190213
 * 存款
 */

public class Deposition extends Thread {
    @Override
    public void run() {
        new Deposition();
    }

    Money money = new Money();
    //创建Money类内对象

    JFrame frame = new JFrame("存款");
    JPanel panel = new JPanel();
    //创建主面板
    JButton button500 = new JButton("500");
    JButton button1000 = new JButton("1000");
    JButton button2000 = new JButton("2000");
    JButton button5000 = new JButton("5000");
    JButton button$return = new JButton("返回");

    //设置主面板
    public Deposition() {
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
        panel.add(button500);
        panel.add(button1000);
        panel.add(button2000);
        panel.add(button5000);
        panel.add(button$return);
        Event();
    }

    //创建按钮事件方法
    public void Event() {
        //设置button500按钮所激发的时间
        button500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款500元");
                //TODO 此处有BUG
                money.setAddBalance(500);
                //调用Date包内Money类内setAddBalance（）方法
                //TODO
                //余额增加500元
                System.out.println(money.getBalance());
            }
        });

        //设置button1000按钮所激发的时间
        button1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款1000元");
                //TODO 此处有BUG
                money.setAddBalance(1000);
                //TODO
                //余额增加1000元
                System.out.println(money.getBalance());
            }
        });

        //设置button2000按钮所激发的时间
        button2000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款2000元");
                //TODO 此处有BUG
                money.setAddBalance(2000);
                //TODO
                //余额增加2000元
                System.out.println(money.getBalance());
            }
        });

        //设置button5000按钮所激发的时间
        button5000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款5000元");
                //TODO 此处有BUG
                money.setAddBalance(5000);
                //TODO
                //余额增加5000元
                System.out.println(money.getBalance());
            }
        });

        button$return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaces().run();
                //TODO 主面板线程启动
                frame.dispose();
                //只关闭当前窗体
            }
        });
    }
}
