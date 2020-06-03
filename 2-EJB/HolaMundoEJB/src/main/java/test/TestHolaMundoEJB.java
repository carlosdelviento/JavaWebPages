package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try{
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEJB = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEJB.sumar(5, 3);
            int resultado2 = holaMundoEJB.restar(4, 2);
            int resultado3 = holaMundoEJB.multiplicar(5, 4);
            System.out.println("Resultado EJB suma 5+3:" + resultado + "\n" + "Resultado EJB resta 4-2:" + resultado2 + "\n" + "Resultado EJB multiplicar 5*4:" + resultado3 );
            
        }
        catch(NamingException e){
            e.printStackTrace(System.out);
        }
    }
}
