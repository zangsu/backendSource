import lombok.Getter;
import model.Item;
import repository.DataSource;
import repository.GeneralDAO;

public class Main {
    static GeneralDAO dao = new GeneralDAO();
    public static void main(String[] args) {
        dao.execute(em -> {
            Item item = Item.builder()
                    .name("itemA")
                    .price(10000)
                    .stockQuantity(5)
                    .build();

            em.persist(item);
        });
    }
}
