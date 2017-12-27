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
import Mapping.Liuyan;


/**
 * Servlet implementation class bb
 */
@WebServlet("/bb")
public class bb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Session sessionn=null;
		try{
			Liuyan stu=new Liuyan();
			
			String liuyan=request.getParameter("yii");
			  
			 
			sessionn=Hibernate.getSession();
			sessionn.beginTransaction();
			
			stu.setLiuyan(liuyan);
			
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
