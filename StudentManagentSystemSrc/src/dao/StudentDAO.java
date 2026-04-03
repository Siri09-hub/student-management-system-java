package dao;
import java.sql.*;
import util.DBConnection;

public class StudentDAO {

    public static ResultSet getProfile(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM students WHERE id=?");
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public static ResultSet getResults(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM results WHERE student_id=?");
        ps.setInt(1, id);
        return ps.executeQuery();
    }
}