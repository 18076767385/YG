package yidashi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import HIBERNATE.Hibernate;

import Mapping.Liuyan;

/**
 * Servlet implementation class LiuyanServlet
 */
@WebServlet("/LiuyanServlet")
public class LiuyanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiuyanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session=null;
		try{
			session=Hibernate.getSession();
			session.beginTransaction();
			String hql="from Liuyan com where com.yi!=null";
			Query q=session.createQuery(hql);
			List<Liuyan> list=q.list();
			for(Liuyan s:list){
				System.out.println(s.getYi());;
			}
			session.getTransaction().commit();
			request.setAttribute("list", list);
			request.getRequestDispatcher("liuyan.jsp").forward(request, response);
			
					
		}catch (Exception e) {
			// TODO: handle except
			e.printStackTrace();
			session.getTransaction().rollback();
			
		}finally {
			Hibernate.closeSession();
		}
		
	}

}
