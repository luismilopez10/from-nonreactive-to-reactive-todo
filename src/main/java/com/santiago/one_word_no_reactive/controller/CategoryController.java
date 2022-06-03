package com.santiago.one_word_no_reactive.controller;


import com.santiago.one_word_no_reactive.entity.Category;
import com.santiago.one_word_no_reactive.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Category> listOfCategories = categoryService.getAll();
        if(listOfCategories.size() > 0 ){
            return new ResponseEntity<List<Category>>(listOfCategories, HttpStatus.FOUND);

        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category){
        Category category1 = categoryService.save(category);
        if(category1 == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(category1, HttpStatus.CREATED);
    }
}
