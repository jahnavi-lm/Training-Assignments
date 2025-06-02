package CollectionMay02.JavaCollection_Assignment_02June;

import java.util.*;

public class ProductCatalog {
    Map<ProductDetails, Integer> catalog = new HashMap<>();

    public void addProduct(ProductDetails product, int quantity){
        if(catalog.containsKey(product)){
            System.out.println("Duplicate Product ID: "+ product.getProductId());
            return;
        }
        catalog.put(product, quantity);
    }

    public Integer getQuantity(int id){
        for(ProductDetails pd : catalog.keySet()){
            if(pd.getProductId() == id){
                return catalog.get(pd);
            }
        }
        return null;
    }

    public void updateQuantity(int id, int quantity){
        for(ProductDetails pd : catalog.keySet()){
            if(pd.getProductId() == id){
                catalog.put(pd, quantity);
                return;
            }
        }
    }

    public void deleteProduct(int id){
        for(ProductDetails pd : catalog.keySet()){
            if(pd.getProductId() == id){
                catalog.remove(pd);
                return;
            }
        }
    }

    public Map<ProductDetails, Integer> getAllProducts(){
        return new HashMap<>(catalog);
    }

    public void displayProducts(List<Map.Entry<ProductDetails, Integer>> productList) {
        for (Map.Entry<ProductDetails, Integer> entry : productList) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }


    public List<Map.Entry<ProductDetails, Integer>> sortByProductId(){
        List<Map.Entry<ProductDetails, Integer>> sortedList = new ArrayList<>(catalog.entrySet());
        sortedList.sort(Comparator.comparing(e -> e.getKey().getProductId()));
        return sortedList;
    }

    public List<Map.Entry<ProductDetails, Integer>> sortByProductName() {
        List<Map.Entry<ProductDetails, Integer>> sortedList = new ArrayList<>(catalog.entrySet());
        sortedList.sort(Comparator.comparing(e -> e.getKey().getProductName()));
        return sortedList;
    }

}
