/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.ejb;

import javax.ejb.Remote;

/**
 *
 * @author maycon
 */
@Remote
public interface PrimeiroBeanRemote {

    String primeiroMetodoNegocio();
    
}
