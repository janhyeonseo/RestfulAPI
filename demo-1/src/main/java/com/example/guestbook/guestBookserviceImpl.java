package com.example.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class guestBookserviceImpl implements guestBookservice{
	
	@Autowired
	GuestBookDao dao;
	
	@Override
	public void insert(GuestBookVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<GuestBookVO> list(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public int totalcount(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return dao.totalcount(vo);
	}

}
