package CollectionMay02.JavaCollection_Assignment_02June;

public class ProductDetails {

    private int productId;
    private String productName;
    private String category;
    private double price;

    public ProductDetails(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  productId + "|" +
                " " + productName + "|" +
                " " + category + "|" +
                " " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDetails)) return false;
        ProductDetails pd = (ProductDetails) o;
        return productId == pd.productId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(productId);
    }
}


