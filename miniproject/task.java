package vicky;

import java.io.*;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Task")
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roll=request.getParameter("roll");
		String nam=request.getParameter("nam");
		String gender=request.getParameter("gender");
		String dep=request.getParameter("dep");
		String sec=request.getParameter("sec");
		String task=request.getParameter("task");
		
		String mail=request.getParameter("mail");
		String file=request.getParameter("file");
		
		
		try(PrintWriter out = response.getWriter()) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
			Statement st =   con.createStatement();
			int count =st.executeUpdate("insert into task values('"+roll+"','"+nam+"','"+gender+"','"+dep+"','"+sec+"','"+task+"','"+mail+"','"+file+"')");
			if(count > 0) {
				out.println("Successfully inserted");
				response.sendRedirect("index.html");
				out.println("<a href=index.html>Add Another</a>");
			} else {

				out.println("Not Inserted");
				response.sendRedirect("index.html");
			}
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
	}


}
