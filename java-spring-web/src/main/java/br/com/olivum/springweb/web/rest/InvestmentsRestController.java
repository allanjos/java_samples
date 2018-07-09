package br.com.olivum.springweb.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.olivum.springweb.model.Investment;

@RestController
public class InvestmentsRestController {
    @RequestMapping(value = "/rest/investment/all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Investment> all() {
        System.out.println("InvestmentRestController.xyz()");

        List<Investment> list = new ArrayList<>();

        list.add(new Investment(1, "Investment 01"));
        list.add(new Investment(2, "Investment 02"));
        list.add(new Investment(3, "Investment 03"));

        return list;
    }

    @RequestMapping(value = "/rest/investment",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Investment investment(@RequestParam(value="name", defaultValue="") String name) {
        System.out.println("InvestmentRestController.investment()");

        long id = 1;

        return new Investment(id, name);
    }

    @RequestMapping(value = "/rest/investment/{id}",
                            method = RequestMethod.GET,
                            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Investment getInvestment(@PathVariable("id") long id) {
        System.out.println("InvestmentRestController.investment()");

        return new Investment(id, "Investment " + id);
    }
}
