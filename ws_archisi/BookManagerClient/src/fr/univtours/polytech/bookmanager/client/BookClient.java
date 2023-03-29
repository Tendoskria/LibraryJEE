package fr.univtours.polytech.bookmanager.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.univtours.polytech.bookmanager.business.BooksBusinessRemote;

public class BookClient {

	public static void main(String[] args) throws NamingException {
	    // Cette objet business va nous permettre d'appeler les services métiers disponibles,
	    // c'est-à-dire ceux définis dans l'interface distante : BooksBusinessRemote.
	    BooksBusinessRemote business = getBusiness();
	}

	/**
    * 
    * @return L'EJB session pour manipulation.
    * @throws NamingException Si l'EJB n'est pas trouvé dans l'annuaire JNDI.
    */
	private static BooksBusinessRemote getBusiness() throws NamingException {
	    Properties jndiProperties = new Properties();
	    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	    jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
	    Context ctx = new InitialContext(jndiProperties);

	    String appName = "BookManagerEAR";
	    String projectName = "BookManagerEJB";
	    String className = "BooksBusinessImpl";
	    String remote = BooksBusinessRemote.class.getName();

	    String url = "ejb:" + appName + "/" + projectName + "/" + className + "!" + remote;//

	    BooksBusinessRemote business = (BooksBusinessRemote) ctx.lookup(url);

	    return business;
	}

}
