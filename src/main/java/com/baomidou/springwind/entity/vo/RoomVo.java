package com.baomidou.springwind.entity.vo;

import java.util.Date;

import com.baomidou.springwind.entity.Room;
import com.baomidou.springwind.entity.RoomRecord;
import com.baomidou.springwind.entity.RoomType;


/**
 *
 * 客房联表示图
 *
 */

public class RoomVo  {

//	/** 主键ID */
//	@TableId
//	private Long id;
//	
//	/** 房间号 */
//	private String roomNo;
//	
//	/** 客房类型 */
//	private String roomType;
//
//	/** 使用者 */
//	private String roomUser;
//
//	/** 客房状态 */
//	private String sts;
//	
//	/** 定金 */
//	private String perCharge;
//	


	/** 房间主键ID */
	private Long id ;
	
	/** 房间号 */
	private String roomNo;
	
	/** 房型 */
	private String roomType;
	
	/** 房间状态 */
	private String sts;
	
	/** 房间床位数量 */
	private String bedNum;
	
	/** 房号 */
	private String roomId;
	
	/** 房间价格 */
	private String price;
	
	/** 当前标记入住记录*/
	private String recordId;
	
	/** 入住时间 */
	private Date  inDate ;
	
	/** 退房时间 */
	private Date outDate;
	
	/** 入住人 */
	private String customer;
	
	/** 入住证件号码 */
	private String userCard;
	
	/** 入住电话号码 */
	private String userPhone;
	
	
	private String charge;
	

	public Long getId() {
		return id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getSts() {
		return sts;
	}

	public String getBedNum() {
		return bedNum;
	}

	public String getPrice() {
		return price;
	}


	public Date getInDate() {
		return inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public String getRoomId() {
		return roomId;
	}


	public String getCustomer() {
		return customer;
	}


	public String getUserCard() {
		return userCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
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

	public RoomVo (Room room ,RoomType roomType ,RoomRecord roomRecord){
		this.id = room.getId();
		this.roomNo = room.getRoomNo();
		this.price = roomType.getPrice();
		this.bedNum = roomType.getBedNum();
		this.roomType = roomType.getTypeName();
		if (roomRecord != null) {
			this.customer = roomRecord.getCustomer();
			this.inDate = roomRecord.getInDate();
			this.charge = roomRecord.getCharge();
			this.userCard = roomRecord.getUserCard();
			this.userPhone = roomRecord.getUserPhone();
			this.recordId = roomRecord.getId()+"";
		}
		this.sts = room.getSts();
		
	}

	public RoomVo() {
		super();
	}
	
}
