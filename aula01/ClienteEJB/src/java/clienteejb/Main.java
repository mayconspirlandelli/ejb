package clienteejb;

import br.ufg.inf.ejb.PrimeiroBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author maycon
 */
public class Main {
    @EJB
    private static PrimeiroBeanRemote primeiroBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("PrimeiroBean: " + primeiroBean.primeiroMetodoNegocio());
        
        System.out.println("Metodo soma valor 1 com valor 2: " + primeiroBean.soma(10, 20));
    }
    
}
