package com.devsuperior.dscommerce.entities;

import com.devsuperior.dscommerce.dto.ClientMinDTO;
import com.devsuperior.dscommerce.dto.PaymentMinDTO;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderDTO {

    private Long id;

    private Instant moment;

    private OrderStatus status;

    private ClientMinDTO client;

    private PaymentMinDTO payment;

    @NotEmpty(message = "O pedido deve ter pelo menos um item")
    private List<OrderItemDTO> itens = new ArrayList<>();

    public OrderDTO() {
    }



    public OrderDTO(Long id, PaymentMinDTO payment, ClientMinDTO client, OrderStatus status, Instant moment) {
        this.id = id;
        this.payment = payment;
        this.client = client;
        this.status = status;
        this.moment = moment;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.payment = (entity.getPayment() == null ? null : new PaymentMinDTO(entity.getPayment()));
        this.client = new ClientMinDTO(entity.getClient());
        this.status = entity.getStatus();
        this.moment = entity.getMoment();
        for(OrderItem order : entity.getItems()){
            itens.add(new OrderItemDTO(order));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ClientMinDTO getClient() {
        return client;
    }

    public void setClient(ClientMinDTO client) {
        this.client = client;
    }

    public PaymentMinDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentMinDTO payment) {
        this.payment = payment;
    }

    public List<OrderItemDTO> getItens() {
        return itens;
    }

    public Double getTotal() {
        double sum = 0.0;
        for(OrderItemDTO item : itens){
            sum += item.getSubTotal();
        }
        return sum;
    }

}
