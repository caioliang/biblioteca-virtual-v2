package br.com.fiap.biblioteca_virtual_api.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.biblioteca_virtual_api.model.Category;
import br.com.fiap.biblioteca_virtual_api.model.Review;
import br.com.fiap.biblioteca_virtual_api.model.ReviewType;
import br.com.fiap.biblioteca_virtual_api.model.User;
import br.com.fiap.biblioteca_virtual_api.model.UserRole;
import br.com.fiap.biblioteca_virtual_api.repository.CategoryRepository;
import br.com.fiap.biblioteca_virtual_api.repository.ReviewRepository;
import br.com.fiap.biblioteca_virtual_api.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @Autowired
    @PostConstruct
    public void init() {
        var categories = List.of(
                Category.builder().name("Harry Potter").icon("Bus").build(),
                Category.builder().name("Viagem ao centro da Terra").icon("Cherry").build(),
                Category.builder().name("Quarto de despejo").icon("Heart").build(),
                Category.builder().name("1976").icon("Dice").build());

        categoryRepository.saveAll(categories);

        var descriptions = List.of(
                "Um livro incrível!",
                "Uma leitura fascinante.",
                "Não consegui parar de ler.",
                "Uma história envolvente.",
                "Recomendo para todos os amantes de literatura.");

        var reviews = new ArrayList<Review>();
        for (int i = 0; i < 50; i++) {
            reviews.add(
                    Review.builder()
                            .description(descriptions.get(new Random().nextInt(descriptions.size())))
                            .note(BigDecimal.valueOf(10 + new Random().nextDouble() * 500))
                            .date(LocalDate.now().minusDays(new Random().nextInt(30)))
                            .type(new Random().nextBoolean() ? ReviewType.FISICO : ReviewType.DIGITAL)
                            .category(categories.get(new Random().nextInt(categories.size())))
                            .build());

            reviewRepository.saveAll(reviews);

        }
        userRepository.saveAll(List.of(
                User.builder()
                        .email("generico@gmail.com")
                        .password(passwordEncoder.encode("1234"))
                        .role(UserRole.ADMIN)
                        .build(),
                User.builder()
                        .email("generico2@gmail.com")
                        .password(passwordEncoder.encode("123456"))
                        .role(UserRole.USER)
                        .build()));
    }

}
