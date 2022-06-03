package com.santiago.one_word_no_reactive.repository;

import com.santiago.one_word_no_reactive.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
