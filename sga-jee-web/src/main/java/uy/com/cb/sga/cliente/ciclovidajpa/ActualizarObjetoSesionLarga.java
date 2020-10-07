package uy.com.cb.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uy.com.cb.sga.domain.Persona;

public class ActualizarObjetoSesionLarga {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
		EntityManager em = emf.createEntityManager();

		// Inicia la transaccion

		// Paso 1. Iniciar una transaccion
		// Objeto en estado transitivo
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		//Paso 2. ejecutamos SQL de tipo select
		Persona persona1 = em.find(Persona.class, 1);
		
		log.debug("Objeto encontrado:" + persona1);
		
		//Paso3. Modificar objeto
		persona1.setEmail("jjuarez@mail.com");
		
		persona1.setEmail("j.juarez@mail.com");
		
		//Paso 3. Termina la transaccion 1
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto modificado" + persona1);
		
		//Paso 4. Termina la transaccion 1
		tx.commit();		
		
		// Cerramos el entity manager
		em.close();
	}

}
