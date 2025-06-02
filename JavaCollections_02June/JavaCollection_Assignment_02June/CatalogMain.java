package CollectionMay02.JavaCollection_Assignment_02June;
import java.util.*;

public class CatalogMain {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct(new ProductDetails(201, "Laptop", "Electronics", 75000), 5);
        catalog.addProduct(new ProductDetails(202, "Monitor", "Electronics", 15000), 3);
        catalog.addProduct(new ProductDetails(203, "Book", "Stationery", 500), 20);
        catalog.addProduct(new ProductDetails(204, "Pen", "Stationery", 25), 100);
        catalog.displayProducts(new ArrayList<>(catalog.getAllProducts().entrySet()));

        catalog.addProduct(new ProductDetails(202, "Monitor Pro", "Electronics", 18000), 2);
        System.out.println(catalog.getQuantity(203));

        catalog.updateQuantity(204, 120);

        catalog.deleteProduct(201);

        catalog.displayProducts(catalog.sortByProductId());
        catalog.displayProducts(catalog.sortByProductName());
    }

}
