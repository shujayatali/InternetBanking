
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DBConnection;
import oracle.jdbc.driver.OracleTypes;

@WebServlet("/MiniStatementServlet")
public class MiniStatementServlet extends HttpServlet {
	Connection con = null;

	@Override
	public void init() throws ServletException {
		try {
			con = DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long acc_num = Long.parseLong(request.getParameter("account_num"));
		PrintWriter out = response.getWriter();
		try {
			CallableStatement cs = con.prepareCall("{call MiniStatement(?,?)}");

			cs.registerOutParameter(1, OracleTypes.CURSOR);

			cs.setLong(2, acc_num);

			cs.executeUpdate();

			ResultSet rs = (ResultSet) cs.getObject(1);

			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();

			out.println("<html><body><table border=5>");

			for (int i = 1; i <= columns; i++) {
				out.println("<th>");
				out.println(rsmd.getColumnName(i));
				out.println("</th>");
			}

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getLong(1));
				out.println("<td>");
				out.print(rs.getDate(2));
				out.println("<td>");
				out.print(rs.getString(3));
				out.println("<td>");
				out.println(rs.getLong(4));
				out.println("<br>");
				out.println("</tr>");
			}

			out.println("</table></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
