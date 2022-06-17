package com.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//�����ͺ��̽��� ���̺� �� ����� Entity�� ����
@Entity
//������ ���̺� �̸� ����
@Table(name="tbl_member")

//Builder �������� �ν��Ͻ��� �����ϵ��� ���ִ� ������̼�
@Builder
//��� �Ӽ��� �Ű������� �ϴ� �����ڸ� ����
@AllArgsConstructor
//�Ű������� ���� DefaultConstructor�� ����
@NoArgsConstructor
@Getter
//��� �Ӽ��� toString�� ȣ���� ����� ������ toString �� ����
@ToString
public class Member extends BaseEntity{
	@Id
	private String name;
	
	private LocalDateTime lastlogindate;
}
