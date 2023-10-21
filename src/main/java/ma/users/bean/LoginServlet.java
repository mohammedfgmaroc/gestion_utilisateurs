package ma.users.bean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/logindb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;

        try {
            // Establish a database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare an SQL query to retrieve user data
            String selectSQL = "SELECT id, nom, prenom FROM user WHERE email=? AND motDePasse=?";
            PreparedStatement stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // If a matching user is found, create a UserBean and populate it
            	long id = resultSet.getLong("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                user = new User(id, nom, prenom, username, password);

                // Store the user bean in the session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Redirect to a welcome or dashboard page
                response.sendRedirect("Home.jsp");
            }

            resultSet.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle database errors or exceptions
        }
    }

}
