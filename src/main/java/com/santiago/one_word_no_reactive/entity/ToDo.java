package com.santiago.one_word_no_reactive.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ToDo {

    private String id = UUID.randomUUID().toString();
    private String toDo;
}
