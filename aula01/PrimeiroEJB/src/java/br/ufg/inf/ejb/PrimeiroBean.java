package br.ufg.inf.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Maycon Spirlandelli
 */
@Stateless
public class PrimeiroBean implements PrimeiroBeanRemote {

    @Override
    public String primeiroMetodoNegocio() {
        return "Olá Mundo";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}