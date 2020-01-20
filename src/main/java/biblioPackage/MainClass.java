package biblioPackage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//insertarDato();
		listEvents();
	}
	public static void insertarDato() {
		Autor newAutor = new Autor();
		newAutor.setNomautor("loliyo");
		/*Session sesion=HibernateUtil.getSessionFactory().openSession();  
		sesion.beginTransaction();   
		sesion.save(newAutor);  
		sesion.getTransaction().commit();   
		sesion.close();*/
		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		session.save(newAutor);
		tx.commit();
		System.out.println("Autor insertado, "+newAutor.toString());
		session.close();
	}
	  private static void listEvents() {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        ArrayList<Autor> result = (ArrayList<Autor>)session.createQuery("from Autor where id=1").list();
	        session.getTransaction().commit();
	       
	        for (int i=0;i<result.size();i++) {
	        	System.out.println(result.get(i).toString());
	        }
	    }
	/*
	public static void modificarDato() {

		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 

		Transaction tx = session.beginTransaction();

		

		System.out.println("Que id quieres modificar?");


		Autor autorCambio = (Autor) session.load(Autor.class, id_autor);

		autorCambio.setNomAutor("Alberto Pachon");

		

		session.update(autorCambio);

		tx.commit();

		

		System.out.println("Dato modificado");

		

		session.close();

	}

	

	public static void eliminarDato() {

		Session session = sessionFactoryUtil.getSessionFactory().openSession(); 

		Transaction tx = session.beginTransaction();

		

		System.out.println("Que id quieres eliminar?");


		Autor autorCambio = (Autor) session.load(Autor.class, id_autor);

		

		session.delete(autorCambio);

		tx.commit();

		

		System.out.println("Dato eliminado");

		

		session.close();

	}

}
*/
}
