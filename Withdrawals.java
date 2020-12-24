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

public class Withdrawals {
    static JFrame frame = new JFrame("取款");
    static JPanel panel = new JPanel();
    //创建主面板
    static JLabel label = new JLabel("请输入您要取的金额");
    //创建文本
    static JTextField textField = new JTextField(15);
    //创建文本框，用于输入金额
    static JButton buttonWithdrawals = new JButton("取款");
    //创建取款按钮
    static JButton button$return = new JButton("返回");

    //创建返回按钮
    //设置面板
    public static void Withdrawals() {
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
    private static void placeComponents(JPanel panel) {
        panel.add(label);
        panel.add(textField);
        panel.add(buttonWithdrawals);
        panel.add(button$return);
        Event();
    }

    public static void Event() {
        buttonWithdrawals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double withdrawals = 0;
                //初始化取款金额
                try {
                    //接收文本框内用户输入的金额数，并赋值给withdrawals
                    withdrawals = Integer.parseInt(textField.getText());
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }

                if (withdrawals % 100 == 0) {
                    //判断，取款金额是否为100的整数，若不是，弹出提示窗口，并在输出台输出
                    if (withdrawals <= Money.getBalance()) {
                        //判断，取款金额是否大于存款，若大于，弹出提示窗口，并在输出台输出
                        if (withdrawals <= 5000) {
                            //判断，单次取款金额是否大于5000，若大于，弹出提示窗口，并在输出台输出
                            Money.setWithdrawalsBalance(withdrawals);
                            //相应取款操作
                            System.out.println("取款成功，现存款" + Money.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(null, "单次取款金额不得大于5000元，请重新输入取款金额");
                            System.err.println("单次取款金额不得大于5000元，请重新输入取款金额");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "存款金额不足，请重新输入取款金额");
                        System.err.println("存款金额不足，请重新输入取款金额");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "只能取100整数倍，请重新输入取款金额");
                    System.err.println("只能取100整数倍，请重新输入取款金额");
                }
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
