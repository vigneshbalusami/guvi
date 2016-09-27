package vicky;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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

		String roll=request.getParameter("roll");
		String task=request.getParameter("task");
		
		try(PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
				Statement st =   con.createStatement();
				ResultSet rs =  st.executeQuery("select *from  task  where  rollno =  '"+roll+"' and taskid = '"+task+"' ");
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>App Holder</title>");
				out.println("<link rel=stylesheet href=css/bootstrap.css>");
				out.println("</head>");
				 out.println("<body style='background-color:#F8F8FF;'>");

				 out.println("<div	style=\"background-color  : #1E90FF\">");
				 out.println("<nav class=\"navbar navbar-light bg-faded\">");
				 out.println("<a class=\"navbar-brand\" href=\"index.html\">Home</a>");
				 out.println("<ul class=\"nav navbar-nav\">");
				 out.println("<li class=\"nav-item active\">");
				 out.println("<a class=\"nav-link\" href=\"insert.html\">Insert <span class=\"sr-only\">(current)</span></a>");
				 out.println("</li>");
				 out.println("<li class=\"nav-item\">");
				 out.println("<a class=\"nav-link\" href=\"update.html\">Update</a>");
				 out.println("  </li>");
				 out.println("<li class=\"nav-item\">");
				 out.println(" <a class=\"nav-link\" href=\"delete.html\">Delete</a>");
				 out.println("</li>");
				 out.println("</ul>");
				 out.println("</nav>");
				 out.println("</div>");
				// request.getRequestDispatcher(arg0);
				 if(rs.next()){
					 out.println("<div class=\"\"> <form action=\"Updateaction\" method=\"Post\"><table class=\"table table-striped\">");
					 out.println("<tr><td>RollNo:</td><td><input type=\"text\" name=\"rol\" value=\""+rs.getString(1)+"\"></td></tr>");
					 out.println("<tr><td>Name:</td><td><input type=\"text\" name=\"nam\" value=\""+rs.getString(2)+"\"></td></tr>");
					 out.println("<tr><td>Gender:</td><td><input type=\"text\" name=\"gender\" value=\""+rs.getString(3)+"\"></td></tr>");
					 out.println("<tr><td>Department:</td><td><input type=\"text\" name=\"dep\" value=\""+rs.getString(4)+"\"></td></tr>");
					 out.println("<tr><td>Section:</td><td><input type=\"text\" name=\"sec\" value=\""+rs.getString(5)+"\"></td></tr>");
					 out.println("<tr><td>TaskId:</td><td><input type=\"text\" name=\"task\" value=\""+rs.getString(6)+"\"></td></tr>");
					 out.println("<tr><td>Mail:</td><td><input type=\"text\" name=\"mail\" value=\""+rs.getString(7)+"\"></td></tr>");
					 out.println("<tr><td >FileName:</td><td><input type=\"text\" name=\"file\" value=\""+rs.getString(8)+"\"></td></tr>");
					 out.println("<tr><td colspan=\"2\"><input type=\"submit\" value=\"Update\"/></td></tr>");
				 }
				 else{
					 out.println("<p>Invalid Input</p>");

						response.sendRedirect("update.html");
				 }
				 rs.close();
				 st.close();
				 con.close();
				 out.println("</body>");
				 out.println("</html>");
			} catch(SQLException e){
				System.out.println(e);
			}
	}catch(ClassNotFoundException e){
		System.out.println(e);
		
	}
	}
}
