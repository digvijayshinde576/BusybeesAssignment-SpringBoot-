package com.example.service;

import com.example.entity.Room;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);
    void deleteRoom(Long roomId);
    List<Room> getAvailableRoom();
    String bookingAvailableRoom(Long roomId);
    String unBookingRoom(Long roomId);
}
