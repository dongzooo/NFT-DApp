package com.databaseServer.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.databaseServer.dto.MemberDTO;
import com.databaseServer.model.Member;
import com.databaseServer.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public String registerMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		//�̸��� �ߺ� üũ
//		Optional<Member> optional = memberRepository.findById(dto.getEmail());
//		if(optional.isPresent()) {
//			return "�����ϴ� �̸���";
//		}
		//�����ּ�(name) �ߺ� üũ
		List<Member> list = memberRepository.findMemberByName(dto.getName());
		if(list.size() > 0) {
			return "�����ϴ� �̸�";
		}
		
		memberRepository.save(member);
		return member.getName();
	}

	@Override
	public MemberDTO loginMemer(MemberDTO memberDTO) {
		//�����ּ�(name)�� ������ �����͸� ã�ƿɴϴ�.
		Optional <Member> optional = 
				memberRepository.findById(memberDTO.getName());
		//�����ϴ� �����ּ�(name)
		if(optional.isPresent()) {
			//��й�ȣ Ȯ��
			Member member = optional.get();
			if(member != null) {
				//�α��ο� �������� �� �α��� �� �ð��� ������Ʈ
				ZonedDateTime nowUTC = ZonedDateTime.now(ZoneId.of("UTC"));
				LocalDateTime now = nowUTC.withZoneSameInstant(
						ZoneId.of("Asia/Seoul")).toLocalDateTime();
				Member updateMember = Member.builder()
						.name(member.getName())
						.lastlogindate(now)
						.build();
				memberRepository.save(updateMember);
				
				return entityToDto(member);
			}else {
				return null;
			}
		}
		//�������� �ʴ� �̸���
		else {
			return null;
		}
	}

	@Override
	public MemberDTO getMemer(MemberDTO memberDTO) {
		//�����ּ�(name)�� ������ �����͸� ã�ƿɴϴ�.
		Optional <Member> optional = 
				memberRepository.findById(memberDTO.getName());
		//�����ϴ� �����ּ�(name)
		if(optional.isPresent()) {
			//��й�ȣ Ȯ��
			Member member = optional.get();
			return entityToDto(member);
		}else {
			return null;
		}
	}

	@Override
	public String updateMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		memberRepository.save(member);
		return member.getName();
	}

	@Override
	public String deleteMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		memberRepository.delete(member);
		return member.getName();
	}

}
