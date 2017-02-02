
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HubServlet")
public class HubServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("action");
		if (type.equals("OpenAccount")) {
			RequestDispatcher rd = request.getRequestDispatcher("/openaccount.html");
			rd.forward(request, response);

		} else if (type.equals("Close Account")) {
			RequestDispatcher rd = request.getRequestDispatcher("/open.html");
			rd.forward(request, response);
		} else if (type.equals("BalanceEnquiry")) {
			RequestDispatcher rd = request.getRequestDispatcher("/balanceenquiry.html");
			rd.forward(request, response);
		} else if (type.equals("CreditBalance")) {
			RequestDispatcher rd = request.getRequestDispatcher("/creditbalance.html");
			rd.forward(request, response);
		} else if (type.equals("DebitBalance")) {
			RequestDispatcher rd = request.getRequestDispatcher("/debitbalance.html");
			rd.forward(request, response);
		} else if (type.equals("Transfer")) {
			RequestDispatcher rd = request.getRequestDispatcher("/transferbalance.html");
			rd.forward(request, response);
		} else if (type.equals("MiniStatement")) {
			RequestDispatcher rd = request.getRequestDispatcher("/ministatement.html");
			rd.forward(request, response);
		}

	}

}
