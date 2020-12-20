package com.codegym.service.contract_detail.impl;

import com.codegym.entity.contract_detail.AttachService;
import com.codegym.repository.contract_detail.AttachServiceRepository;
import com.codegym.service.contract_detail.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(Long id) {
        return attachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public AttachService save(AttachService attachService) {
        return attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Long id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public Page<AttachService> findPageAll(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public Page<AttachService> searchByName(String string, Pageable pageable) {
        return null;
    }

}
