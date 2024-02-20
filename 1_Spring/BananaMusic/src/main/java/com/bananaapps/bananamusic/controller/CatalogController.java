package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.service.music.CatalogImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@RestController
@RequestMapping("/catalog")
@Validated
@Tag(name = "API de Catalog", description = "Endpoints para consumir catalog")
public class CatalogController {

    @Autowired
    private CatalogImpl service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getSongById(@PathVariable("id") @Min(1) Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Busca en el catalogo filtrando por keyword", description = "Devuelve todo el catalogo, pudidendo filtrar por keyword, en distintos formatos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuando hay catalogo a devolver."),
//            @ApiResponse(responseCode = "404", description = "Cuando no hay productos a devolver.")
    })
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
