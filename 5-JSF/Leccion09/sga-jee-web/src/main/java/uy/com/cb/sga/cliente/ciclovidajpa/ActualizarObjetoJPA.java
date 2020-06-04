package uy.com.cb.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import uy.com.cb.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {
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
		// El id proporcionado debe existir en la base de datos
		Persona persona1 = em.find(Persona.class, 1);

		// Paso 3. Termina transaccion 1
		tx.commit();

		// Objeto en estado de detached
		log.debug("Objeto recuperado:" + persona1);

		// Paso 4. Modificar objeto
		persona1.setApellido("Juarez");

		// Paso 5. Inicia transaccion 2
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();

		// Paso 6. Modificamos el objeto
		// Se puede usar el metodo flush() en casos puntuales
		em.merge(persona1);

		// Paso 7. Termina transaccion 2
		tx2.commit();

		// Objeto en estado detached ya modificado
		log.debug("Objeto recuperado" + persona1);

		// Cerramos el entity manager
		em.close();
	}

}
