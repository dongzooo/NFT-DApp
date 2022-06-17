package com.backend.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	//ȸ������, �α��� => ȸ������ ��������, ȸ������ ����, ȸ�� Ż��
	
	//ȸ�� ������ �ϴ� ��� �̸��� �ߺ� üũ�� ���� �޼���
	//�⺻Ű�� ������ �ٸ� �÷��� ������ ��ȸ�� �� ���� ��� ������ �𸣱� ������
	//���� Ÿ���� List
	List<Member>  findMemberByName(String account);
}
