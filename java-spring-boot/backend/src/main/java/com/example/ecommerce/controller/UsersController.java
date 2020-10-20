package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.protocol.RequestResponse;
import com.example.ecommerce.protocol.RequestResponseList;
import com.example.ecommerce.repository.UsersRepository;
import com.example.ecommerce.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/rest/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RequestResponseList getUsersList() {
        System.out.println("getUsersList()");

        RequestResponseList requestResponseList = new RequestResponseList();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userAuthenticated = usersService.findUserByLogin(authentication.getName());

        if (userAuthenticated.getRole().compareTo("ROLE_ADMIN") != 0) {
            requestResponseList.setStatus(-1);
            requestResponseList.setMessage("access-denied");
        }
        else {
            requestResponseList.setData(usersService.getList());
        }

        return requestResponseList;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    public RequestResponse newUser(@RequestBody User user) {
        System.out.println("newUser()");

        System.out.println("user: " + user.getName());

        RequestResponse requestResponse = new RequestResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userAuthenticated = usersService.findUserByLogin(authentication.getName());

        if (userAuthenticated.getRole().compareTo("ROLE_ADMIN") != 0) {
            requestResponse.setStatus(-1);
            requestResponse.setMessage("access-denied");
        }
        else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            usersService.saveUser(user);

            requestResponse.setData(user);
        }

        return requestResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("updateUser()");

        System.out.println("user: " + user.getName());

        usersService.updateUser(user);

        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    public User getUserInfo(@PathVariable("id") long id) {
        System.out.println("getUserInfo()");

        User user = usersService.getItem(id);

        return user;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    public Boolean deleteUser(@RequestBody User user) {
        System.out.println("deleteUser()");

        return usersService.deleteItem(user.getId());
    }
}