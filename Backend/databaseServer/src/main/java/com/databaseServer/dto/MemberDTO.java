package com.databaseServer.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String name;
	//���۵� ������ ������ ������ �Ӽ�
	private LocalDateTime lastlogindate;
	private LocalDateTime regdate;
}