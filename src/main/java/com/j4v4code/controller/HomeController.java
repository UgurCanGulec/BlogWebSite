package com.j4v4code.controller;


import com.j4v4code.model.Admin;
import com.j4v4code.service.abstr.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/login")
public class HomeController {

    private AdminService adminService;

    @Autowired
    public HomeController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password) {

     /*   Admin admin = adminService.findByUserName(username);

        if (admin!=null) {
            if (admin.getUserName().equals(username) && admin.getUserPassword().equals(password)){
                return "home";
            }else{
              //TODO:
            }

        }else{
            //TODO:
        }
        return "index";
    }*/
        List<Admin> allAdmin = adminService.allAdminGet();
        String address="";
        for (Admin admin : allAdmin) {
            if (admin.getUserName().equals(username) && admin.getUserPassword().equals(password)) {
                address="home";
                break;
            } else {
                address="index";
            }

        }
        return address;
    }
}
