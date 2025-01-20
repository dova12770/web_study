package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

//Data 읽어오는 역할 DB접근역할 	DAO, Repository
// APIServiceRepository
@Repository			//bean 등록 annotation
public class RoomDAOImpl implements RoomDAO{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Room> findRoomList() {
		
		System.out.println("RoomDAO 호출 됨");
		//db 연결 조회
		
		return null;
	}

	@Override
	public int saveRoom(Room room) {

		//db 에 전달받은 room 객체에 들어있는 데이터를 잘 저장
		
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom",room);
		
		return result;
	}

}
