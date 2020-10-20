package com.example.ecommerce.controller;

import com.example.ecommerce.protocol.RequestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping(value = "/test", produces = "application/json")
    @ResponseBody
    public RequestResponse test() {
        System.out.println("test()");

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setStatus(0);
        requestResponse.setMessage("test");

        return requestResponse;
    }
}