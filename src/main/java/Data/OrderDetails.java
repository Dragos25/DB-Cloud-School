package Data;

public class OrderDetails {
    private int id;
    private String productCode;
    private int quantity;
    private float priceEach;
    private int orderId;

    public OrderDetails() {
    }

    public OrderDetails(String productCode, int quantity, float priceEach, int orderId) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(float priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", priceEach=" + priceEach +
                ", orderId=" + orderId +
                '}';
    }
}
