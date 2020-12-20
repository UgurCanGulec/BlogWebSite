package com.j4v4code.service.abstr;

import com.j4v4code.model.Admin;

public interface AdminService {
    // Get Admin By UserName
    Admin findByUserName(String userName);

}
