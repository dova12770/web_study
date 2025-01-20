CREATE TABLE T_ROOM(
	room_id NUMBER Primary key,
	building_number VARCHAR2(32) NOT NULL,
	room_number NUMBER(6) NOT NULL,
	floor NUMBER(4),
	max_guest_count NUMBER(6) NOT NULL,
	view_type VARCHAR2(8) NOT NULL
);

Create SEQUENCE SEQ_T_ROOM_PK
START WITH 1
INCREMENT BY 1
NOCYCLE;