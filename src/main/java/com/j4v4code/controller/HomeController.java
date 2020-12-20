package com.j4v4code.controller;


import com.j4v4code.model.Admin;
import com.j4v4code.service.abstr.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/login")
public class HomeController {

    private AdminService adminService;

    @Autowired
    public HomeController(AdminService adminService) {
        this.adminService = adminService;
    }

/*
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String login(@RequestParam Long username,
                        @RequestParam String password){

        Admin admin = adminService.findByUserName(username);

        if (admin!=null) {
            if (admin.getPassword().equals(password)){
                return "home";
            }else{
              //TODO:
            }

        }else{
            //TODO:
        }
        return "index";
    }
*/
}
