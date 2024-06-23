package br.com.alura.literalura.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;
import br.com.alura.literalura.service.ResponseApi;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {

        var menu = """

                ********************************************
                Escolha o número de sua opção:
                1 - Buscar livro pelo título
                2 - Listar livros cadastrados
                3 - Listar autores cadastrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em um determinado idioma
                0 - Sair
                --------------------------------------------
                """;

        var opcao = -1;

        while (opcao != 0) {
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosCadastrados();
                    break;
                case 3:
                    listarAutoresCadastrados();
                    break;
                case 4:
                    listarAutoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosEmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Aplicação encerrada");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Qual livro deseja buscar? ");
        var busca = leitura.nextLine().replace(" ", "+").toLowerCase();
        var json = consumoApi.obterDados(busca);
        ResponseApi responseApi = conversor.obterDados(json, ResponseApi.class);

        Autor autor = new Autor(responseApi);
        Optional<Autor> autorExistente = autorRepository.findByAutor(autor.getAutor());
        Livro livro = new Livro(responseApi);
        if (autorExistente.isPresent()) {
            autor = autorExistente.get();
        } else {
            autorRepository.save(autor);
        }
        livro.setAutor(autor);
        livroRepository.save(livro);
        System.out.println(livro);
    }

    private void listarLivrosCadastrados() {
        var listarLivros = livroRepository.findAll();
        listarLivros.stream()
                .forEach(System.out::println);
    }

    private void listarAutoresCadastrados() {
        var listarAutores = autorRepository.findAll();
        listarAutores.stream()
                .forEach(System.out::println);
    }

    private void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("Consultar autores vivos em qual ano? ");
        var buscarAutoresPorAno = leitura.nextLine();
        List<Autor> autoresVivosNoAno = autorRepository.findAutoresVivosEmAno(buscarAutoresPorAno);
        autoresVivosNoAno.forEach(autor -> System.out.println(autor.getAutor()));
    }

    private void listarLivrosEmDeterminadoIdioma() {
        System.out.println("Qual idioma deseja filtrar? ");
        var buscaIdioma = leitura.nextLine();
        List<Livro> livrosFiltradosPorIdioma = livroRepository.findByIdioma(buscaIdioma);
        livrosFiltradosPorIdioma.forEach(livro -> System.out.println(livro.getTitulo()));

    }
}
