import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    @Test
    public void testRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Хлеб", 50);
        repository.add(product);

        repository.removeById(1);
        Product[] result = repository.findAll();
        assertEquals(0, result.length);
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Молоко", 100));

        assertThrows(NotFoundException.class, () -> repository.removeById(2),
                "Должно быть выброшено NotFoundException"
        );
    }
}
