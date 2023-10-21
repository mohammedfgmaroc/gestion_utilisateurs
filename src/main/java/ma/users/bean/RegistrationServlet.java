package ma.users.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	// Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/logindb"; // Update with your database URL
    private static final String DB_USER = "root"; // Update with your database username
    private static final String DB_PASSWORD = ""; // Update with your database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        // JDBC variables
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Register JDBC driver and establish a connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL statement to insert data into the 'user' table
            String insertSQL = "INSERT INTO user (nom, prenom, email, motDePasse) VALUES (?, ?, ?, ?)";

            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, email);
            stmt.setString(4, password);

            // Execute the insert statement
            stmt.executeUpdate();

            // Redirect to Login.jsp after successful registration
            response.sendRedirect("Login.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle any exceptions here
            e.printStackTrace();
            // You can redirect the user to an error page or display an error message.
            // response.sendRedirect("error.jsp");
        } finally {
            // Close the resources in a finally block
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
