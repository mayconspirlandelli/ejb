package exemplo.ejb;


import javax.ejb.Remote;

/**
 *
 * @author maycon
 */
@Remote
public interface HelloWordRemote {
    public String olaMund();
}
