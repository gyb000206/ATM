package view;

import date.PassWord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author 高宇博
 * @ID 2503190213
 */
public class Login extends Thread {
    @Override
    public void run() {
        new Login();
    }

    private final JFrame frame = new JFrame("登录界面");
    private final JPanel panel = new JPanel();
    private final JLabel userLabel = new JLabel("User:");
    // 创建UserJLabel
    private final JTextField userText = new JTextField();
    // 获取登录名
    private final JLabel passLabel = new JLabel("Password:");
    // 创建PassJLabel
    private final JPasswordField passText = new JPasswordField(20);
    //密码框隐藏
    private final JButton loginButton = new JButton("login");
    // 创建登录按钮
    private final JButton registerButton = new JButton("register");
    // 创建注册按钮

    public Login() {
        //设置窗体的位置及大小
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
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
    private void placeComponents(JPanel panel) {

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

    public void Event() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = String.valueOf(passText.getPassword());
                boolean ValidationError;
                //确认账户密码是否输入正确

                if (user.equals(new PassWord().getUser()) && pass.equals(new PassWord().getPassWord())) {
                    JOptionPane.showMessageDialog(null, "登录成功");
                    //登录成功，弹出窗口
                    new Interfaces().start();
                    //TODO 主面板以新线程启动
                    frame.setVisible(false);
                    //原来的登录窗口不可见
                } else {
                    JOptionPane.showMessageDialog(null, "账户名或密码输入错误，请重新输入");
                    //账号或密码错误，弹出窗口
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().start();
                //TODO 修改密码界面以新线程启动
            }
        });

    }
}


