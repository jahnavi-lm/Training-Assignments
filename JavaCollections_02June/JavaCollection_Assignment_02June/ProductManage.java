package CollectionMay02.JavaCollection_Assignment_02June;
import java.util.*;


public class ProductManage {
     List<ProductDetails> productList = new ArrayList<>();
     Set<Integer> productIdset = new HashSet<>();

     public void addProduct(ProductDetails product){
         if(productIdset.contains(product.getProductId())){
             System.out.println("Duplicate Product ID: "+product.getProductId());
             return;
         }
         productList.add(product);
         productIdset.add(product.getProductId());
     }

     public ProductDetails getProductById(int id){
         for(ProductDetails product: productList){
             if(product.getProductId() == id)
                 return product;
         }
         return null;
     }

     public boolean updateProduct(ProductDetails product){
         for(int i=0;i<productList.size();i++){
             if(productList.get(i).getProductId() == product.getProductId()){
                 productList.set(i, product);
                 return true;
             }
         }
         return false;
     }

     public boolean deleteProduct(int id){
         for(int i=0;i<productList.size();i++){
             if(productList.get(i).getProductId() == id){
                 productList.remove(i);
                 productIdset.remove(id);
                 return true;
             }
         }
         return false;
     }

     public List<ProductDetails> getAllProducts(){
         return new ArrayList<>(productList);
     }

    public List<ProductDetails> sortProductsById() {
         List<ProductDetails> sortId =  new ArrayList<>(productList);
         sortId.sort(Comparator.comparing(ProductDetails::getProductId));
         return sortId;
    }

    public List<ProductDetails> sortProductsByName(){
         List<ProductDetails> sortName = new ArrayList<>(productList);
         sortName.sort(Comparator.comparing(ProductDetails::getProductName));
         return sortName;
     }

}
