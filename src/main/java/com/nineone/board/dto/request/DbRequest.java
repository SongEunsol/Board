package com.nineone.board.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class DbRequest {
	@Getter @Setter int bno;
	@Getter @Setter @NotNull(message = "작성자를 입력해주세요") @Size(max=20, message = "작성자는 20자 이내로 입력해주세요") String bwriter;
	@Getter @Setter @Size(max=20, message = "비밀번호는 20자 이내로 입력해주세요") String bpassword;
	@Getter @Setter @NotNull(message = "제목을 입력해주세요") @Size(max=100, message = "제목은 100자 이내로 입력해주세요") String btitle;
	@Getter @Setter @NotNull(message = "내용을 입력해주세요") @Size(max=300, message = "내용은 300자 이내로 입력해주세요") String bcontent;
}