package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author maycon
 */
@Stateless
public class MeuBean implements MeuBeanRemote {

    @Override
    public Integer somar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }

}
