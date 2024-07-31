package com.example.guestbook;

import java.util.List;

public interface guestBookservice {
	void insert(GuestBookVO vo);
	List<GuestBookVO> list(GuestBookVO vo);
	int totalcount(GuestBookVO vo);
}
