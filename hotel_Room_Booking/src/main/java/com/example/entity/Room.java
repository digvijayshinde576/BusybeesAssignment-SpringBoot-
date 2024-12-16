package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private boolean roomAvailable;

    public Room() {
    }

    public Room(Long roomId, boolean roomAvailable) {
        this.roomId = roomId;
        this.roomAvailable = roomAvailable;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public boolean isRoomAvailable() {
        return roomAvailable;
    }

    public void bookRoom(boolean roomAvailable) {
        this.roomAvailable = roomAvailable;
    }
    public void unBookRoom(boolean roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomAvailable=" + roomAvailable +
                '}';
    }
}
