package com.baomidou.springwind.entity;


public class RoomType {

	/** 主键ID */
	private Long id;
	
	/** 房间类型名称 */
	private String typeName ;
	
	/** 面积 */
	private String area ;
	
	/** 床位 */
	private String bedNum ;
	
	/** 价格 */
	private String price ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBedNum() {
		return bedNum;
	}
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
