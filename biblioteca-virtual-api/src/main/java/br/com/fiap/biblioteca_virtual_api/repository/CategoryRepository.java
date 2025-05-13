package br.com.fiap.biblioteca_virtual_api.repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.biblioteca_virtual_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
