package entities;

public class OrderItem {
    private Integer quantity;

    private Product product = new Product();

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double subTotal(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + ", Quantity: " + getQuantity() + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
