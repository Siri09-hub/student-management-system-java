package dao;
import java.sql.*;
import util.*;

public class AdminDAO {

    public static void addStudent(String u, String p, String n, String e) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO students(username,password,name,email,attendance) VALUES(?,?,?,?,0)"
        );
        ps.setString(1, u);
        ps.setString(2, PasswordUtil.hash(p));
        ps.setString(3, n);
        ps.setString(4, e);
        ps.executeUpdate();
        con.close();
    }

    public static void addResult(int id, int sem, String sub, int marks, String grade)
            throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO results(student_id,semester,subject,marks,grade) VALUES(?,?,?,?,?)"
        );
        ps.setInt(1, id);
        ps.setInt(2, sem);
        ps.setString(3, sub);
        ps.setInt(4, marks);
        ps.setString(5, grade);
        ps.executeUpdate();
        con.close();
    }
}