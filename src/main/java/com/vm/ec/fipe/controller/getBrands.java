package com.vm.ec.fipe.controller;

import com.vm.ec.fipe.service.FipeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class getBrands {
private final FipeService fipeService;

public getBrands(FipeService fipeService) {
    this.fipeService = fipeService;
}

@GetMapping("/api/getBrands")
public String getBrands() {
        return fipeService.fetchAllMakes();
}
}
