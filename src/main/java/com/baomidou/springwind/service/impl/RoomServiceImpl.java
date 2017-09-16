package com.baomidou.springwind.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.springwind.entity.Room;
import com.baomidou.springwind.mapper.RoomMapper;
import com.baomidou.springwind.service.IRoomService;
import com.baomidou.springwind.service.support.BaseServiceImpl;

/**
 *
 * Room 表数据服务层接口实现类
 *
 */
@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements IRoomService {

	@Override
	public boolean existRoom(String roomType) {
		Room ur = new Room();
		ur.setRoomType(roomType);
		int rlt = baseMapper.selectCount(new EntityWrapper<Room>(ur));
		return rlt >= 1;
	}

}