import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    final static Predicate<String> atividade2Predicate1 = string -> string.startsWith("C");
    final static Predicate<String> atividade2Predicate2 = string -> string.length() > 5;
    final static Predicate<Pessoa> atividade3Predicate = pessoa -> pessoa.getAge() > 30;
    final static Predicate<Integer> atividade4Predicate = integer -> integer.intValue() > 10;
    final static Predicate<Professor> atividade5Predicate = professor -> professor.getAvaliacao() > 80;

    public static void main(String[] args) {

        // atividade 1
        System.out.println();

        Integer[] integerArray = { 1, 2, 3, 4, 5 };

        Integer integerArraySum = Arrays.stream(integerArray).mapToInt(n -> n).sum();

        System.out.println(
                "A soma do array de integers é: " + integerArraySum);

        // ------------------------------------------------------------------------------------------------------------

        // atividade 2
        System.out.println();

        List<String> stringList = new ArrayList<>(
                List.of("hi", "character", "Classification", "car", "list", "count"));

        long filteredStringListCount = stringList.stream()
                .filter(atividade2Predicate1.and(atividade2Predicate2))
                .count();

        System.out.println(
                "A query da atividade 2 sobre a lista de nomes retornou "
                        + filteredStringListCount
                        + " resultado(s)");

        // ------------------------------------------------------------------------------------------------------------

        // atividade 3
        System.out.println();

        List<Pessoa> pessoaList = new ArrayList<Pessoa>(
                List.of(
                        new Pessoa("Gabriel", 22),
                        new Pessoa("Miguel", 26),
                        new Pessoa("Rafael", 54),
                        new Pessoa("Daniel", 72)));

        List<String> filteredPessoaListGetNames = pessoaList.stream()
                .filter(atividade3Predicate)
                .map(pessoa -> pessoa.getName())
                .collect(Collectors.toList());

        System.out.println(
                "A query da atividade 3 sobre a lista de pessoas retornou os nomes: " + filteredPessoaListGetNames);

        // ------------------------------------------------------------------------------------------------------------

        // atividade 4
        System.out.println();

        List<Integer> integerList = new ArrayList<>(
                List.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89));

        Double filteredIntegerListAverage = integerList.stream()
                .filter(atividade4Predicate)
                .mapToInt(n -> n)
                .average()
                .orElse(0.0);

        System.out.println("A média dos números maiores que 10 da lista é: " + filteredIntegerListAverage);

        // ------------------------------------------------------------------------------------------------------------

        // atividade 5
        System.out.println();

        List<Estudante> estudanteList1 = List.of(
                new Estudante("Carlos", 17,
                        Map.of(
                                "Introdução à Programação", 90.5,
                                "Física para Computação", 70.0)),
                new Estudante("Rafael", 76,
                        Map.of(
                                "Introdução à Programação", 90.4,
                                "Física para Computação", 70.5)),
                new Estudante("Carla", 86,
                        Map.of(
                                "Introdução à Programação", 100.0,
                                "Física para Computação", 86.0)),
                new Estudante("Julia", 34,
                        Map.of(
                                "Introdução à Programação", 55.7,
                                "Física para Computação", 70.0)));

        List<Estudante> estudanteList2 = List.of(
                new Estudante("Francisco", 17,
                        Map.of(
                                "Introdução à Programação", 50.5,
                                "Física para Computação", 40.0)),
                new Estudante("Eliza", 36,
                        Map.of(
                                "Introdução à Programação", 30.4,
                                "Física para Computação", 20.5)),
                new Estudante("Jose", 26,
                        Map.of(
                                "Introdução à Programação", 70.0,
                                "Física para Computação", 76.0)),
                new Estudante("Geraldo", 44,
                        Map.of(
                                "Introdução à Programação", 65.7,
                                "Física para Computação", 50.0)));

        List<Professor> professorList = new ArrayList<>(
                List.of(
                        new Professor("Luis", 26, estudanteList1, "Introdução à Programação"),
                        new Professor("Gilberto", 30, estudanteList2, "Física para Computação")));

        professorList.stream()
                .filter(atividade5Predicate)
                .forEach(professor -> professor.getEstudanteList());

        // ------------------------------------------------------------------------------------------------------------

    }

}

// 1. Dado um array de inteiros, retorne a soma de todos os números pares

// 2. Dado uma lista de strings, selecione apenas as palavras que começam com
// 'C' e retorne a quantidade de elementos que possuem mais de 5 caracteres.

// 3. Dado uma lista de Pessoas, retorne uma lista de nomes dos que possuem mais
// de 30 anos.

// 4. Dado uma lista de números inteiros, retorne a média dos números maiores
// que 10.

// 5. Dado uma lista de Professores, identifique os que possuem avaliação
// superior a 80 e retorne uma lista com nome de seus estudantes, por ordem
// alfabetica e sem repetição.