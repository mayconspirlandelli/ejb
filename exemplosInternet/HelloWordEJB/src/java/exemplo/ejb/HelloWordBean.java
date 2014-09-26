package exemplo.ejb;


import javax.ejb.Stateless;

/**
 * Session Bean
 * @author maycon
 */
@Stateless
public class HelloWordBean implements HelloWordRemote {

    @Override
    public String olaMund() {
        return "Olá Mundo com EJB!!!";
    }
    
}
