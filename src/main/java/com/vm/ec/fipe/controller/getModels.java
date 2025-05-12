package com.vm.ec.fipe.controller;

import com.vm.ec.fipe.service.FipeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class getModels {
    private final FipeService fipeService;

    public getModels(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/api/getModels")
    public String getModels() {
        return fipeService.fetchAllModels();
    }
}
