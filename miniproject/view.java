package vicky;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try(PrintWriter out = response.getWriter()) {
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
			 out.println("<li class=\"nav-item\">");
			 out.println(" <a class=\"nav-link\" href=\"view\">View</a>");
			 out.println("</li>");
			 
			 out.println("</ul>");
			 out.println("</nav>");
			 out.println("</div>");
			out.println("<div style= 'width: 50% margin: 0 auto background-color:	#D6DBDF;'>");
			out.println("<table class=\"view-contacts\" style='background-color:#AED6F1  ; width: 50%; margin: 500 auto;'  BORDER COLS=6 WIDTH=500>");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			Connection con =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
			Statement st =   con.createStatement();
					ResultSet rs = (ResultSet) st.executeQuery("select *from  task");
			out.println("<tr><th>Rollno</th><th>Name</th><th>Gender</th><th>Department</th><th>Section</th><th>Taskid</th><th>Email</th><th>FileName</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
			}
			st.close();
			con.close();
			//response.sendRedirect("index.html");
		} catch(Exception e) { 
			out.println(e);
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	}

}
