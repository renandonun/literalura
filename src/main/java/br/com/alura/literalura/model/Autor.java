package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.literalura.service.ResponseApi;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String autor;
    private String anoNascimento;
    private String anoFalecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(ResponseApi responseApi) {
        this.autor = responseApi.results().get(0).autor().get(0).nome();
        this.anoNascimento = responseApi.results().get(0).autor().get(0).dataNascimento();
        this.anoFalecimento = responseApi.results().get(0).autor().get(0).dataFalecimento();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        livros.forEach(a -> a.setAutor(this));
        this.livros = livros;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(String anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    @Override
    public String toString() {
        return "\nAutor: " + autor + "\nAno de nascimento: " + anoNascimento + "\nAno de falecimento: " + anoFalecimento
                + "\nLivros: " + livros.stream().map(l -> l.getTitulo()).collect(Collectors.toList());
    }

    
    
}
