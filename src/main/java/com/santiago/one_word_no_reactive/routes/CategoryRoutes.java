package com.santiago.one_word_no_reactive.routes;


import com.santiago.one_word_no_reactive.entity.Category;
import com.santiago.one_word_no_reactive.useCases.GetAllUseCase;
import com.santiago.one_word_no_reactive.useCases.SaveCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CategoryRoutes {


    @Bean
    public RouterFunction<ServerResponse> getAll(GetAllUseCase getAllUse){
        return route(GET("/api/getAll"), request ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllUse.get(), Category.class)));
    }

    @Bean
    public RouterFunction<ServerResponse> saveCategory(SaveCategoryUseCase saveCategoryUseCase){
        return route(POST("/api/save"), request -> request.bodyToMono(Category.class)
                .flatMap(category -> saveCategoryUseCase.apply(category))
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
