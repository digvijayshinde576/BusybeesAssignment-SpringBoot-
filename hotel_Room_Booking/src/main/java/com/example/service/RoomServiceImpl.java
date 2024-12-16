package com.example.service;

import com.example.entity.Room;
import com.example.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.findById(roomId).orElseThrow(()-> new RuntimeException("RoomId Not Available..."));
        roomRepository.deleteById(roomId);

    }

    @Override
    public List<Room> getAvailableRoom() {
        List<Room> roomList=new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if(room.isRoomAvailable()==true){
                roomList.add(room);
            }
        }

        return roomList;
    }

    @Override
    public String bookingAvailableRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.get().isRoomAvailable()){
            room.orElseThrow().bookRoom(false);
            return "Room Booked Successfully....";
        }
        return "Room is not Available for Booking.....";
    }

    @Override
    public String unBookingRoom(Long roomId) {
       Optional<Room> room= roomRepository.findById(roomId);
       if (!room.get().isRoomAvailable()){
           room.get().unBookRoom(true);
           return "Now Room no. "+roomId+" is Available......";
       }
       return "Room no."+roomId+" is already Available.";


    }
}
