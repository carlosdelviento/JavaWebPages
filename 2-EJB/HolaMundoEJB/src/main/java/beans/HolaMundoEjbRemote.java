package beans;

import javax.ejb.Remote;

@Remote
public interface HolaMundoEjbRemote {
    public int sumar(int a, int b);
    public int multiplicar(int a, int b);
    public int restar(int a, int b);
}
