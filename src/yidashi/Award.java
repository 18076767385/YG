package yidashi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import HIBERNATE.Hibernate;

import Mapping.Liuyan;
import Mapping.Zuce;

/**
 * Servlet implementation class Award
 */
@WebServlet("/Award")
public class Award extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Award() {
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
		Session sessionn=null;
		try{
			String text=request.getParameter("yi");
			HttpSession sesion=request.getSession();
			String st=sesion.getAttribute("key").toString();
			Integer id=Integer.valueOf(st);
			sessionn=Hibernate.getSession();
			sessionn.beginTransaction();
			Liuyan com=(Liuyan)sessionn.get(Liuyan.class,id);
			com.setYi(text);
			
			sessionn.getTransaction().commit();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			sessionn.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			Hibernate.closeSession();
		}
	}


}
