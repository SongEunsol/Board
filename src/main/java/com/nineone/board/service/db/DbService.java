package com.nineone.board.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineone.board.entity.db.DbEntity;
import com.nineone.board.mapper.db.DbMapper;

@Service
public class DbService {
	@Autowired
	public DbMapper dbMapper;
	DbEntity dbEntity;

	public List<DbEntity> boardList() {
		List<DbEntity> resultList = dbMapper.boardList();
		return resultList;
	}

	public int insertBoard(String bwriter, String bpassword, String btitle, String bcontent) {
		return dbMapper.insertBoard(bwriter, bpassword, btitle, bcontent);
	}

	public int updateBoardById(int bno, String bwriter, String btitle, String bcontent) {
		return dbMapper.updateBoardById(bno, bwriter, btitle, bcontent);
	}

	public int deleteBoardById(int bno) {
		return dbMapper.deleteBoardById(bno);
	}

	public int boardPwdChk(int bno, String bpassword) {
		int result = dbMapper.boardPwdChk(bno, bpassword);
		return result;
	}

}
