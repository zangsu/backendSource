package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public class GeneralDAO {
    DataSource dataSource = DataSource.getDataSource();
    EntityManagerFactory emf = dataSource.getEmf();

    public void execute(Consumer<EntityManager> consumer){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            consumer.accept(em);
            tx.commit();
            System.out.println("committed");
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            System.out.println("rollback");
        }finally {
            em.close();
        }
    }
}
