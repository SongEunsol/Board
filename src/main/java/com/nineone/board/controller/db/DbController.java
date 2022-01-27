package com.nineone.board.controller.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineone.board.controller.common.AbstractController;
import com.nineone.board.dto.request.DbRequest;
import com.nineone.board.dto.response.db.ResponseBuilder;
import com.nineone.board.entity.db.DbEntity;
import com.nineone.board.service.db.DbService;

@RestController
@RequestMapping("/api")
public class DbController extends AbstractController {
	@Autowired
	DbService dbService;

	@GetMapping("/boardList")
	public ResponseEntity boardList() {
		List<DbEntity> list = dbService.boardList();
		if (list.size() > 0) {
			return ResponseBuilder.success(list);
		}
		return ResponseBuilder.fail("1101", "게시글이 존재하지 않습니다");
	}
	
	@PostMapping("/insertBoard")
	public ResponseEntity insertBoard(@RequestBody @Validated DbRequest req) {
		if (dbService.insertBoard(req.getBwriter(), req.getBpassword(), req.getBtitle(), req.getBcontent()) == 1) {
			return ResponseBuilder.success("게시글 작성 성공");
		}
		return ResponseBuilder.fail("1102", "게시글 작성 실패");
	}

	@PostMapping("/updateBoardById")
	public ResponseEntity updateBoardById(@RequestBody @Validated DbRequest req) {
		if (dbService.updateBoardById(req.getBno(), req.getBwriter(), req.getBtitle(),
				req.getBcontent()) == 1) {
			return ResponseBuilder.success("게시글 수정 성공");
		}
		return ResponseBuilder.fail("1103", "게시글 수정 실패");
	}

	@PostMapping("/deleteBoardById")
	public ResponseEntity deleteBoardById(@RequestBody DbRequest req) {
		if (dbService.deleteBoardById(req.getBno()) > 0) {
			return ResponseBuilder.success("게시글 삭제 성공");
		}
		return ResponseBuilder.fail("1103", "게시글 삭제 실패");
	}

	@PostMapping("/checkBoardPwd")
	public ResponseEntity checkBoardPwd(@RequestBody DbRequest req) {
		if (dbService.boardPwdChk(req.getBno(), req.getBpassword()) == 1) {
			return ResponseBuilder.success("비밀번호 일치");
		}
		return ResponseBuilder.fail("1104", "비밀번호 불일치");
	}

}
