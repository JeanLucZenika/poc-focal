package com.coveo.globalauroradatabase.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping()
    public Boolean alive() {
        return true;
    }

}
