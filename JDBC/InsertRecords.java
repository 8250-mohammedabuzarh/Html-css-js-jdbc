package JDBC;
import java.sql.*;

public class InsertRecords {
        private static final String URL = "jdbc:postgresql://localhost:5432/LibraryManagement";
        private static final String USERNAME = "postgres";
        private static final String PASSWORD = "root";

        public static void main(String[] args) {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {

                Class.forName("org.postgresql.Driver");

                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


                String sql = "INSERT INTO Books (book_id, title, genre, book_price) VALUES (?, ?, ?, ?)";


                pstmt = conn.prepareStatement(sql);


                pstmt.setInt(1, 105); // Example book_id
                pstmt.setString(2, "New Book Title"); // Example title
                pstmt.setString(3, "Fiction"); // Example genre
                pstmt.setDouble(4, 19.99); // Example price

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new book was inserted successfully!");
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
