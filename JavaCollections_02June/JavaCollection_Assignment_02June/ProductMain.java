package CollectionMay02.JavaCollection_Assignment_02June;

public class ProductMain {
    public static void main(String[] args){
        ProductManage pm = new ProductManage();
        pm.addProduct(new ProductDetails(101, "Mobile", "Electronics", 10000));
        pm.addProduct(new ProductDetails(102, "Paints", "House Hold", 500));
        pm.addProduct(new ProductDetails(103, "Pens", "Stationery", 100));
        pm.addProduct(new ProductDetails(104, "Laptop", "Electronics", 20000));
        pm.addProduct(new ProductDetails(105, "5star", "Food Items", 50));

        for(ProductDetails p: pm.getAllProducts()){
            System.out.println(p);
        }

        pm.addProduct(new ProductDetails(104, "Charger", "Electronics", 500));

        System.out.println();
        System.out.println(pm.getProductById(102));

        System.out.println();
        pm.updateProduct(new ProductDetails(103, "Notebook", "Stationery", 100));

        System.out.println();
        pm.deleteProduct(102);


        System.out.println();

        for(ProductDetails p: pm.sortProductsById()){
            System.out.println(p);
        }
        System.out.println();

        for(ProductDetails p: pm.sortProductsByName()){
            System.out.println(p);
        }
   }
}
