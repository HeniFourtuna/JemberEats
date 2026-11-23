import java.util.Arrays;
import java.util.List;

import model.Customer;
import model.Order;

import observer.CustomerNotifier;
import observer.RestaurantNotifier;
import observer.CourierNotifier;

import strategy.DeliveryStrategy;

import command.OrderInvoker;
import command.PlaceOrderCommand;
import command.CancelOrderCommand;
import command.RepeatOrderCommand;

import chain.ValidationHandler;
import chain.MenuAvailabilityHandler;
import chain.RestaurantOpenHandler;
import chain.BalanceHandler;
import chain.PromoHandler;

import memento.Cart;
import memento.CartHistory;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       JEMBER EATS SYSTEM");
        System.out.println("==================================");

        Customer customer = new Customer(
            "Heni",
            200000
        );

        System.out.println("\nPelanggan: " + customer.getName());
        System.out.println("Saldo awal: Rp" + customer.getBalance());

        System.out.println("\n=== MEMENTO PATTERN ===");

        Cart cart = new Cart();
        CartHistory cartHistory = new CartHistory();

        cart.addItem("Nasi Goreng");
        cart.addItem("Es Teh");

        cart.displayCart();

        cartHistory.save(cart);

        cart.removeItem("Es Teh");

        cart.displayCart();

        cartHistory.restore(cart);

        cart.displayCart();

        System.out.println("\n=== MEMBUAT PESANAN ===");

        List<String> items = cart.getItems();

        Order order = new Order(
            "ORD001",
            customer,
            items,
            45000
        );

        System.out.println("ID Pesanan: " + order.getOrderId());

        System.out.println("\n=== OBSERVER PATTERN ===");

        order.attach(new CustomerNotifier());
        order.attach(new RestaurantNotifier());
        order.attach(new CourierNotifier());

        System.out.println("\n=== STRATEGY PATTERN ===");

        order.setStrategy(new DeliveryStrategy());

        System.out.println("\n=== CHAIN OF RESPONSIBILITY ===");

        ValidationHandler menu = new MenuAvailabilityHandler();
        ValidationHandler restaurant = new RestaurantOpenHandler(true);
        ValidationHandler balance = new BalanceHandler();
        ValidationHandler promo = new PromoHandler();

        menu.setNext(restaurant)
            .setNext(balance)
            .setNext(promo);

        System.out.println("\n=== COMMAND PATTERN ===");

        OrderInvoker invoker = new OrderInvoker();

        invoker.setCommand(
            new PlaceOrderCommand(
                order,
                menu,
                "JEMBER10"
            )
        );

        invoker.executeCommand();

        System.out.println("\n=== PROSES PESANAN ===");

        if (order.getStatus().equals("DIPROSES")) {

            order.setStatus("SIAP DIANTAR");

            order.setStatus("SEDANG DIANTAR");

            order.setStatus("SELESAI");
        }

        System.out.println("\n=== RINGKASAN PESANAN ===");

        System.out.println("ID Pesanan: " + order.getOrderId());

        System.out.println("Pelanggan: " + customer.getName());

        System.out.println("Daftar makanan:");

        for (String item : order.getItems()) {
            System.out.println("- " + item);
        }

        System.out.println(
            "Total harga: Rp"
            + (order.getTotalPrice() + order.calculateServiceFee())
        );

        System.out.println("Status: " + order.getStatus());

        System.out.println(
            "Sisa saldo: Rp" + customer.getBalance()
        );

        invoker.setCommand(
            new RepeatOrderCommand(order)
        );

        invoker.executeCommand();

        System.out.println("\n=== SIMULASI PEMBATALAN ===");

        Order cancelOrder = new Order(
            "ORD002",
            customer,
            Arrays.asList("Mie Ayam"),
            15000
        );

        cancelOrder.setStrategy(new DeliveryStrategy());

        cancelOrder.attach(new CustomerNotifier());

        double cancelTotal = cancelOrder.getTotalPrice() + cancelOrder.calculateServiceFee();

        customer.deductBalance(cancelTotal);

        cancelOrder.setStatus("DIPROSES");

        invoker.setCommand(
            new CancelOrderCommand(cancelOrder)
        );

        invoker.executeCommand();

        System.out.println("\n==================================");
        System.out.println("     PROGRAM JEMBER EATS SELESAI");
        System.out.println("==================================");
    }
}