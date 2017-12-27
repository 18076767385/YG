package yidashi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import HIBERNATE.Hibernate;
import Mapping.Zuce;
import Mapping.Zuce;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		Session sessionn=null;
		try{
			Zuce stu=new Zuce();
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String sex=request.getParameter("sex");
			String date=request.getParameter("birthday");
			 Date dater = new SimpleDateFormat("yyyy-MM-dd").parse(date); 
			 
			sessionn=Hibernate.getSession();
			sessionn.beginTransaction();
			stu.setBirthday(dater);
			stu.setName(username);
			stu.setPassword(password);
			stu.setSex(sex);
			sessionn.save(stu);
			sessionn.getTransaction().commit();
			request.getRequestDispatcher("index.jsp").forward(request, response);

			
			
		}catch (Exception e) {
			// TODO: handle exception
			sessionn.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			Hibernate.closeSession();
		}
	}

}
