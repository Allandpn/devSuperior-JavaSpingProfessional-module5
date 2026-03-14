package com.devsuperior.dscommerce.entities;

public class OrdemItemDTO {
    private Long productId;

    private String name;

    private Double price;

    private Integer quantity;


    public OrdemItemDTO(Long productId, Integer quantity, Double price, String name) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public OrdemItemDTO(OrderItem orderItem) {
        this.productId = orderItem.getProduct().getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.name = orderItem.getProduct().getName();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal(){
        return price * quantity;
    }
}
