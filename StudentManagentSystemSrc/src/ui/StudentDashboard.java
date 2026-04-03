package ui;
import javax.swing.*;
import java.sql.*;
import dao.StudentDAO;

public class StudentDashboard extends JFrame {

    public StudentDashboard(int id) {
        setTitle("Student Dashboard");
        setSize(500, 400);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area));

        try {
            ResultSet rs = StudentDAO.getProfile(id);
            if (rs.next()) {
                area.append("Name: " + rs.getString("name") + "\n");
                area.append("Email: " + rs.getString("email") + "\n");
                area.append("Attendance: " + rs.getInt("attendance") + "\n\n");
            }

            rs = StudentDAO.getResults(id);
            while (rs.next()) {
                area.append(
                    "Semester " + rs.getInt("semester") +
                    " | " + rs.getString("subject") +
                    " | " + rs.getInt("marks") +
                    " | Grade: " + rs.getString("grade") + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}