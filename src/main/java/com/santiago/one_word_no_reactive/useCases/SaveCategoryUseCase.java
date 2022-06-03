package com.santiago.one_word_no_reactive.useCases;

import com.santiago.one_word_no_reactive.entity.Category;
import com.santiago.one_word_no_reactive.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class SaveCategoryUseCase implements Function<Category, Mono<Category>> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Mono<Category> apply(Category categoryMono) {
        return categoryRepository.save(categoryMono);
    }
}
