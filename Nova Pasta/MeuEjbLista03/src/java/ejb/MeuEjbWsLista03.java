/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author maycon
 */
@WebService(serviceName = "MeuEjbWsLista03")
@Stateless()
public class MeuEjbWsLista03 {
    @EJB
    private MeuBeanLista03Remote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "somar")
    public Integer somar(@WebParam(name = "valor1") Integer valor1, @WebParam(name = "valor2") Integer valor2) {
        return ejbRef.somar(valor1, valor2);
    }

    @WebMethod(operationName = "subtrair")
    public Integer subtrair(@WebParam(name = "valor1") Integer valor1, @WebParam(name = "valor2") Integer valor2) {
        return ejbRef.subtrair(valor1, valor2);
    }

    @WebMethod(operationName = "multiplicar")
    public Integer multiplicar(@WebParam(name = "valor1") Integer valor1, @WebParam(name = "valor2") Integer valor2) {
        return ejbRef.multiplicar(valor1, valor2);
    }

    @WebMethod(operationName = "dividir")
    public Integer dividir(@WebParam(name = "valor1") Integer valor1, @WebParam(name = "valor2") Integer valor2) {
        return ejbRef.dividir(valor1, valor2);
    }
    
}
