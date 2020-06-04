package uy.com.cb.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;	
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uy.com.cb.sga.domain.Persona;

public class EncontrarObjetoJPA {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
		EntityManager em = emf.createEntityManager();

		// Inicia la transaccion

		// Paso 1. Iniciar una transaccion
		// Objeto en estado transitivo
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Paso 2. Ejecuta SQL de tipo select
		Persona persona1 = em.find(Persona.class, 1);

		//Paso 3. Termina transaccion
		tx.commit();
		
		//Objeto en estado de detached
		log.debug("Objeto recuperado:" + persona1);
		
		// Cerramos el entity manager
		em.close();
	}

}
