package clientews;

import javax.swing.JOptionPane;

/**
 *
 * @author maycon
 */
public class ClienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog(null, "Informe um nome:");
        JOptionPane.showMessageDialog(null, sayHello(nome));
    }

    private static String sayHello(java.lang.String nome) {
        ws.HelloWordWS_Service service = new ws.HelloWordWS_Service();
        ws.HelloWordWS port = service.getHelloWordWSPort();
        return port.sayHello(nome);
    }
    
}
