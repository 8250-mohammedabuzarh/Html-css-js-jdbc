package JDBC;

import java.sql.*;

public class MySQLJDBCExample {
    private static final String URL = "jdbc:postgresql://localhost:5432/LibraryManagement";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName("org.postgresql.Driver");


            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM Books";


            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("title");
                String genre = rs.getString("genre");
                double price = rs.getDouble("book_price");


                System.out.printf("ID: %d, Name: %s, Position: %s, Salary: %.2f%n", id, name, genre, price);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
