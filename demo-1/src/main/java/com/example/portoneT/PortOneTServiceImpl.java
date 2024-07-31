package com.example.portoneT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortOneTServiceImpl implements PortOneTService{
	
	@Autowired
	PortOneTDao dao;
	
	@Override
	public String insert(PortOneTVO vo) {
		try {
			dao.insert(vo);
			return "/PortOneT/result?Mpaygym="+vo.getMpaygym();
		}catch(Exception e) {
			return "/PortOneT/failurl";
		}
		
	}

	@Override
	public PortOneTVO selectf(PortOneTVO vo) {
		return dao.selectf(vo);
	}

}
