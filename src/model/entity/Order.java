package model.entity;

import java.sql.Date;

public class Order {
    private Integer id;
    private String orderName;
    private String orderDescription;
    private Customer customer;
    private Date orderedAt;

    public Order() {
    }

    public Order(Integer id, String orderName, String orderDescription, Customer customer, Date orderedAt) {
        this.id = id;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.customer = customer;
        this.orderedAt = orderedAt;
    }

    public Order(String orderName, String orderDescription, Customer customer) {
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.customer = customer;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }
}
