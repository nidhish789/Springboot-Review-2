package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Specs;
import com.example.demo.repository.SpecsRepo;

@Service
public class SpecsService {
    private SpecsRepo specsRepo;
     public SpecsService(SpecsRepo specsRepo)
     {
        this.specsRepo=specsRepo;
     }
     public Specs saveSpecs(Specs specs)
     {
        return specsRepo.save(specs);
     }
     public Specs getById(int id)
     {
        return specsRepo.findById(id).orElse(null);
     }
     public List<Specs> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Specs> pg = specsRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
}
