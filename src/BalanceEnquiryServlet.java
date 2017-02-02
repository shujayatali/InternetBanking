
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

@WebServlet("/CheckServlet")
public class BalanceEnquiryServlet extends HttpServlet {

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
		Long account_num = Long.parseLong(request.getParameter("account_num"));

		CallableStatement cs = null;
		PrintWriter out = response.getWriter();

		try {
			cs = con.prepareCall("{call CHECK_BALANCE(?,?)}");
			cs.registerOutParameter(1, Types.LONGVARCHAR);
			cs.setLong(2, account_num);

			cs.execute();

			out.println("Available Balance = " + cs.getLong(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
