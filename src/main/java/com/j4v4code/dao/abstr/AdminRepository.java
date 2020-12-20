package com.j4v4code.dao.abstr;

import com.j4v4code.model.Admin;

import java.io.Serializable;

public interface AdminRepository {

    // Get Admin By userName
    Admin findByUserName(String userName);

}
