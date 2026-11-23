package model;

import java.util.ArrayList;
import java.util.List;

import observer.OrderObserver;
import strategy.OrderStrategy;

public class Order {

    private String orderId;
    private Customer customer;
    private List<String> items;
    private String status;
    private double totalPrice;

    private OrderStrategy strategy;

    private List<OrderObserver> observers;

    public Order(String orderId, Customer customer,
                List<String> items, double totalPrice) {

        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalPrice = totalPrice;
        this.status = "DIBUAT";

        this.observers = new ArrayList<>();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(String status) {
        this.status = status;

        System.out.println("\nStatus pesanan diperbarui: " + status);

        notifyObservers();
    }

    public void setStrategy(OrderStrategy strategy) {
        this.strategy = strategy;
    }

    public void processService() {
        if (strategy != null) {
            strategy.processOrder();
        }
    }

    public double calculateServiceFee() {
        if (strategy != null) {
            return strategy.calculateFee();
        }

        return 0;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public String getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}