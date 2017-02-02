
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DBConnection;

@WebServlet("/CreditServlet")
public class CreditBalanceServlet extends HttpServlet {

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

		long accnum = Long.parseLong(request.getParameter("account_num"));
		long bal = Long.parseLong(request.getParameter("balance"));

		PrintWriter out = response.getWriter();

		CallableStatement cs;
		try {
			cs = con.prepareCall("{call CREDITBALANCE(?,?)}");
			cs.setLong(1, accnum);
			cs.setLong(2, bal);
			cs.execute();

			out.println("Account Balance Credited Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
