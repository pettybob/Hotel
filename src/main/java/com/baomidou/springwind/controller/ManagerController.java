package com.baomidou.springwind.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.entity.Room;
import com.baomidou.springwind.entity.RoomRecord;
import com.baomidou.springwind.entity.RoomType;
import com.baomidou.springwind.entity.vo.RoomVo;
import com.baomidou.springwind.mapper.RoomRecordMapper;
import com.baomidou.springwind.service.IRoomService;
import com.baomidou.springwind.service.IRoomTypeService;

/**
 * <p>
 * 客房管理相关操作
 * </p>
 *
 */
@Controller
@RequestMapping("/perm1/manager")
public class ManagerController extends BaseController {

	@Autowired
	private IRoomService RoomService;
	
	@Autowired
	private RoomRecordMapper roomRecordMapper;
	
	@Autowired
	private IRoomTypeService RoomTypeService;

	@Permission("5001")
	@RequestMapping("/list")
	public String list(Model model) {
		return "/manager/list";
	}
	
	@ResponseBody
	@Permission("5001")
	@RequestMapping("/getRoomList")
	public String getRoomList() {
		Page<Room> page = getPage();
		Page<RoomVo> newPage = getPage();
		RoomService.selectPage(page, null);
		List<Room> rooms = page.getRecords();
		newPage.setSize(page.getSize());
		newPage.setTotal(page.getTotal());
		List<RoomVo> roomVoList = new ArrayList<RoomVo>();
		for (Room room : rooms) {
			RoomType roomType= RoomTypeService.selectById(room.getRoomType());
			RoomRecord roomRecord = roomRecordMapper.selectById(room.getRecordId());
			roomVoList.add(new RoomVo(room ,roomType,roomRecord));
		}
		newPage.setRecords(roomVoList);
		return jsonPage(newPage);
	}

	@Permission("5001")
	@RequestMapping("/edit")
	public String edit( Model model, Long id ) {
		if ( id != null ) {
			model.addAttribute("room", RoomService.selectById(id));
		}
		return "/manager/edit";
	}
	
	
	@ResponseBody
	@Permission("5001")
	@RequestMapping("/editRoom")
	public String editRoom(RoomVo roomVo) {
		Map<String, String> retMap = new HashMap<String, String>();
		//入住流程  产生唯一标志号
		RoomRecord roomRecord = new RoomRecord();
		Room room = new Room();
		if ("".equals(roomVo.getRecordId())) {
			long recordId = System.currentTimeMillis();
			
			roomRecord.setId(recordId);
			roomRecord.setCharge(roomVo.getCharge());//收费
			roomRecord.setRoomNo(roomVo.getRoomNo());//房号
			roomRecord.setInDate(new Date());//入住时间
			roomRecord.setCustomer(roomVo.getCustomer());//顾客名
			roomRecord.setUserCard(roomVo.getUserCard());//顾客身份证号
			roomRecord.setUserPhone(roomVo.getUserPhone());//顾客手机号
			roomRecordMapper.insert(roomRecord);//新增客户入住记录
			
			room.setId(roomVo.getId());
			room.setSts("入住");
			room.setRecordId(recordId+"");
			RoomService.updateById(room);//修改客房的入住记录ID为刚刚新增的记录ID
		} else {
			//退房流程
			try {
				roomRecord.setOutDate(new Date());//退房时间
				roomRecord.setId(Long.parseLong(roomVo.getRecordId()));
				roomRecordMapper.updateById(roomRecord);
				
				room.setId(roomVo.getId());
				room.setSts("空闲");
				room.setRecordId("");
				RoomService.updateById(room);//清空客房属性的入住记录ID
			} catch (Exception e) {
				e.printStackTrace();
				retMap.put("_RetCode", "-1");
				retMap.put("_RetMsg", "办理业务失败");
				return callbackSuccess(retMap);
			}
		}
		
		retMap.put("_RetCode", "0");
		retMap.put("_RetMsg", "办理成功");
		return callbackSuccess(retMap);
	}
	
//	@ResponseBody
//	@Permission("5003")
//	@RequestMapping("/editRoom")
//	public String editRoom( Room room ) {
//		Map<String, String> retMap = new HashMap<String, String>();
//		retMap.put("_RetCode", "-1");
//		boolean rlt = false;
//		if ( room != null ) {
//			if ( room.getId() != null ) {
//				rlt = RoomService.updateById(room);
//			} else {
//				room.setSts("空闲");//初始值位空闲
//				try {
//					rlt = RoomService.insert(room);
//				} catch (DuplicateKeyException e) {
//					retMap.put("_RetCode", "-1");
//					retMap.put("_RetMsg", "已存在相同的房间号!");
//					return callbackSuccess(retMap);
//				}
//			}
//		}
//		if (rlt) {
//			retMap.put("_RetCode", "0");
//		}
//		return callbackSuccess(retMap);
//	}

}
