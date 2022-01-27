package com.nineone.board.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineone.board.entity.db.DbEntity;
import com.nineone.board.entity.db.DbReplyEntity;
import com.nineone.board.mapper.db.DbMapper;
import com.nineone.board.mapper.db.DbReplyMapper;

@Service
public class DbReplyService {
	@Autowired
	public DbReplyMapper dbReplyMapper;
	DbReplyEntity dbReplyEntity;

	public List<DbReplyEntity> replyList(int bno) {
		List<DbReplyEntity> resultList = dbReplyMapper.replyList(bno);
		return resultList;
	}

//
//	public int insertDB(String writer, String password, String title, String content) {
//		return dbMapper.insertDB(writer, password, title, content);
//	}
//
//	public int updateById(int no, String writer, String password, String title, String content) {
//		return dbMapper.updateById(no, writer, password, title, content);
//	}
//
//	public int deleteById(int no) {
//		return dbMapper.deleteById(no);
//	}
//
//	public int pwdChk(int no, String password) {
//		int result = dbMapper.pwdChk(no, password);
//		return result;
//	}

}
