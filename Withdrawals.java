package view;

import date.Money;
import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 高宇博
 * @ID 2503190213
 * 取款
 */

public class Withdrawals extends Thread {
    @Override
    public void run() {
        new Withdrawals();
    }

    Money money = new Money();
    //创建Money类内对象

    JFrame frame = new JFrame("取款");
    JPanel panel = new JPanel();
    //创建主面板
    JLabel label = new JLabel("请输入您要取的金额");
    //创建文本
    JTextField textField = new JTextField(15);
    //创建文本框，用于输入金额
    JButton buttonWithdrawals = new JButton("取款");
    //创建取款按钮
    JButton button$return = new JButton("返回");

    //创建返回按钮
    //设置面板
    public Withdrawals() {
        frame.setVisible(true);
        //使窗体可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //关闭窗口随机退出程序
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

    //组装面板,将文本框和按钮等组件添加进面板容器中
    private void placeComponents(JPanel panel) {
        panel.add(label);
        panel.add(textField);
        panel.add(buttonWithdrawals);
        panel.add(button$return);
        Event();
    }

    //创建按钮事件方法
    public void Event() {
        //创建取款按钮所激发的事件
        buttonWithdrawals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //可能会产生异常，用户输入的可能不是整数金额
                int withdrawals = 0;
                //初始化取款金额
                try {
                    //接收文本框内用户输入的金额数，并赋值给withdrawals
                    withdrawals = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
                //判断，取款金额是否为100的整数，若不是，弹出提示窗口，并在输出台输出
                if (withdrawals % 100 == 0) {
                    //判断，取款金额是否大于存款，若大于，弹出提示窗口，并在输出台输出
                    if (withdrawals <= money.getBalance()) {
                        //判断，取款金额是否大于5000，若大于，弹出提示窗口，并在输出台输出
                        if (withdrawals <= 5000) {
                            money.setWithdrawalsBalance(withdrawals);
                        } else {
                            JOptionPane.showMessageDialog(null, "单次取款金额不得大于5000元，请重新输入取款金额");
                            System.out.println("单次取款金额不得大于5000元，请重新输入取款金额");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "存款金额不足，请重新输入取款金额");
                        System.out.println("存款金额不足，请重新输入取款金额");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "只能取100整数倍，请重新输入取款金额");
                    System.out.println("只能取100整数倍，请重新输入取款金额");
                }

            }
        });

        //创建返回按钮激发的事件
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
