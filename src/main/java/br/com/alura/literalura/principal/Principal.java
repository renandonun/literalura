package br.com.alura.literalura.principal;

import java.util.Scanner;

public class Principal {
    
    private Scanner leitura = new Scanner(System.in);

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
       
    }
    
    private void listarLivrosCadastrados() {
       
    }

    private void listarAutoresCadastrados() {
       
    }

    private void listarAutoresVivosEmDeterminadoAno() {
      
    }

    private void listarLivrosEmDeterminadoIdioma() {
       
    }
}
