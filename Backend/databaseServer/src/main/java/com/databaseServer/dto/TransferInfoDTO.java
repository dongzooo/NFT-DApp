package com.databaseServer.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferInfoDTO {
	private Long transactionid;
	private String addressto;
	private Double amount;
	private String description;
	//Entity �� ���� �� �� Entity�� �ܷ�Ű�� �߰������� ȭ�� ������� ���� �ʿ��� �����͸� ����
//	private String email;
	private String name;
}
