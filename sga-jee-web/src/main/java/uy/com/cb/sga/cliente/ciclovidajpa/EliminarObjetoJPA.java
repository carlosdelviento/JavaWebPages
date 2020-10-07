package uy.com.cb.sga.cliente.ciclovidajpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uy.com.cb.sga.domain.Persona;

public class EliminarObjetoJPA {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
		EntityManager em = emf.createEntityManager();

		// Inicia la transaccion

		// Paso 1. Iniciar una transaccion
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Paso 2. Ejecutar SQL de tipo select
		Persona persona1 = em.find(Persona.class, 4);

		// Paso 3. termina transaccion 1
		tx.commit();

		// Objeto en estado detached
		log.debug("Objeto encontrado:" + persona1);

		// Paso 4. Inicia transaccion 2
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();

		// Paso 5. Ejecuta SQL que es un delete
		em.remove(em.merge(persona1));

		// Paso 6. termina transaccion 2
		tx2.commit();

		// Objeto en estado detached ya eliminado en db
		log.debug("Objeto eliminado" + persona1);

		// Cerramos el entity manager
		em.close();
	}
}
