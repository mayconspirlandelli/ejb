/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientemeuejbwslista03;

import javax.swing.JOptionPane;

/**
 *
 * @author maycon
 */
public class ClienteMeuEjbWsLista03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a;
        Integer b;
        Integer resultado;

        String strA = JOptionPane.showInputDialog(null, "Informe o primeiro valor (a): ");
        String strB = JOptionPane.showInputDialog(null, "Informe o primeiro valor (b): ");

        a = new Integer(strA);
        b = new Integer(strB);

        resultado = somar(a, b);
        JOptionPane.showMessageDialog(null, strA + "+" + strB + " = " + resultado);

        resultado = subtrair(a, b);
        JOptionPane.showMessageDialog(null, strA + "-" + strB + " = " + resultado);

        resultado = multiplicar(a, b);
        JOptionPane.showMessageDialog(null, strA + "*" + strB + " = " + resultado);

        resultado = dividir(a, b);
        JOptionPane.showMessageDialog(null, strA + "*" + strB + " = " + resultado);

    }

    private static Integer somar(java.lang.Integer valor1, java.lang.Integer valor2) {
        ejb.MeuEjbWsLista03_Service service = new ejb.MeuEjbWsLista03_Service();
        ejb.MeuEjbWsLista03 port = service.getMeuEjbWsLista03Port();
        return port.somar(valor1, valor2);
    }

    private static Integer subtrair(java.lang.Integer valor1, java.lang.Integer valor2) {
        ejb.MeuEjbWsLista03_Service service = new ejb.MeuEjbWsLista03_Service();
        ejb.MeuEjbWsLista03 port = service.getMeuEjbWsLista03Port();
        return port.subtrair(valor1, valor2);
    }

    private static Integer multiplicar(java.lang.Integer valor1, java.lang.Integer valor2) {
        ejb.MeuEjbWsLista03_Service service = new ejb.MeuEjbWsLista03_Service();
        ejb.MeuEjbWsLista03 port = service.getMeuEjbWsLista03Port();
        return port.multiplicar(valor1, valor2);
    }

    private static Integer dividir(java.lang.Integer valor1, java.lang.Integer valor2) {
        ejb.MeuEjbWsLista03_Service service = new ejb.MeuEjbWsLista03_Service();
        ejb.MeuEjbWsLista03 port = service.getMeuEjbWsLista03Port();
        return port.dividir(valor1, valor2);
    }

}
