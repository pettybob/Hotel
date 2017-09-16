package com.baomidou.springwind.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.entity.Room;
import com.baomidou.springwind.service.IRoomService;
import com.baomidou.springwind.service.IRoomTypeService;

/**
 * <p>
 * 客房管理相关操作
 * </p>
 *
 */
@Controller
@RequestMapping("/perm1/room")
public class RoomController extends BaseController {

	@Autowired
	private IRoomService RoomService;
	
	@Autowired
	private IRoomTypeService RoomTypeService;

	@Permission("5003")
	@RequestMapping("/list")
	public String list(Model model) {
		return "/room/list";
	}
	
	
    @Permission("5003")
    @RequestMapping("/edit")
    public String edit(Model model, Long id ) {
    	if ( id != null ) {
			model.addAttribute("room", RoomService.selectById(id));
		}
    	model.addAttribute("RoomTypeList", RoomTypeService.selectList(null));
        return "/room/edit";
    }
	
	@ResponseBody
	@Permission("5003")
	@RequestMapping("/getRoomList")
	public String getRoomList() {
		Page<Room> page = getPage();
		return jsonPage(RoomService.selectPage(page, null));
	}

	@ResponseBody
	@Permission("5003")
	@RequestMapping("/editRoom")
	public String editRoom( Room room ) {
		Map<String, String> retMap = new HashMap<String, String>();
		retMap.put("_RetCode", "-1");
		boolean rlt = false;
		if ( room != null ) {
			if ( room.getId() != null ) {
				rlt = RoomService.updateById(room);
			} else {
				room.setSts("空闲");//初始值位空闲
				try {
					rlt = RoomService.insert(room);
				} catch (DuplicateKeyException e) {
					retMap.put("_RetCode", "-1");
					retMap.put("_RetMsg", "已存在相同的房间号!");
					return callbackSuccess(retMap);
				}
			}
		}
		if (rlt) {
			retMap.put("_RetCode", "0");
		}
		return callbackSuccess(retMap);
	}
}
