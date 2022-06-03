package com.santiago.one_word_no_reactive.useCases;

import com.santiago.one_word_no_reactive.entity.Category;
import com.santiago.one_word_no_reactive.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;


@Service
@RequiredArgsConstructor
public class GetAllUseCase implements Supplier<Flux<Category>> {

    private final CategoryRepository categoryRepository;


    @Override
    public Flux<Category> get() {
        return categoryRepository.findAll();
    }
}
