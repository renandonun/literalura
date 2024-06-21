package br.com.alura.literalura.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.alura.literalura.model.LivroGutendex;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseApi(
    @JsonAlias("results") List<LivroGutendex> results) {
    
}
