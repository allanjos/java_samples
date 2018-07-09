package br.com.olivum.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.olivum.springweb.model.Investment;

@Controller
public class InvestmentsController {
    @RequestMapping(value="/investment", method = RequestMethod.GET)
    public ModelAndView investment() {
        System.out.println("/investment");

        return new ModelAndView("investment", "command", new Investment(1, "Investment 01"));
    }
}