package ejb;

import javax.ejb.Remote;

/**
 *
 * @author maycon
 */
@Remote
public interface MeuBeanRemote {

    Integer somar(Integer valor1, Integer valor2);
    
}
