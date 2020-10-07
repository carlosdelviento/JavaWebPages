package uy.com.cb.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import org.apache.logging.log4j.*;
import uy.com.cb.sga.domain.Persona;

public class PersistirObjetoJPA {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Inicia la transaccion
		
		//Paso 1. Crear objeto nuevo
		//Objeto en estado transitivo
		Persona persona1=new Persona("Pedro","Luna","pluna@mail.com","13115566");
		
		//Paso 2. Inicia transaccion
		tx.begin();
		
		//Paso 3. Ejecuta SQL
		em.persist(persona1);
		
		//Paso 4. Commit/rollback
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto persistido - estado detached:" + persona1);
		
		//Cerramos el entity manager
		em.close();
	}
}
