package lab.databaseServlet11;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String eusername = "postgres";
		String epassword = "bhanu";
		
		response.setContentType("text/html");
		
		try {
			
			
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student",eusername,epassword);
			
			String query = "select * from logindetails where username = '"+username+"' and password='"+password+"'";
			
			PrintWriter pw = response.getWriter();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				pw.print("Login Sucessfull");
			}else {
				pw.print("Creditials are not matched");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
