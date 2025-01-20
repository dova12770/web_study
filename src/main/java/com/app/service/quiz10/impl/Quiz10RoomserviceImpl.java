package com.app.service.quiz10.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.service.quiz10.Quiz10RoomService;

@Service
public class Quiz10RoomserviceImpl implements Quiz10RoomService{
	
	@Autowired
	RoomDAO roomDAO;

	@Override
	public List<Room> findRoomList() {
		System.out.println("room호출");
		List<Room> roomList = roomDAO.findRoomList();
		return roomList;
	}
	

	
}
