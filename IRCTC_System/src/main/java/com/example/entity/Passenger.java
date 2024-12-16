package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity

//TicketId, TrainId ,Date, Age, Gender
public class Passenger {
    @Id
    private  Long ticketId;
    private LocalDate date;
    private Long age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "trainId")
    Train train;

    public Passenger() {
    }

    public Passenger(Long ticketId, LocalDate date, Long age, String gender, Train train) {
        this.ticketId = ticketId;
        this.date = date;
        this.age = age;
        this.gender = gender;
        this.train = train;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticketId=" + ticketId +
                ", date=" + date +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", train=" + train +
                '}';
    }
}
