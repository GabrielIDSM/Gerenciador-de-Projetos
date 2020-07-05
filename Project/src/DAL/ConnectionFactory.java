package DAL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    //Atributos
    private static EntityManagerFactory eMF = Persistence.createEntityManagerFactory("PU");
    //Métodos
    public EntityManager getConnection(){
        return eMF.createEntityManager();
    }
    
}