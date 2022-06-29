package com.databaseServer.service;

import com.databaseServer.dto.PageResponseTransferInfoDTO;
import com.databaseServer.dto.TransferInfoDTO;
import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;

public interface TransferInfoService {
	//������ ���
	public Long registerTransferInfo(TransferInfoDTO dto);
	//�ϳ��� ������ ��������
	public TransferInfoDTO getTransferInfo(TransferInfoDTO dto);
	//������ ����
	public Long updateTransferInfo(TransferInfoDTO dto);
	//������ ����
	public Long deleteTransferInfo(TransferInfoDTO dto);
	//������ ������ �����͸� ��������
	public PageResponseTransferInfoDTO getListPageRequest (TransferInfoDTO dto);
	
	//DTO�� ENTITY�� ��ȯ���ִ� �޼���
	public default TransferInfo dtoToEntity(TransferInfoDTO dto) {
		TransferInfo transferInfo = TransferInfo.builder()
				.addressto(dto.getAddressto())
				.amount(dto.getAmount())
				.description(dto.getDescription())
				.member(Member.builder().name(dto.getName()).build())
				.build();
		return transferInfo;
				
	}
	
	//Entity�� DTO�� ��ȯ���ִ� �޼���
	public default TransferInfoDTO entityToDto(TransferInfo transferInfo) {
		TransferInfoDTO dto = TransferInfoDTO.builder()
				.addressto(transferInfo.getAddressto())
				.amount(transferInfo.getAmount())
				.description(transferInfo.getDescription())
				.name(transferInfo.getMember().getName())
				.build();
		return dto;
	}
}
