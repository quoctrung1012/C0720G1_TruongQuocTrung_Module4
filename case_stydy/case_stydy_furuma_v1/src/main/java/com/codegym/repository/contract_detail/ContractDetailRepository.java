package com.codegym.repository.contract_detail;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract_detail.AttachService;
import com.codegym.entity.contract_detail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    Page<ContractDetail>findByAttachServiceContaining(String input, Pageable pageable);
    Iterable<ContractDetail> findByAttachService(AttachService attachService);
    Iterable<ContractDetail> findByContractContaining(Contract contract);
}
