package com.scould.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String getMsg() {
        return "this is MSG";
    }
}
