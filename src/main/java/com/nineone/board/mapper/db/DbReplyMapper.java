package com.nineone.board.mapper.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.nineone.board.entity.db.DbEntity;
import com.nineone.board.entity.db.DbReplyEntity;

@Repository
@Mapper
public interface DbReplyMapper {
	List<DbReplyEntity> replyList(int bno);

	int insertDB(String writer, String password, String title, String content);

	int updateById(int no, String writer, String password, String title, String content);
	
	int deleteById(int no);
	
	int pwdChk(int no, String password);
}
