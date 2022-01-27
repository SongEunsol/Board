package com.nineone.board.dto.response.db;


import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class DbResponse {
	final List<String> message;
	
	public DbResponse(java.util.List<String> messageList) {
		this.message = messageList;
	}

}
