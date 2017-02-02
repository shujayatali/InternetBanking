
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DBConnection;

@WebServlet("/OpenServlet")
public class OpenServlet extends HttpServlet {
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

		try {

			String name = request.getParameter("name");
			long mob = Long.parseLong(request.getParameter("mobile"));
			long adhaar = Long.parseLong(request.getParameter("adhaar"));
			long bal = Long.parseLong(request.getParameter("bal"));

			PrintWriter pw = response.getWriter();

			CallableStatement cs = con.prepareCall("{call insert_data(?,?,?,?,?)}");
			cs.registerOutParameter(1, Types.LONGVARCHAR);
			cs.setString(2, name);
			cs.setLong(3, mob);
			cs.setLong(4, adhaar);
			cs.setLong(5, bal);

			cs.execute();

			pw.println("Generated Account Number is = " + cs.getLong(1));
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
