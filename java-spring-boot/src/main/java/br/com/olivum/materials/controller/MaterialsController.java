package br.com.olivum.materials.controller;

import br.com.olivum.materials.protocol.RequestResponse;
import br.com.olivum.materials.protocol.RequestResponseList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.olivum.materials.model.Material;
import br.com.olivum.materials.service.MaterialsService;

@Controller
@RequestMapping(value = "/api/material")
public class MaterialsController {
    @Autowired
    MaterialsService materialsService;

    @ApiOperation(value = "Get materials list")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RequestResponseList getMaterialsList() {
        System.out.println("getMaterialsList()");

        RequestResponseList requestResponseList = new RequestResponseList();

        requestResponseList.setStatus(0);
        requestResponseList.setData(materialsService.getList());

        return requestResponseList;
    }

    @ApiOperation(value = "Register new material")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public RequestResponse newMaterial(@RequestBody Material material) {
        System.out.println("newMaterial()");

        System.out.println("material: " + material.getName());

        materialsService.saveMaterial(material);

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setData(material);

        return requestResponse;
    }

    @ApiOperation(value = "Update material information")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Material updateMaterial(@PathVariable("id") long id, @RequestBody Material material) {
        System.out.println("updateMaterial()");

        System.out.println("material: " + material.getName());

        //material.setId(id);

        materialsService.updateMaterial(material);

        return material;
    }

    @ApiOperation(value = "Get material information")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Material getMaterialInfo(@PathVariable("id") long id) {
        System.out.println("getMaterialInfo()");

        Material material = materialsService.getItem(id);

        return material;
    }

    @ApiOperation(value = "Delete material information")
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean deleteMaterial(@RequestBody Material material) {
        System.out.println("deleteMaterial()");

        return materialsService.deleteItem(material.getId());
    }
}