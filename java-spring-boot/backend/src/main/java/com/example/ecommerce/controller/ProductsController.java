package com.example.ecommerce.controller;

import com.example.ecommerce.protocol.RequestResponse;
import com.example.ecommerce.protocol.RequestResponseList;
import com.example.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ecommerce.model.Product;

@Controller
@RequestMapping(value = "/rest/product")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RequestResponseList getProductsList() {
        System.out.println("getProductsList()");

        RequestResponseList requestResponseList = new RequestResponseList();

        requestResponseList.setData(productsService.getList());

        return requestResponseList;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public RequestResponse newProduct(@RequestBody Product product) {
        System.out.println("newProduct()");

        System.out.println("product: " + product.getName());

        productsService.saveProduct(product);

        RequestResponse requestResponse = new RequestResponse();

        requestResponse.setData(product);

        return requestResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("updateProduct()");

        System.out.println("product: " + product.getName());

        productsService.updateProduct(product);

        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getProductInfo(@PathVariable("id") long id) {
        System.out.println("getProductInfo()");

        Product product = productsService.getItem(id);

        return product;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Boolean deleteProduct(@RequestBody Product product) {
        System.out.println("deleteProduct()");

        return productsService.deleteItem(product.getId());
    }
}