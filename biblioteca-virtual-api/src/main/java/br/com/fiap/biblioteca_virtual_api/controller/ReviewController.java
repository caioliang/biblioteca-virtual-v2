package br.com.fiap.biblioteca_virtual_api.controller;

import java.math.BigDecimal;
 import java.time.LocalDate;
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Example;
 import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
 
 import br.com.fiap.biblioteca_virtual_api.model.Review;
import br.com.fiap.biblioteca_virtual_api.model.ReviewFilter;
import br.com.fiap.biblioteca_virtual_api.repository.ReviewRepository;
import br.com.fiap.biblioteca_virtual_api.specification.ReviewSpecification;
import lombok.extern.slf4j.Slf4j;
 
 @RestController
 @RequestMapping("/reviews")
 @Slf4j
 public class ReviewController {
 
     @Autowired
     private ReviewRepository repository;
 
     @GetMapping
     public Page<Review> index(ReviewFilter filter, 
         @PageableDefault(size = 10, sort = "date", direction =  Direction.DESC) 
         Pageable pageable) {
             return repository.findAll(ReviewSpecification.withFilters(filter), pageable);
         }

    //  public List<Review> index(ReviewFilter filter){
    //      log.info("Buscando reviews com descrição {} e data {}", filter.description, filter.date);
    //      var probe = Review.builder()
    //                      .description(filter.description)
    //                      .date(filter.date())
    //                      .note(filter.note())
    //                      .build();
 
    //      var matcher = ExampleMatcher.matchingAll()
    //                      .withIgnoreCase()
    //                      .withIgnoreNullValues()
    //                      .withStringMatcher(StringMatcher.CONTAINING);
 
    //     var example = Example.of(probe, matcher);
 
    //     return repository.findAll(example);
 
    }
