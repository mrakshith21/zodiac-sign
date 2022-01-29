package rakshith.zodiacsign.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rakshith.zodiacsign.dao.ZodiacDao;
import rakshith.zodiacsign.impl.ZodiacDaoImpl;
import rakshith.zodiacsign.exceptions.ZodiacNotFoundException;

/**
 * Servlet implementation class ZodiacServlet
 */
@WebServlet("/ZodiacServlet")
public class ZodiacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZodiacServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String message = null;
		ZodiacDao zdao = new ZodiacDaoImpl();
		if(month != null && day!=null) {
			try {
				String dob = "2000-" + month + "-" + day;
				//System.out.println(dob);
				String zodiac = zdao.getZodiac(dob);
				System.out.println(zodiac);
				goToPage(request, response, "ZodiacSign.jsp?zodiac=" + zodiac);
				return;
			} catch (ZodiacNotFoundException znfe) {
				message = "Invalid date of birth...zodiac not found";
				goToPage(request, response, "ZodiacSign.jsp?message=" + message);
				return;
			}
		}
		goToPage(request, response, "ZodiacSign.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void goToPage(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher rp = request.getRequestDispatcher(url);
		rp.forward(request, response);
	}

}
