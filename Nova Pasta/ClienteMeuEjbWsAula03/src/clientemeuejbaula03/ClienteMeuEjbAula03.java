package clientemeuejbaula03;
import javax.swing.*;

/**
 *
 * @author maycon
 */
public class ClienteMeuEjbAula03 {

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
        
        resultado = somar(a,b);
        JOptionPane.showMessageDialog(null, strA + "+" + strB + " = " + resultado);
        
    }

    private static Integer somar(java.lang.Integer valor1, java.lang.Integer valor2) {
        ejb.MeuEjbWs_Service service = new ejb.MeuEjbWs_Service();
        ejb.MeuEjbWs port = service.getMeuEjbWsPort();
        return port.somar(valor1, valor2);
    }
    
}
