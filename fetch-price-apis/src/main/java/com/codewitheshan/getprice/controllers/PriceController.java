package com.codewitheshan.getprice.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codewitheshan.getprice.payloads.ApiResponse;
import com.codewitheshan.getprice.services.PriceScraperService;

@EnableWebMvc
@RestController
@RequestMapping("/api")
public class PriceController {
	@Autowired
    private PriceScraperService priceScraperService;

    @GetMapping("/price")
    public ResponseEntity<ApiResponse> getPrice() {
        try {
            String price = priceScraperService.scrape();
    		ApiResponse apiResponse = new ApiResponse(price, "success");
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (IOException e) {
        	String message = "Server is currently under maintenance";
    		ApiResponse apiResponse = new ApiResponse("NULL" ,message);
    		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
}
