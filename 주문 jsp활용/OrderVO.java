package main.sec01.order;

public class OrderVO {
    private String order_num;
    private String order_item;
    private String prod_id;
    private String quantity;
    private String item_price;

    public OrderVO() {
    }

    public OrderVO(String order_num, String order_item, String prod_id, String quantity, String item_price) {
        this.order_num = order_num;
        this.order_item = order_item;
        this.prod_id = prod_id;
        this.quantity = quantity;
        this.item_price = item_price;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getOrder_item() {
        return order_item;
    }

    public void setOrder_item(String order_item) {
        this.order_item = order_item;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "order_num='" + order_num + '\'' +
                ", order_item='" + order_item + '\'' +
                ", prod_id='" + prod_id + '\'' +
                ", quantity='" + quantity + '\'' +
                ", item_price='" + item_price + '\'' +
                '}';
    }
}
