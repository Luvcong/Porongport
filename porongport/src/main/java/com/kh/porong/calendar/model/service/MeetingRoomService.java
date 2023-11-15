package com.kh.porong.calendar.model.service;

import java.util.ArrayList;

import com.kh.porong.calendar.model.vo.MeetingRoomVO;

public interface MeetingRoomService {
	
	// ------------ 사용자 ------------ 
	// 회의실 예약 현황 리스트 조회
	ArrayList<MeetingRoomVO> selectMeetingRoomList(MeetingRoomVO room);
	
	// 회의실 클릭시 디테일뷰
	MeetingRoomVO selectDetailMeetingRoom(MeetingRoomVO room);
	
	// 회의실 신청
	int insertMeetingRoom(MeetingRoomVO mr);
	
	// ------------ 관리자 ------------
	// ------------- 조회 -------------
	// <예약현황목록>전체(승인/대기/반려) 회의실 리스트 조회
	ArrayList<MeetingRoomVO> selectReservationList(MeetingRoomVO room);
	
	// <예약승인목록>승인할(승인/승인취소) 회의실 리스트 조회
	ArrayList<MeetingRoomVO> selectApprovalList(MeetingRoomVO room);
	
	// <예약현황목록>디테일뷰
	MeetingRoomVO selectDetailReservation(MeetingRoomVO room);
	
	//<예약승인목록>디테일뷰
	MeetingRoomVO selectDetailApprovalList(MeetingRoomVO room);
	
	
	// ----------- 수정/삭제 -----------
	// 예약승인
	int updateAccept(String schStatus);
	
	// 예약반려
	int updateRejection(String schStatus);
	
	// 예약 승인 취소
	int updateCancel(String schStatus);
}
