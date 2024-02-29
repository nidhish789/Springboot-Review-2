package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Specs;
import com.example.demo.service.SpecsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
public class SpecsController {
    private SpecsService specsService;
    public SpecsController (SpecsService specsService)
    {
        this.specsService=specsService;

    }
    @PostMapping("/post/specs")
    public Specs postMethodName(@RequestBody Specs specs) {
        return specsService.saveSpecs(specs);
    }
    @GetMapping("/get/specs/{id}")
    public Specs getMethodName(@PathVariable("id") int id) {
        return specsService.getById(id);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/api/Specs/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Specs>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Specs> ch = specsService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ch, HttpStatus.OK);
    }
}
