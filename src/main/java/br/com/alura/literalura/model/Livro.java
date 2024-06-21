package br.com.alura.literalura.model;

import java.util.List;

import br.com.alura.literalura.service.ResponseApi;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String anoNascimento;
    private String anoFalecimento;
    private List<String> idioma;

    public Livro(ResponseApi responseApi) {
        this.titulo = responseApi.results().get(0).titulo();
        this.autor = responseApi.results().get(0).autor().get(0).nome();
        this.anoNascimento = responseApi.results().get(0).autor().get(0).dataNascimento();
        this.anoFalecimento = responseApi.results().get(0).autor().get(0).dataFalecimento();
        this.idioma = responseApi.results().get(0).idioma();


    }

    @Override
    public String toString() {
        return 
        "Livro: " + titulo + 
        ", Autor = " + autor + 
        " (" + anoNascimento + 
        " - " + anoFalecimento + 
        "), " + idioma;
    }

    


}
