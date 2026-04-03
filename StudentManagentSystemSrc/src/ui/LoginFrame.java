package ui;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import util.*;

public class LoginFrame extends JFrame {

    JTextField user;
    JPasswordField pass;

    public LoginFrame() {
        setTitle("Student Login");
        setSize(350, 250);
        setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Username:"));
        user = new JTextField();
        add(user);

        add(new JLabel("Password:"));
        pass = new JPasswordField();
        add(pass);

        JButton login = new JButton("Login");
        add(login);

        login.addActionListener(e -> login());

        setVisible(true);
    }

    void login() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT id,password FROM students WHERE username=?"
            );
            ps.setString(1, user.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next() &&
                PasswordUtil.hash(new String(pass.getPassword()))
                .equals(rs.getString("password"))) {

                new StudentDashboard(rs.getInt("id"));
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid login");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}