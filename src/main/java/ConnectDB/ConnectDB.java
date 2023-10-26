/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author béo
 */
// đổi db ở phương thức static cuối cùng khi chạy
public class ConnectDB {
    String DB = null;
    String user = null;
    String password = null;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    static int countConection = 0;
    static int countQuery = 0;
    static int countUpdate = 0;

    String ipAddress = "localhost:3306";

    public ConnectDB() {
        DB = "qlstmini_data";
        user = "root";
        password = "";
        setupConnect();
    }

    public ConnectDB(String DB) {
        this.DB = DB;
    }

    public ConnectDB(String DB, String user, String password) {
        this.DB = DB;
        this.user = user;
        this.password = password;
        setupConnect();
    }

    public Boolean checkConnect() {
        if (conn == null || stmt == null) {
            JOptionPane.showMessageDialog(null,
                    "-- ERROR! Chưa thiết lập kết nối tới '" + DB + "'. Vui lòng đăng nhập để thiết lập kết nối!");
            return false;
        }
        return true;
    }

    // Ket noi voi database
    private void setupConnect() {
        try {
            String url = "jdbc:mysql://localhost:3306/" + DB;
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            countConection++;
            System.out.println("**\n" + countConection + ": Success! Đã kết nối tới '" + DB + "'");

        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("-- ERROR! Không thể kết nối tới '" + DB + "'");
            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể kết nối tới '" + DB + "'");
        }
    }

    // Truy van theo cau lenh sql
    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {
            try {
                rset = stmt.executeQuery(qry);
                countQuery++;
                System.out.println(countQuery + ": Success Query! " + qry);
                return rset;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "-- ERROR! Không thể lấy dữ liệu từ " + DB + "\n" + ex.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }

    // Update du lieu
    public Boolean sqlUpdate(String qry) {
        if (checkConnect()) {
            try {
                stmt.executeUpdate(qry);
                countUpdate++;
                System.out.println(countUpdate + ": Success Update! " + qry);
                return true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "-- ERROR! Không thể ghi dữ liệu xuống " + DB + "\n" + ex.getLocalizedMessage());
                return false;
            }
        }
        return false;
    }

    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("Success! Đóng kết nối tới '" + DB + "' thành công.\n**");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "-- ERROR! Không thể đóng kết nối tới " + DB + "\n" + ex.getLocalizedMessage());
        }
    }

    // class static
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/qlstmini_data";

            // String url ="jdbc:mysql://localhost:3306/qltv";
            // cons = DriverManager.getConnection(url, "root", "200303410");
            cons = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

}
