package vicky;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
import com.creators.java.Database;
import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;
*/
/**
 * Servlet implementation class Updateaction
 */
@WebServlet("/Updateaction")
public class Updateaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			String rol = request.getParameter("rol");
			String nam = request.getParameter("nam");
			String gender = request.getParameter("gender");
			String dep = request.getParameter("dep");
			String sec = request.getParameter("sec");
			String task = request.getParameter("task");
			String mail = request.getParameter("mail");
			String file = request.getParameter("file");
		//	out.println(rol+nam+gender+dep+sec+task+mail+file);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
			Statement st =con.createStatement();
			st.executeUpdate("update task set rollno='"+rol+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set name='"+nam+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set genter='"+gender+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set department='"+dep+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set section='"+sec+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set email='"+mail+"' where taskid = '"+task+"'");
			st.executeUpdate("update task set file='"+file+"' where taskid = '"+task+"'");
			st.close();
			con.close();

			response.sendRedirect("view");
		}catch(ClassNotFoundException e){
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
