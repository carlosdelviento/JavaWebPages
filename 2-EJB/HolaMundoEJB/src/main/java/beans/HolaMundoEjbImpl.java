package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo sumar en el servidor");
        return a + b;
    }
    
    public int multiplicar(int a, int b){
    	System.out.println("Ejecutando método multiplicar en el servidor");
    	return a * b;
    }
    
    public int restar(int a, int b){
    	System.out.println("Ejecutando método restar en el servidor");
    	return a - b;
    }
}
