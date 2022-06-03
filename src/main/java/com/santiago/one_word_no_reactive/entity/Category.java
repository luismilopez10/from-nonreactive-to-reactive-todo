package com.santiago.one_word_no_reactive.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Category {

    @Id
    private String id;

    private String title;

    private String message;

    private List<ToDo> toDos;


}
