package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentMinDTO {

    private Long id;

    private Instant moment;

    public PaymentMinDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentMinDTO(Payment payment) {
        this.id = payment.getId();
        this.moment = payment.getMoment();
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
}
