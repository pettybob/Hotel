package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 房间表
 *
 */
@TableName(value = "room")
public class Room {

	/** 主键ID */
	private Long id;
	
	/** 房间号 */
	private String roomNo;
	
	/** 客房类型 */
	private String roomType;

	/** 客房状态 */
	private String sts;
	
	/**当前入住记录ID*/
	private String recordId;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}



	
}
