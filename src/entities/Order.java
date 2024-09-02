package entities;

import entities.enums.OrderStatus;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private OrderStatus status;
    private Client client = new Client();
    private final LocalDateTime moment = LocalDateTime.now();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final ArrayList<OrderItem> orderItems = new ArrayList<>();

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public double total(){
        double total = 0;
        for (OrderItem item : orderItems){
            total += item.subTotal();
        }
        return total;
    }

    public String getItemsList (){
        StringBuilder items = new StringBuilder();
        for(OrderItem item : orderItems){
            items.append(item).append("\n");
        }
        return items.toString();
    }

    @Override
    public String toString() {
        return  "Order moment: " + getMoment().format(dateTimeFormatter) + "\n" +
                "Order status: " + getStatus() + "\n" +
                "Client: " + client.getName() + " - " + client.getEmail() + "\n" +
                "Order items: " + "\n" +
                getItemsList() + "\n" +
                "Total price: $" + String.format("%.2f", total());
    }
}
