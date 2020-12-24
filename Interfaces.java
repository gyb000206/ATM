package view;

import date.Money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;

/**
 * @author 高宇博
 * @ID 2503190213
 */


public class Interfaces {
    static JFrame frame = new JFrame("主界面");
    static JPanel panel = new JPanel();
    //创建主界面
    static JButton buttonGraphQuery = new JButton("查询");
    static JButton buttonDeposition = new JButton("存款");
    static JButton buttonWithdrawals = new JButton("取款");
    static JButton buttonExit = new JButton("退出");
    static JTextArea textArea = new JTextArea();

    //设置主面板
    public static void Interfaces() {
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
        panel.add(buttonGraphQuery);
        panel.add(buttonDeposition);
        panel.add(buttonWithdrawals);
        panel.add(buttonExit);
        panel.add(textArea, FlowLayout.TRAILING);
        Event();
    }

    public static void Event() {
        buttonGraphQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("余额为" + Money.getBalance());
                //接收getBalance()并显示在textArea里
            }
        });

        buttonDeposition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposition.Deposition();
                //跳转到存款金额选择界面
                frame.setVisible(false);
                //当前用户选择主菜单界面不可见
            }
        });

        buttonWithdrawals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Withdrawals.Withdrawals();
                frame.setVisible(false);
                //当前用户选择主菜单界面不可见
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "谢谢使用，欢迎下次光临");
                //使用结束，弹出窗口
                try {
                    sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                //线程休眠3秒后，关闭JVM
                System.exit(0);

            }
        });
    }
}
