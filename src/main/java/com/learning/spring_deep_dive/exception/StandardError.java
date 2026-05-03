package com.learning.spring_deep_dive.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/*
 * PASSO 1: Criar o DTO de erro padrão.
 * O QUE VOCÊ DEVE FAZER:
 * - Este arquivo define a estrutura do JSON que o seu front-end vai receber quando der erro.
 * - Você pode adicionar ou remover campos aqui conforme a necessidade do seu projeto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
