package br.com.olivum.materials.controller;

import br.com.olivum.materials.protocol.RequestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class RootController {
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RequestResponse root() {
        System.out.println("RootController.root()");

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setMessage("home");
        requestResponse.setData("");
        requestResponse.setStatus(200);

        return requestResponse;
    }
}