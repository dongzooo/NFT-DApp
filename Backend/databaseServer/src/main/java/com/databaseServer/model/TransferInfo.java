package com.databaseServer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//Builder �������� �ν��Ͻ��� �����ϵ��� ���ִ� ������̼�
@Builder
//��� �Ӽ��� �Ű������� �ϴ� �����ڸ� ����
@AllArgsConstructor
//�Ű������� ���� DefaultConstructor�� ����
@NoArgsConstructor

//getter, setter, toString ��� ����
@Data

//��� �Ӽ��� toString�� ȣ���� ����� ������ toString �� ����
//member.toString�� ����
@ToString(exclude="member")
public class TransferInfo {
	@Id
	//�⺻Ű ���� auto_increment �� sequence�� �̿��ؼ� �ڵ� ����
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionid;
	
	@Column(length=200, nullable = false)
	private String addressto;
	@Column
	private Double amount;
	@Column(length=200)
	private String description;
//	@Column(length=255)
//	private String pictureurl;
	
	//����� �� �� �����͸� �������ڴٴ� �ɼ�
	@ManyToOne(fetch=FetchType.LAZY)
	private Member member;

}
