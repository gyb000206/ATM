package view;

import date.PassWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 高宇博
 * @ID 2503190213
 */
public class Login {
    
    private static final JFrame frame = new JFrame("登录界面");
    private static final JPanel panel = new JPanel();
    private static final JLabel userLabel = new JLabel("User:");
    // 创建UserJLabel
    private static final JTextField userText = new JTextField();
    // 获取登录名
    private static final JLabel passLabel = new JLabel("Password:");
    // 创建PassJLabel
    private static final JPasswordField passText = new JPasswordField(20);
    //密码框隐藏
    private static final JButton loginButton = new JButton("login");
    // 创建登录按钮
    private static final JButton registerButton = new JButton("register");
    // 创建注册按钮

    public static void Login() {
        //设置窗体的位置及大小
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.setBackground(Color.LIGHT_GRAY);
        //设置窗口背景颜色
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        //设置窗体可见
        Event();
    }

    /**
     * 面板具体布局
     *
     * @param panel
     */
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        //设置布局为 null

        // 创建 UserJLabel
        userLabel.setBounds(30, 30, 80, 25);
        panel.add(userLabel);
        // 创建文本域用于用户输入
        userText.setBounds(105, 30, 165, 25);
        panel.add(userText);

        // 创建PassJLabel
        passLabel.setBounds(30, 60, 80, 25);
        panel.add(passLabel);
        // 密码输入框 隐藏
        passText.setBounds(105, 60, 165, 25);
        panel.add(passText);

        // 创建登录按钮
        loginButton.setBounds(25, 100, 80, 25);
        panel.add(loginButton);
        //创建忘记密码按钮
        registerButton.setBounds(190, 100, 80, 25);
        panel.add(registerButton);
    }

    public static void Event() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = String.valueOf(passText.getPassword());

                if (user.equals(PassWord.getUser()) && pass.equals(PassWord.getPassWord())) {
                    JOptionPane.showMessageDialog(null, "登录成功");
                    //登陆成功，弹出窗口
                    Interfaces.Interfaces();
                    frame.setVisible(false);
                    //原来的登录窗口不可见
                }else {
                    JOptionPane.showMessageDialog(null,"账户名或密码输入错误，请重新输入");
                    //账号或密码错误，弹出窗口
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.Register();
            }
        });
    }

}
