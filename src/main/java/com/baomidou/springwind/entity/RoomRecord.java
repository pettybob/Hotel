package com.baomidou.springwind.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 房间表
 *
 */
@TableName(value = "room_record")
public class RoomRecord {

	/** 主键ID */
	private Long id;
	
	/** 房间号 */
	private String roomNo;
	
	/** 入住时间 */
	private Date  inDate ;
	
	/** 退房时间 */
	private Date outDate;
	
	private String charge;
	
	/** 入住人 */
	private String customer;
	
	/** 入住证件号码 */
	private String userCard;
	
	/** 入住电话号码 */
	private String userPhone;
	
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

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

}
