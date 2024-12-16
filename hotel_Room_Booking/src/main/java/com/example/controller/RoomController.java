package com.example.controller;

import com.example.entity.Room;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

   @DeleteMapping("/{roomId}")
    public String deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return "Room no." +roomId+" Deleted Succesfully...";

    }

    @GetMapping
    public List<Room> getAvailableRooms(){
        return roomService.getAvailableRoom();
    }

    @PutMapping("/bookRoom/{roomId}")
    public ResponseEntity<?> roomBooking(@PathVariable Long roomId ){
        return new ResponseEntity<>(roomService.bookingAvailableRoom(roomId), HttpStatus.ACCEPTED);

    }

    @PutMapping("/unBookRoom/{roomId}")
    public ResponseEntity<?> unBookingRoom(@PathVariable Long roomId) {
    return new ResponseEntity<>(roomService.unBookingRoom(roomId),HttpStatus.ACCEPTED);

    }
}
