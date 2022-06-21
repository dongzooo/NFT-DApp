package com.databaseServer.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databaseServer.model.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
		//ȸ�� ������ �ϴ� ��� �ּ� �ߺ� üũ�� ���� �޼���
		//�⺻Ű�� ������ �ٸ� �÷��� ������ ��ȸ�� �� ���� ��� ������ �𸣱� ������
		//���� Ÿ���� List
		List<Member>  findMemberByName(String name);
}
