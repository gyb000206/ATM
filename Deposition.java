package view;

import date.Money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author 高宇博
 * @ID 2503190213
 */

public class Deposition {
    static JFrame frame = new JFrame("存款");
    static JPanel panel = new JPanel();
    //创建主面板
    static JButton button500 = new JButton("500");
    static JButton button1000 = new JButton("1000");
    static JButton button2000 = new JButton("2000");
    static JButton button5000 = new JButton("5000");
    static JButton button$return = new JButton("返回");

    //设置主面板
    public static void Deposition() {
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
    private static void placeComponents(JPanel panel) {
        panel.add(button500);
        panel.add(button1000);
        panel.add(button2000);
        panel.add(button5000);
        panel.add(button$return);
        Event();
    }

    public static void Event() {
        button500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款500元");
                Money.setAddBalance(500);
                System.out.println("存款成功，现存款" + Money.getBalance());
            }
        });

        button1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款1000元");
                Money.setAddBalance(1000);
                System.out.println("存款成功，现存款" + Money.getBalance());
            }
        });

        button2000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款2000元");
                Money.setAddBalance(2000);
                System.out.println("存款成功，现存款" + Money.getBalance());
            }
        });

        button5000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("存款5000元");
                Money.setAddBalance(5000);
                System.out.println("存款成功，现存款" + Money.getBalance());
            }
        });

        button$return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaces.Interfaces();
                //返回用户选择主菜单界面
                frame.setVisible(false);
                //当前存款金额选择界面不可见
            }
        });
    }

}
