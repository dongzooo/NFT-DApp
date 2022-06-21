package com.databaseServer.persistence;

import java.util.List;

import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferInfoRepository extends JpaRepository<TransferInfo, Long>{
	//Member�� �̿��ؼ� Member �� �ۼ��� ��� TransferInfo�� ��ȸ�ϴ� �޼���
		List<TransferInfo> findTransferInfoByMember(Member member);
}
