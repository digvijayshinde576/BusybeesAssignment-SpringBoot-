package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class FoodOrder {
    //TicketId, TrainId, Price
    @Id
    private Long ticketId;
    private double price;
    @ManyToOne
    @JoinColumn(name = "trainno")
    Train train;

    public FoodOrder() {
    }

    public FoodOrder(Long ticketId, double price, Train train) {
        this.ticketId = ticketId;
        this.price = price;
        this.train = train;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "ticketId=" + ticketId +
                ", price=" + price +
                ", train=" + train +
                '}';
    }
}
