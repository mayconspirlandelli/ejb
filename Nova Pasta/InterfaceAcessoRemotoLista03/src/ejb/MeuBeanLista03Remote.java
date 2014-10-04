/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author maycon
 */
@Remote
public interface MeuBeanLista03Remote {

    Integer somar(Integer valor1, Integer valor2);

    Integer subtrair(Integer valor1, Integer valor2);

    Integer multiplicar(Integer valor1, Integer valor2);

    Integer dividir(Integer valor1, Integer valor2);
    
}
