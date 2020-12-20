package com.j4v4code.service.concrete;

import com.j4v4code.dao.abstr.AdminRepository;
import com.j4v4code.model.Admin;
import com.j4v4code.service.abstr.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class AdminManager implements AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminManager(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin findByUserName(String userName) {
        return adminRepository.findByUserName(userName);
    }
}
