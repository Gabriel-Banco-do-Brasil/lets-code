import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

        private static Consumer<Pessoa> pessoaPrintNome = pessoa -> System.out.println(pessoa.getNome());
        private static Predicate<Pessoa> pessoaIdadeMaiorQue50 = pessoa -> pessoa.getIdade() > 50;
        private static Predicate<Pessoa> pessoaIdadeMaiorQue18 = pessoa -> pessoa.getIdade() > 18;
        private static Predicate<Pessoa> pessoaIsSolteira = pessoa -> pessoa.getEstadoCivil() == EstadoCivil.SOLTEIRO;
        private static Predicate<Pessoa> pessoaIsCasada = pessoa -> pessoa.getEstadoCivil() == EstadoCivil.CASADO;
        private static Predicate<Estudante> estudanteMediaNotasMaiorQue85 = estudante -> estudante
                        .getMediaNotas() > 85.0;
        private static BiPredicate<String, String> isEqual = (string1, string2) -> string1.equals(string2);

        public static void main(String[] args) {

                List<Estudante> estudantes = List.of(
                                new Estudante("Carlos", 17, EstadoCivil.SOLTEIRO,
                                                Map.of(
                                                                "Introdução à Programação", 90.5,
                                                                "Física para Computação", 70.0,
                                                                "Algebra Vetorial Linear", 35.7)),
                                new Estudante("Rafael", 76, EstadoCivil.CASADO,
                                                Map.of(
                                                                "Introdução à Programação", 90.4,
                                                                "Física para Computação", 70.5,
                                                                "Algebra Vetorial Linear", 62.8)),
                                new Estudante("Carla", 86, EstadoCivil.SOLTEIRO,
                                                Map.of(
                                                                "Introdução à Programação", 100.0,
                                                                "Física para Computação", 86.0,
                                                                "Algebra Vetorial Linear", 81.5)),
                                new Estudante("Julia", 34, EstadoCivil.CASADO,
                                                Map.of(
                                                                "Introdução à Programação", 55.7,
                                                                "Física para Computação", 70.0,
                                                                "Algebra Vetorial Linear", 62.5)));

                // exercicio 1
                System.out.println();

                System.out.println("Pessoas com idade maior que 50 e solteiras: ");
                Utils.filterList(List.copyOf(estudantes), pessoaIdadeMaiorQue50.and(pessoaIsSolteira))
                                .forEach(pessoaPrintNome);

                // exercicio 2s
                System.out.println();

                System.out.println("Pessoas com idade maior que 50 e casadas: ");
                Utils.filterList(List.copyOf(estudantes), pessoaIdadeMaiorQue50.and(pessoaIsCasada))
                                .forEach(pessoaPrintNome);

                // exercicio 3
                System.out.println();

                System.out.println("Estudantes com idade maior que 18 e com média de notas maior que 85: ");
                Utils.filterList(estudantes, estudanteMediaNotasMaiorQue85.and(pessoaIdadeMaiorQue18))
                                .forEach(pessoaPrintNome);

                // exercicio 4
                System.out.println();

                List<String> lista1 = List.of("Oi", "Hi", "Hallo", "Hola", "Hello");
                List<String> lista2 = List.of("Oi", "Hey", "Hallo", "Hola", "Hellou");

                Utils.compareTwoLists(lista1, lista2, isEqual).forEach(result -> System.out.print(result + " "));

                // exercicio 5
                System.out.println();

                // exercicio 6
                // System.out.println();

                // exercicio 7
                // System.out.println();

                // exercicio 8
                // System.out.println();

                // exercicio 9
                // System.out.println();

                // exercicio 10
                // System.out.println();

        }

}

// exercicio 1:
// Escreva um método que aceite uma lista de pessoas e use Predicates para
// verificar se há pelo menos uma pessoa com idade acima de 50 anos e que seja
// solteira.

// exercicio 2:
// Escreva um método que aceite uma lista de pessoas e use Predicates para
// verificar se há pelo menos uma pessoa com idade acima de 50 anos e que seja
// casada.

// Exercício 3:
// Escreva um método que aceite uma lista de estudantes e use Predicates para
// verificar se há pelo menos um estudante com idade acima de 18 anos e que
// tenha uma média de notas acima de 85.

// Exercicio 4:
// Escreva um método que aceite duas listas de strings e use um BiPredicate para
// verificar se a primeira string da primeira lista é igual à primeira string da
// segunda lista, a segunda string da primeira lista é igual à segunda string da
// segunda lista, e assim por diante.

// Exercicio 5:
// Escreva um método que aceite uma lista de objetos de funcionários e use uma
// Function para extrair o nome de cada funcionário e retornar uma lista de
// strings.

// Exercicio 6:
// Escreva um método que aceite uma lista de estudantes e use uma Function para
// extrair a média de notas de cada estudante e retornar uma lista de números
// inteiros.

// Exercicio 7:
// Escreva um método que aceite uma lista de estudantes e use um Consumer para
// calcular a média de notas de todos os estudantes, e depois imprimir o
// resultado na tela.

// Exercicio 8:
// Escreva um método que aceite uma lista de números inteiros e use um Consumer
// para aplicar uma operação matemática (raiz quadrada ou cálculo do quadrado)
// em cada elemento da lista, e depois imprimir o resultado na tela.

// Exercicio 9:
// Escreva um método que use um Supplier para gerar uma lista de números
// inteiros aleatórios. Imprima a lista na tela.

// Exercicio 10:
// Escreva um método que aceite uma lista de objetos de funcionários e use um
// UnaryOperator para aumentar o salário de cada funcionário em 10%