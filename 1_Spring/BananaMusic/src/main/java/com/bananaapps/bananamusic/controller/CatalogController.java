package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.service.music.CatalogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogImpl service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getSongById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> get(@RequestParam(required = false, defaultValue = "") String keyword) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByKeyword(keyword));
    }

    @GetMapping(value = "/size")
    public ResponseEntity<Object> size() {
        return ResponseEntity.status(HttpStatus.OK).body(service.size());
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createSong(@RequestBody Song newSong) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newSong));
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Object> save(@RequestBody Collection<Song> songs) {
        service.saveCollection(songs);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
