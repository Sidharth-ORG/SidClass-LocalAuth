package com.learn.SidClasses.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class TestControleer {

    @GetMapping
    @PreAuthorize("hasRole('Guest')") //this gives the authorization to guest only
    public String test(){
        return "sid testing";
    }

}
