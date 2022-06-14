package com.redi.grocery;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cart {
    private final UUID productId;
    private final UUID custId;
    private int quantity;
    private int orderStatus;
    private LocalDateTime localDateTime;

    public Cart(UUID productId, UUID custId, int quantity, int orderStatus, LocalDateTime localDateTime) {
        this.productId = productId;
        this.custId = custId;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.localDateTime = localDateTime;
    }


    public UUID getProductId() {
        return productId;
    }

    public UUID getCustId() {
        return custId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return productId + "," + custId + "," + quantity + "," + orderStatus + "," + localDateTime;
    }
}
