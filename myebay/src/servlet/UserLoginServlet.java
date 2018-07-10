package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method").trim();
		if("login".equals(method)){
			login(request,response);
		}else if("exit".equals(method)) {
			exit(request,response);
		}
	}


	private void exit(HttpServletRequest request, HttpServletResponse response) {
	
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDao().getUser(name, password);
        if (null != user) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/listProduct.jsp");
        } else
            response.sendRedirect("/login.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
