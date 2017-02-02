
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

@WebServlet("/DebitServlet")
public class DebitBalanceServlet extends HttpServlet {

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
		long bal = Long.parseLong(request.getParameter("balance"));
		PrintWriter out = response.getWriter();

		try {
			CallableStatement cs = con.prepareCall("call DEBITBALANCE(?,?)");
			cs.setLong(1, acc_num);
			cs.setLong(2, bal);
			cs.execute();
			out.println("amount withdrawn successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
