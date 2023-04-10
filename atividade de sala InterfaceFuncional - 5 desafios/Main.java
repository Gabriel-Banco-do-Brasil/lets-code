import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {

                // atividade 1
                System.out.println();

                Calculator calculadora = new Calculator();
                calculadora.setFirstValue(4.5);
                calculadora.setSecondValue(5.5);
                calculadora.testCalculatorOperations();

                // atividade 2
                System.out.println();

                List<String> stringList = new ArrayList<>(
                                List.of(
                                                "five",
                                                "seven",
                                                "eleven"));

                IGenericListFilter<String> filterFiveCharsOrMore = list -> list.stream().filter(t -> t.length() > 5)
                                .collect(Collectors.toList());

                System.out.println("Strings with more than 5 characters: " + filterFiveCharsOrMore.filter(stringList));

                // atividade 3 e 4
                System.out.println();

                List<Integer> integerList = new ArrayList<>(
                                List.of(
                                                1,
                                                2,
                                                3,
                                                4,
                                                5,
                                                6,
                                                7,
                                                8,
                                                9));

                IGenericListFilter<Integer> filterEven = list -> list.stream().filter(t -> t % 2 == 0)
                                .collect(Collectors.toList());
                IGenericListFilter<Integer> filterOdd = list -> list.stream().filter(t -> t % 2 != 0)
                                .collect(Collectors.toList());

                System.out.println("Sum of even Integers is: "
                                + filterEven.filter(integerList).stream().mapToInt(Integer::intValue).sum());
                System.out.println("Sum of odd Integers is: "
                                + filterOdd.filter(integerList).stream().mapToInt(Integer::intValue).sum());

                // atividade 5
                System.out.println();

                List<String> nameList = new ArrayList<>(
                                List.of(
                                                "Miguel",
                                                "Gabriel",
                                                "Rafael"));

                IGenericListForEach<String> forEachName = (action, list) -> {
                        for (String string : list) {
                                action.accept(string);
                        }
                };

                forEachName.forEach(t -> System.out.println(t), nameList);

                System.out.println();

        }
}

// exercicio 1:
// Reimplemente a calculadora utilizando interface funcional.

// exercicio 2:
// Crie uma função em Java que filtre uma lista de strings e retorne apenas
// aquelas que tenham mais de 5 caracteres usando programação funcional.

// Exercício 3:
// Crie uma função em Java que retorne a soma dos números pares de uma lista de
// números inteiros usando programação funcional.

// Exercício 4:
// Crie uma função em Java que retorne a soma dos números impares de uma lista
// de números inteiros usando programação funcional.

// exercicio 5:
// Crie uma implementação de foreach usando a interface Consumer