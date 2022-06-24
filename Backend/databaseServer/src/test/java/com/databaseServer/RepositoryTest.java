package com.databaseServer;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;
import com.databaseServer.persistence.MemberRepository;
import com.databaseServer.persistence.TransferInfoRepository;

@SpringBootTest
public class RepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	//Member�� ������ ����
//	@Test
	public void testRegisterMember() {
		Member member = 
				Member.builder()
				.name("0xCfaf7807a841389433a338Aa70fEB6348E77e8ca")
				.build();
		memberRepository.save(member);
	}

	//�ּҷ� ������ ��ȸ
//	@Test
	public void testFindName() {
		String name = "0xCfaf7807a841389433a338Aa70fEB6348E77e8ca";
		List<Member> list = memberRepository.findMemberByName(name);
		System.out.println(list);
		
		name = "����";
		list = memberRepository.findMemberByName(name);
		System.out.println(list);
		
		if(list.size() > 0) {
			System.out.println("�����Ͱ� �����մϴ�.");
		}else {
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
		}
		
	}
	
	
	@Autowired
	private TransferInfoRepository transferInfoRepository;

	//TransferInfo���� �׽�Ʈ
//	@Test
	public void testInsertTransferInfo() {
		//�ܷ�Ű�� ����
		Member member = Member.builder()
				.name("0xCfaf7807a841389433a338Aa70fEB6348E77e8ca")
				.build();
		for(int i=0; i<100; i++) {
			TransferInfo transferInfo = TransferInfo.builder()
					.addressto("0x"+Integer.toString((int)(Math.random()*100)) +"b89f26f5d635fcAFcBF929136F88c8CCc94E2803")
					.amount((double)((Math.random()*10000)%10))
					.description("transfer to my account")
					.member(member)
					.build();
			transferInfoRepository.save(transferInfo);
		}
	}
	
	
}
