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
public class Register {

    static PassWord passWord = new PassWord();


    private static final JFrame frame = new JFrame("修改密码");
    //创建主面板
    private static final JPanel panel = new JPanel();
    private static final JLabel labelAdmin = new JLabel("管理员账号");
    private static final JLabel labelNewPass = new JLabel("新密码");
    //    private final JLabel labelNewPass2 = new JLabel("再次确认新密码");
    private static final JTextField textFieldAdmin = new JTextField();
    private static final JTextField textFieldNewPass = new JTextField();
    //    private final JTextField textFieldNewPass2 = new JTextField();
    private static final JButton buttonConfirm = new JButton("确认更改");
    private static final JButton buttonReset = new JButton("重置密码");

    public static void Register() {
        //设置窗体位置和大小
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        //窗体居中显示
        frame.add(panel);
        //添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placeComponents(panel);
        frame.setVisible(true);
    }


    /**
     * 面板具体布局
     *
     * @param panel
     */
    private static void placeComponents(JPanel panel) {
        //往窗体里放其他控件
        panel.setLayout(null);
        //设置布局为 null
        frame.setBackground(Color.ORANGE);
        //设置窗口背景颜色
        labelAdmin.setBounds(30, 30, 80, 25);
        // 创建labelAdmin
        panel.add(labelAdmin);
        // 创建文本域用于用户输入
        textFieldAdmin.setBounds(105, 30, 165, 25);
        panel.add(textFieldAdmin);
        // 创建labelNewPass
        labelNewPass.setBounds(30, 60, 80, 25);
        panel.add(labelNewPass);
        textFieldNewPass.setBounds(105, 60, 165, 25);
        panel.add(textFieldNewPass);
//        labelNewPass2.setBounds(30, 60, 80, 25);
//        panel.add(labelNewPass2);
//        textFieldNewPass2.setBounds(105, 60, 165, 25);
//        panel.add(textFieldNewPass2);
        // 创建确认按钮
        buttonConfirm.setBounds(25, 100, 80, 25);
        panel.add(buttonConfirm);
        //创建重置按钮
        buttonReset.setBounds(190, 100, 80, 25);
        panel.add(buttonReset);

        Event();
    }

    public static void Event() {
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldAdmin.getText().equals(passWord.getAdministrator())) {
                    // 管理员账户是否正确，若不正确，弹出窗口
                    if (textFieldNewPass.getText().length() >= 6) {
                        //新密码位数是否小于6位，若小于6位，弹出窗口
                        if (!textFieldNewPass.getText().equals(passWord.getPassWord())) {
                            // 新密码是否与原密码相同，若相同，弹出窗口
                            passWord.setPassWord(textFieldNewPass.getText());
                            //接收password文本框内字符串，并赋值给setPassword()方法
                            System.out.println("修改密码成功，新密码为" + textFieldNewPass.getText());
                            System.out.println("password" + passWord.getPassWord());
                            //控制台输出修改结果
                            Login.Login();
                            //再次打开登录窗口，来输入修改后的新密码
                            frame.setVisible(false);
                            //当前修改密码后窗口不可见

                        } else {
                            JOptionPane.showMessageDialog(null, "新密码与旧密码相同，请重新输入");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "新密码小于6位，请重新输入");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "管理员账户错误，请重新输入");
                }
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
