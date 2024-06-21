package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroGutendex(
        @JsonProperty("title") String titulo,
        @JsonAlias("authors") List<AutorGutendex> autor,
        @JsonAlias("languages") ArrayList<String> idioma) {

}