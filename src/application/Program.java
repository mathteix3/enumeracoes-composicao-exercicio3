package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), dateTimeFormatter);

        Order order = new Order();

        order.setClient(new Client(name, email, birthDate));

        System.out.println("\nEnter order data:");
        System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED) : ");
        String status = sc.nextLine().toUpperCase();
        order.setStatus(OrderStatus.valueOf(status));
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline character

        for(int i = 0; i < n; i++){
            System.out.println("\nEnter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline character

            OrderItem orderItem = new OrderItem(quantity,  new Product(productName, productPrice));
            order.addItem(orderItem);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
