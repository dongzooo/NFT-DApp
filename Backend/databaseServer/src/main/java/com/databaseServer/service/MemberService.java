package com.databaseServer.service;

import com.databaseServer.dto.MemberDTO;
import com.databaseServer.model.Member;

public interface MemberService {
	//������ ����
	public String registerMember(MemberDTO dto);
	public MemberDTO loginMemer(MemberDTO memberDTO);
	public MemberDTO getMemer(MemberDTO memberDTO);
	public String updateMember(MemberDTO dto);
	public String deleteMember(MemberDTO dto);
	
	//DTO Ŭ������ ��ġ�� Model Ŭ������ ��ü�� ��ȯ
	public default Member dtoToEntity(MemberDTO dto) {
		Member member = Member.builder()
				.name(dto.getName())
				.lastlogindate(dto.getLastlogindate())
				.build();
		
		return member;
	}
	
	//Model ��ü�� DTO Ŭ������ ��ȯ
	public default MemberDTO entityToDto(Member member) {
		MemberDTO dto = MemberDTO.builder()
				.name(member.getName())
				.regdate(member.getRegDate())
				.lastlogindate(member.getLastlogindate())
				.build();
		
		return dto;
	}
}
