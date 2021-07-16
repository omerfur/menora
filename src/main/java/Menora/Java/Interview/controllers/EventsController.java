package Menora.Java.Interview.controllers;

import Menora.Java.Interview.models.Product;
import Menora.Java.Interview.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/event/{insuredId}")
    public ResponseEntity<ArrayList<Product>>getEventByInsuredId(@PathVariable BigDecimal insuredId)
    {
        ResponseEntity<ArrayList<Product>> responseProduct;
        try {
            responseProduct = new ResponseEntity<ArrayList<Product>>(eventsService.getProductByInsurredId(insuredId),HttpStatus.OK);

        } catch (Exception e) {
            responseProduct = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(e);
        }
        return  responseProduct;
    }
}
