package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.service.music.CatalogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogImpl service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }


    @GetMapping(value = "")
    public ResponseEntity<Object> get(@RequestParam(required = false, defaultValue = "") String keyword) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByKeyword(keyword));
    }

}
