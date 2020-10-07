package uy.com.cb.sga.cliente.asociaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import javax.persistence.*;
import uy.com.cb.sga.domain.Persona;
import uy.com.cb.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteAsociacionesJPA {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
		EntityManager em = emf.createEntityManager();

		List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();

		// cerramos la conexion
		em.close();

		// Imprimimos todos los objetos de tipo persona de tipo lazzy (carga
		// retardada de los objetos persona)
		for (Persona persona : personas) {
			log.debug("Personas" + persona);
			// recuperamos los usuarios de cada persona
			for (Usuario usuario : persona.getUsuarioList()) {
				log.debug("Usuario:" + usuario);
			}
		}
	}

}
