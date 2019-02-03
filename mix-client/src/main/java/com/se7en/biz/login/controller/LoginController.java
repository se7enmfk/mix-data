package com.se7en.biz.login.controller;

import com.se7en.biz.login.entity.AdmUser;
import com.se7en.conf.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private SysProperties sysProperties;

    @PostMapping("/login")
    public AdmUser login(@RequestBody AdmUser admUser) {
        admUser.setToken("'8dfhassad0asdjwoeiruty'");
        return admUser;
    }


    @PostMapping("/updatePhpId")
    public AdmUser updatePhpId(@RequestBody AdmUser admUser) {
        sysProperties.setPhpId(admUser.getPhpId());
        return admUser;
    }
}
