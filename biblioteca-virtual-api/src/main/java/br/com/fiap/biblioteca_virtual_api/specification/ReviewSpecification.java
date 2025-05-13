package br.com.fiap.biblioteca_virtual_api.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.biblioteca_virtual_api.model.Review;
import br.com.fiap.biblioteca_virtual_api.model.ReviewFilter;
import jakarta.persistence.criteria.Predicate;

public class ReviewSpecification {
    
    public static Specification<Review> 
        withFilters(ReviewFilter filter) {
            return (root, query, cb) -> {
                
                //Predicato
                List<Predicate> predicates = new ArrayList<>();
                
                if (filter.drescription() != null) {
                    predicates.add(cb.like(
                        cb.lower(root.get("description")), "%" + 
                    filter.drescription().toLowerCase() + "%"));              
                }
                
                if (filter.startData() != null && filter.endDate() != null) {
                    predicates.add(
                        cb.between(root.get("date"), 
                        filter.startData(), 
                        filter.endDate() 
                        )
                    );
                }
                if (filter.startData() != null && filter.endDate() == null) {
                    predicates.add( 
                        cb.equal(root.get("date"), 
                        filter.startData())
                    );
                }

                    var arrayPredicates = predicates.toArray(new Predicate[0]);
                    return cb.and(arrayPredicates);

                };
            }
            
        }

