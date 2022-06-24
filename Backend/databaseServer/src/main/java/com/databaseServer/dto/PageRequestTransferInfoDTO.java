package com.databaseServer.dto;

import java.awt.print.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestTransferInfoDTO {
	//������ ��ȣ - 1���� ����
	private int page;
	//�� �������� ������ ������ ����
	private int size;
	
	//Ư�� �׸����� ��ȸ�ϰ��� �ϴ� ���
	//private String condition;
	//private String keyword;
	
	//������
	public PageRequestTransferInfoDTO() {
		page = 1;
		size = 10;
	}
	//������ ��ȣ �� ������ ������ ������ Pageable ��ü�� �������ִ� �޼���
	public Pageable getPageable(Sort sort) {
		//JPA������ ������ ��ȣ�� 0���� �����ϱ� ������ -1
		return (Pageable) PageRequest.of(page-1, size, sort);
	}
}