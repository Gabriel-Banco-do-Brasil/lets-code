import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/*
            Utilizando as classes LocalDate, LocalTime e LocalDateTime
            Exercicio1: A partir da List 'datas' exiba na tela apenas a data mais recente e mais antiga (somente data, somente hora e dataHora);
            Exercicio2: Printe o dia da semana de seu aniversario dos proximos 10 anos;
            Exercicio3: A partir da List 'datas' retorne uma lista dos dias de semana que as datas cairão
            Bonus: Receba a data de nascimento e identifique o signo correspondente (https://astrologialuzesombra.com.br/datas-dos-signos-do-zodiaco/)
*/

public class Main {

    final static DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    final static DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final static DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    final static DateTimeFormatter formatterDayMonth = DateTimeFormatter.ofPattern("dd/MM");

    public static void main(String[] args) {

        List<String> datas = Arrays.asList(
                "01/02/2023",
                "05/08/2030",
                "07/04/2024 08:56:00",
                "09/03/2008",
                "18/09/2015",
                "24/06/2042 09:23:00",
                "29/07/2018",
                "30/02/2020",
                "24/06/2042 18:50:00",
                "16/02/2002");

        List<LocalDateTime> localDateTimeList = new ArrayList<LocalDateTime>();

        datas.forEach(data -> {

            try {

                localDateTimeList.add(LocalDateTime.parse(data, formatterDateTime));

            } catch (Exception e1) {

                try {

                    localDateTimeList.add(LocalDate.parse(data, formatterDate).atStartOfDay());

                } catch (Exception e2) {

                    throw new DateTimeException(
                            "Deu erro");
                }

            }

        });

        /*
         * Atividade 1
         */
        System.out.println();

        localDateTimeList.sort(Comparator.comparing(Function.identity()));

        System.out.println("DataTime mais recente da lista: "
                + localDateTimeList.get(0).format(formatterDate) + " "
                + localDateTimeList.get(0).format(formatterTime) + " "
                + localDateTimeList.get(0));

        System.out.println("DataTime mais antiga da lista: "
                + localDateTimeList.get(localDateTimeList.size() - 1).format(formatterDate) + " "
                + localDateTimeList.get(localDateTimeList.size() - 1).format(formatterTime) + " "
                + localDateTimeList.get(localDateTimeList.size() - 1));

        /*
         * Atividade 2
         */
        System.out.println();

        for (int i = 0; i < 10; i++) {
            LocalDate proximoAniversario = LocalDate.of(2023, 4, 15).plusYears(i);
            System.out.println("Dia da semana do aniversário de "
                    + proximoAniversario.getYear() + ": "
                    + proximoAniversario.getDayOfWeek());
        }

        /*
         * Atividade 3
         */
        System.out.println();

        localDateTimeList.forEach(date -> System.out.println("Dia da semana do dia "
                + date.toLocalDate() + ": "
                + date.getDayOfWeek()));

        /*
         * Atividade Bonus
         */
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String diaMesNascimento = scanner.nextLine();

        try {

            System.out.println("Escreva o dia e o mês do seu nascimento no formato 'dd/mm'");
            MonthDay parsedMonthDay = MonthDay.parse(diaMesNascimento, formatterDayMonth);
            System.out.println("Você é do signo : "
                    + Zoodiaco.matchMonthDayToZoodiaco(parsedMonthDay));

        } catch (Exception e) {
            throw new DateTimeException("Formato de data invalida ou valores invalidos");

        } finally {
            scanner.close();
        }

    }

}
