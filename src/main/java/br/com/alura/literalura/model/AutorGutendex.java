package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorGutendex(
    @JsonAlias("name") String nome,
    @JsonAlias("birth_year") String dataNascimento,
    @JsonAlias("death_year") String dataFalecimento) {
    
}
