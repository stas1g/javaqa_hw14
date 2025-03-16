public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Метод добавления товара в репозиторий
     *
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    /**
     * Метод для получения всех товаров
     *
     * @return — массив всех товаров
     */
    public Product[] findAll() {
        return products;
    }

    /**
     * Метод удаления товара по идентификатору
     *
     * @param id — идентификатор товара, который нужно удалить
     */
    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        boolean found = false;

        for (Product product : products) {
            if (product.getId() != id) {
                if (index < tmp.length) {
                    tmp[index] = product;
                    index++;
                }
            } else {
                found = true;
            }
        }

        if (!found) {
            throw new NotFoundException("Product with id " + id + " not found");
        }

        // Создаем новый массив нужного размера и копируем туда существующие элементы
        Product[] result = new Product[index];
        for (int i = 0; i < index; i++) {
            result[i] = tmp[i];
        }

        products = result;
    }
}
