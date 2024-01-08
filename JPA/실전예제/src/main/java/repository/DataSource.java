package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSource {

    private static EntityManagerFactory emf;
    private static DataSource dataSource;

    private DataSource(){
        emf = Persistence.createEntityManagerFactory("practice-mysql");
    }

    public static DataSource getDataSource() {
        if(dataSource == null)
            dataSource = new DataSource();
        return dataSource;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
