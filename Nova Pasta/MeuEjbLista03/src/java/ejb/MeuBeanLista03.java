package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author maycon
 */
@Stateless
public class MeuBeanLista03 implements MeuBeanLista03Remote {

    @Override
    public Integer somar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }

    @Override
    public Integer subtrair(Integer valor1, Integer valor2) {
        return valor1 - valor2;
    }

    @Override
    public Integer multiplicar(Integer valor1, Integer valor2) {
        return valor1 * valor2;
    }

    @Override
    public Integer dividir(Integer valor1, Integer valor2) {
        return valor1 / valor2;
    }
    

}
