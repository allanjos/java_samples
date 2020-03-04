package br.com.olivum.materials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/test")
public class TestController {
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<String> test() {
        System.out.println("TestController.test()");

        List<String> rv = new ArrayList<>();

        rv.add("1");
        rv.add("2");
        rv.add("3");

        return rv;
    }
}