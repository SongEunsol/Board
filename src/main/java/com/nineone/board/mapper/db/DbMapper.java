package com.nineone.board.mapper.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.nineone.board.entity.db.DbEntity;

@Repository
@Mapper
public interface DbMapper {
	List<DbEntity> boardList();

	int insertBoard(String bwriter, String bpassword, String btitle, String bcontent);

	int updateBoardById(int bno, String bwriter, String btitle, String bcontent);
	
	int deleteBoardById(int bno);
	
	int boardPwdChk(int bno, String bpassword);
}
