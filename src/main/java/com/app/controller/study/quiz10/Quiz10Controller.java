package com.app.controller.study.quiz10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.room.Room;
import com.app.dto.custmor.custmor;
import com.app.service.quiz10.Quiz10Custmor;
import com.app.service.quiz10.Quiz10RoomService;
import com.app.service.room.RoomService;

@Controller
public class Quiz10Controller {
	@Autowired					
	Quiz10RoomService roomService;
	Quiz10Custmor custmor;

	@GetMapping("/quiz/roomCustmor")
	public String roomCustmor(Model model) {
		
		System.out.println("start");
		
		//호실 정보 준비
		List<Room> roomList = roomService.findRoomList();
		List<custmor> custmorList = custmor.findcustmorList();
		
		//화면에 전달
		model.addAttribute("roomList",roomList);
		model.addAttribute("custmor",custmorList);
		
		return "quiz/quiz10/roomCustmor";
	}
}
