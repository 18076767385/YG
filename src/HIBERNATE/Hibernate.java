package HIBERNATE;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class Hibernate {

	private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private static SessionFactory sessionFactory=null;
	static{
		try{
			Configuration cfg=new Configuration().configure();
		
			sessionFactory=cfg.buildSessionFactory();
		}catch(Exception e){
			System.out.println("创建会话失败");
			e.printStackTrace();
		}
	}
	public static Session getSession() throws HibernateException{
		Session session=(Session)threadLocal.get();
		if(session==null||!session.isOpen()){
			if(sessionFactory==null){
				rebuildSessionFactory();
			}
			session=(sessionFactory!=null)?sessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	@SuppressWarnings("deprecation")
	public static void rebuildSessionFactory(){
		try{
			Configuration cfg=new Configuration().configure();
			sessionFactory=cfg.buildSessionFactory();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void closeSession() throws HibernateException{
		Session session=(Session)threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
	
}
