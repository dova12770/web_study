package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor

//@NoArgsConstructor
//@AllArgsConstructor
@Data	//자주쓰는 것 한번에 추가
public class Room {

	int roomId;	// Primary Key 기본키 식별자
	String buildingNumber;	//동 이름	A동 B동
	int roomNumber; //호실번호 101 404
	int floor;		//층 	7	8
	int maxGuestCount;	
	String viewType;	//오션 	시티	 마운틴
						//OCN / CTY / MOT
						// 1	 2	   3
	//int accomodationId;
}


