package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Train {
    //TrainNo, Source, Destination
    @Id
    private Long trainNo;
    private String source;
    private String destination;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Passenger> passengerList;

    @OneToMany(mappedBy = "train",cascade =CascadeType.ALL,orphanRemoval = true)
    List<FoodOrder> foodOrders;

    public Train() {
    }

    public Train(Long trainNo, String source, String destination, List<Passenger> passengerList, List<FoodOrder> foodOrders) {
        this.trainNo = trainNo;
        this.source = source;
        this.destination = destination;
        this.passengerList = passengerList;
        this.foodOrders = foodOrders;
    }

    public Long getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Long trainNo) {
        this.trainNo = trainNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(List<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNo=" + trainNo +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", passengerList=" + passengerList +
                ", foodOrders=" + foodOrders +
                '}';
    }
}
