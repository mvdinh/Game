package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Entity.Account;
import database.ConnectDB;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JTextField pass;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginForm frame = new LoginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(70, 50, 80, 20);
        contentPane.add(lblUsername);

        user = new JTextField();
        user.setBounds(160, 50, 200, 20);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(70, 100, 80, 20);
        contentPane.add(lblPassword);

        pass = new JPasswordField();
        pass.setBounds(160, 100, 200, 20);
        contentPane.add(pass);
        pass.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = user.getText();
                String password = pass.getText();
            	ConnectDB c = new ConnectDB();
            	Account account = c.login(username,password);
            	if (account != null) {
            		setVisible(false);
            		LoadFrame load = new LoadFrame();
            		load.setVisible(true);
            	}
            	else{
            		 setVisible(false);
                     SignupForm s = new SignupForm();
                     s.setVisible(true);
                     System.out.println(username + password);
            	}
            }
        });
        btnLogin.setBounds(160, 150, 80, 30);
        contentPane.add(btnLogin);

        JButton btnSignup = new JButton("Register");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignupForm s = new SignupForm();
                s.setVisible(true);
            }
        });
        btnSignup.setBounds(280, 150, 80, 30);
        contentPane.add(btnSignup);
    }
}