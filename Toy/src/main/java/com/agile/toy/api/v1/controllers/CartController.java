package com.agile.toy.api.v1.controllers;

import com.agile.toy.api.v1.domains.ToyInCart;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import com.agile.toy.api.v1.services.CartService;
import com.agile.toy.api.v1.services.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    private CartService cartService;
    private CheckOutService checkOutService;

    @Autowired
    public CartController(CartService cartService,CheckOutService checkOutService) {

        this.cartService = cartService;
        this.checkOutService = checkOutService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addToCart")
    @ResponseStatus(HttpStatus.OK)
    public CartEntitiesDTO addToCart(@RequestBody CartEntitiesDTO cartEntitiesDTO){

        return cartService.addToCart(cartEntitiesDTO);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ToyInCartDTO> getToyIncart(@PathVariable Long id){
        return cartService.getCartDetails(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/checkout")
    @ResponseStatus(HttpStatus.OK)
    public List<ToyInCartDTO> checkOut(){
        List<ToyInCartDTO> toyInCarts = cartService.getCartDetails(1L);
        checkOutService.clearCart();

        return toyInCarts;

    }

}
