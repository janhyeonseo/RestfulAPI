package com.example.portoneT;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PortOneTDao {
	void insert(PortOneTVO vo);
	PortOneTVO selectf(PortOneTVO vo);
}
