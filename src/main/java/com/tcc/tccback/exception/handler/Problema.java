package com.tcc.tccback.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problema {
    private Integer status;
    private String tipo;
    private String titulo;
    private String descricao;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
        private String name;
        private String userMessage;
    }
}
