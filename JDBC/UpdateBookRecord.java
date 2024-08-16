package JDBC;
import java.sql.*;

public class UpdateBookRecord {
    private static final String URL = "jdbc:postgresql://localhost:5432/LibraryManagement";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName("org.postgresql.Driver");


            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            String sql = "UPDATE Books SET title = ?, book_price = ? WHERE book_id = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Updated Book Title"); // New title
            pstmt.setDouble(2, 25.99); // New price
            pstmt.setInt(3, 101); // book_id of the book to be updated


            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The book record was updated successfully!");
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
