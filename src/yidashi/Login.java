package yidashi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import HIBERNATE.Hibernate;

import Mapping.Liuyan;
import Mapping.Zuce;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Session session=null;
			
			try{
				HttpSession sesssionn=request.getSession();
				session=Hibernate.getSession();
				String username=request.getParameter("user");
				String password=request.getParameter("password");
				
				if(username.equals("manager")&&password.equals("123")){
					session=Hibernate.getSession();
					session.beginTransaction();
					String hql="from Liuyan com where com.yi=null";
					Query q=session.createQuery(hql);
					List<Liuyan> list=q.list();
					session.getTransaction().commit();
					request.setAttribute("listt", list);
					request.getRequestDispatcher("Manager.jsp").forward(request, response);
					return;
				}
				
				
					String hql="from Zuce";
					Query query=session.createQuery(hql);
					ArrayList<Zuce> users=(ArrayList<Zuce>) query.list();
					for(Zuce user:users){
						if(user.getName().equals(username)&&user.getPassword().equals(password)){
							sesssionn.setAttribute("username", username);
							request.setAttribute("Status", "dsa");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						return;
						}
							
					
					
				}
					response.sendRedirect("default.jsp");
				
				
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
