package com.tjfae.client1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @Description 测试类
 *
 * @Author Kenn.Won
 *
 * @Date 20200501
*/
@RestController
public class TestController {

    @PostMapping("test1")
    @PreAuthorize("hasAnyAuthority('test1')")
    public String hello(){
        return "具有test1权限";
    }

    @GetMapping("all")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('test2')")
    public String query() {
        return "test2";
    }

}
