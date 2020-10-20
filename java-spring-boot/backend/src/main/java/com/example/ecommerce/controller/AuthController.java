package com.example.ecommerce.controller;

import com.example.ecommerce.protocol.RequestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AuthController {
    @GetMapping(value = "/user", produces = "application/json")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping(value = "/login", produces = "application/json")
    @ResponseBody
    public RequestResponse login() {

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setMessage("login");

        return requestResponse;
    }
}