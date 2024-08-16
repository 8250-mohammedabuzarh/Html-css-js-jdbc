package JDBC;


import java.sql.*;

public class DeleteBookRecord {
    private static final String URL = "jdbc:postgresql://localhost:5432/LibraryManagement";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName("org.postgresql.Driver");


            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            String sql = "DELETE FROM Books WHERE book_id = ?";


            pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, 105);


            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The book record was deleted successfully!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

