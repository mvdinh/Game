package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConnectDB;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JTextField pass;

    public SignupForm() {
        setBounds(100, 100, 450, 300);
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

        pass = new JTextField();
        pass.setBounds(160, 100, 200, 20);
        contentPane.add(pass);
        pass.setColumns(10);

        JButton btnSignup = new JButton("Register");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = pass.getText();
                ConnectDB c = new ConnectDB();
                c.signup(username,password);
                LoginForm login = new LoginForm();
                login.setVisible(true);
                setVisible(false);
            }
        });
        btnSignup.setBounds(185, 150, 100, 30);
        contentPane.add(btnSignup);
    }
}
