package com.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

//���̺�� �������� ���� ���� ������ ����ϰڴٶ�� �ǹ�
@MappedSuperclass
//Entity�� ���� ������ �߻����� �� �۾��� ����
@EntityListeners(value= {AuditingEntityListener.class})

//Lombok ���̺귯������ �Ӽ��� getter �޼��带 ������ִ� ������̼�
@Getter
abstract class BaseEntity {
	//���� ��¥�� �̿�
	@CreatedDate
	//���̺� ����� �� ���� regdate ��� �÷����� �����ǰ� ������ �� �� ����
	@Column(name="regdate", updatable=false)
	private LocalDateTime regDate;
	
	//������ ���� ��¥�� �̿�
	@LastModifiedDate
	//���̺� ����� �� ���� moddate ��� �÷����� ����
	@Column(name="moddate")
	private LocalDateTime modDate;
	
}