package br.com.fiap.biblioteca_virtual_api.model;

import java.math.BigDecimal;
 import java.time.LocalDate;
 
 import jakarta.persistence.Entity;
 import jakarta.persistence.EnumType;
 import jakarta.persistence.Enumerated;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;
 import jakarta.persistence.ManyToOne;
 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.NotNull;
 import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
 import lombok.Builder;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Entity
 @Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor
 public class Review {
     
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
 
     @NotBlank(message = "campo obrigatório")
     private String description;
 
     @PositiveOrZero(message = "deve ver positivo")
     private BigDecimal note;
 
     @PastOrPresent(message = "não pode ser no futuro")
     private LocalDate date;
 
     @NotNull
     @ManyToOne
     private Category category;
 
     @NotNull
     @Enumerated(EnumType.STRING)
     private ReviewType type;
 
 }