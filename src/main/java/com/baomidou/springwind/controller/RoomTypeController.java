package com.baomidou.springwind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.entity.RoomType;
import com.baomidou.springwind.service.IRoomService;
import com.baomidou.springwind.service.IRoomTypeService;

/**
 * <p>
 *  房间类型管理相关操作
 * </p>
 *
 *
 * @Author Jack
 * @Date 2016/4/15 15:03
 */
@Controller
@RequestMapping("/perm1/roomType")
public class RoomTypeController extends BaseController {

	@Autowired
	private IRoomTypeService roomTypeService;

	@Autowired
	private IRoomService RoomService;

	@Permission("5002")
	@RequestMapping("/list")
	public String list(Model model) {
		return "/roomType/list";
	}

    @Permission("5002")
    @RequestMapping("/edit")
    public String edit(Model model, Long id ) {
    	if ( id != null ) {
			model.addAttribute("roomType", roomTypeService.selectById(id));
		}
        return "/roomType/edit";
    }
    
	@ResponseBody
	@Permission("5002")
	@RequestMapping("/editRoomType")
	public String editRoomType( RoomType roomType ) {
		boolean rlt = false;
		if (roomType.getId() != null) {
			rlt = roomTypeService.updateById(roomType);
		} else {
			rlt = roomTypeService.insert(roomType);
		}
		return callbackSuccess(rlt);
	}
	
	@ResponseBody
	@Permission("5002")
	@RequestMapping("/delete/{id}")
	public String delete( @PathVariable Long id ) {
		boolean exist = RoomService.existRoom(id+"");
		if ( exist ) {
			return "false";
		}
		return booleanToString(roomTypeService.deleteById(id));
	}


	@ResponseBody
	@Permission("5002")
	@RequestMapping("/getRoomTypeList")
	public String getRoomTypeList() {
		Page<RoomType> page = getPage();
		return jsonPage(roomTypeService.selectPage(page, null));
	}


	@ResponseBody
	@Permission("5002")
	@RequestMapping("/{roomTypeId}")
	public RoomType getRoomType(@PathVariable Long roomTypeId) {
		return roomTypeService.selectById(roomTypeId);
	}

}
