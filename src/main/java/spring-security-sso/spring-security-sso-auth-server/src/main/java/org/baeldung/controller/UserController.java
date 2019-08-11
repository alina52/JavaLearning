package org.baeldung.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: create by Chenyu Wang
 * @version: v1.0
 * @description: org.baeldung.controller
 * @date:2019-08-09
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @RequestMapping(value = "me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
