package com.databaseServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Java������ @�� ���� �ܾ Annotation �̶�� �ϰ� Python������ Decorator ��� �մϴ�.
//���� ����ϴ� �ڵ带 �ϳ��� Ŭ������ ���� �� �� Ŭ������ ���� �ڵ带 ����� ���·� ���� ���Դϴ�.
//�̷� �ڵ带 Annotation�� �̿��ؼ� ���� �� �� �ְ� AOP�� �̿��ؼ� �����ϴ� �͵� �����մϴ�.
@SpringBootApplication
@EnableJpaAuditing
public class DatabaseServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DatabaseServerApplication.class, args);
	}

}
