package com.bananaapps.bananamusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongsController {

    @GetMapping
    public String hola(){
        return "song controller";
    }
}
