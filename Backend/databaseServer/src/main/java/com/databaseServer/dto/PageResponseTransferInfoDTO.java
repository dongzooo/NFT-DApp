package com.databaseServer.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.databaseServer.model.TransferInfo;

import lombok.Data;

import org.springframework.data.domain.Pageable;

@Data
public class PageResponseTransferInfoDTO {
	//DTO ����Ʈ
	private List<TransferInfo> itemList;
	
	//��ü ������ ����
	private int totalPage;
	
	//���� ������ ��ȣ
	private int page;
	
	//������ ��ȣ ��� ũ��
	private int size;
	//����� ������ ��ȣ ���� �� ����
	private int start, end;
	//���� �� ���� ����
	private boolean prev, next;
	//������ ��ȣ ���
	private List<Integer> pageList;
	
	//������ ��ȣ ����� ������ִ� �޼���
	public void makePageList(Pageable pageable) {
		page = pageable.getPageNumber() + 1;
		size = pageable.getPageSize();
		
		int tempEnd = (int)(Math.ceil(page/10.0)) * 10;
		start = tempEnd - 9;
		prev = start > 1;
		end = totalPage > tempEnd ? tempEnd : totalPage;
		next = totalPage > tempEnd;
		pageList = IntStream.rangeClosed(start, end)
				.boxed().collect(Collectors.toList());
	}
	
}



