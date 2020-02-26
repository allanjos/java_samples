package br.com.olivum.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InvestmentsController {
    @RequestMapping(value="/test1", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String test1() {
        System.out.println("/test1");

        return "{\"response\" : \"ok\"}";
    }

    @RequestMapping(value="/test2", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<String> test2() {
        System.out.println("/test2");

        List<String> l = new ArrayList<>();

        l.add("test 1");
        l.add("test 2");
        l.add("test 3");

        return l;
    }
}