package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.PurchaseOrderLineSong;
import com.bananaapps.bananamusic.service.music.ShoppingCartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartImpl service;

    @GetMapping("/balance")
    public ResponseEntity<Object> getBalance() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBalance());
    }

    @GetMapping("/item")
    public ResponseEntity<Object> getItemCount() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getItemCount());
    }

    @GetMapping("/buy")
    public ResponseEntity<Object> buy() {
        service.buy();
        return ResponseEntity.status(HttpStatus.OK).body("Compra realizada");
    }

    @GetMapping("/empty")
    public ResponseEntity<Object> empty() {
        service.empty();
        return ResponseEntity.status(HttpStatus.OK).body("Carrito vaciado");
    }

    @PostMapping("/item")
    public ResponseEntity<Object> addItem(@RequestBody PurchaseOrderLineSong item) {
        service.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Operacion exitosa: item añadido");
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Object> removeItem(@PathVariable Long id){
        service.removeItem(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Operacion exitosa: item eliminado");
    }
}
