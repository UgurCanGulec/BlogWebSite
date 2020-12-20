package com.j4v4code.service.abstr;

import com.j4v4code.model.Admin;

import java.util.List;

public interface AdminService {
    // Get Admin By UserName
    List<Admin> allAdminGet();
    Admin findByUserName(String userName);

}
