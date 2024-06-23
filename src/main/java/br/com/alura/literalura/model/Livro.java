package br.com.alura.literalura.model;

import br.com.alura.literalura.service.ResponseApi;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    // private List<String> idioma;
    private String idioma;
    private Integer totalDownloads;
    @ManyToOne
    private Autor autor;

    public Livro() {}

    public Livro(ResponseApi responseApi) {
        this.titulo = responseApi.results().get(0).titulo();
        this.idioma = responseApi.results().get(0).idioma().get(0);
        this.totalDownloads = responseApi.results().get(0).totalDownloads();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(Integer totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    @Override
    public String toString() {
        return 
        "\n------ Livro ------\nTítulo: " + titulo + 
        "\nAutor: " + autor.getAutor() + 
        "\nIdioma: " + idioma +
        "\nTotal de downloads: " + totalDownloads;
    }
}
