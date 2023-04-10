import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
         * Atividade 1
         */
        System.out.println();

        ZonedDateTime tokyoZonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Tokyo"));
        // ZonedDateTime tokyoZonedDateTime =
        // ZonedDateTime.of(LocalDateTime.now(ZoneId.of("Asia/Tokyo")),
        // ZoneId.of("Asia/Tokyo"));

        System.out.println(tokyoZonedDateTime);
        System.out.println(tokyoZonedDateTime.withZoneSameInstant(ZoneId.of("Europe/London")));

        /*
         * Atividade 2
         */
        System.out.println();

        ZonedDateTime londonZonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/London"));

        long durationBetweenLondonTimeAndTokyoTime = ChronoUnit.HOURS.between(tokyoZonedDateTime, londonZonedDateTime);

        System.out.println("diferença em horas entre Londres e Tokyo " + durationBetweenLondonTimeAndTokyoTime);

        /*
         * Atividade 3 - todo
         */
        System.out.println();

        LocalDate dateNow = LocalDate.now();
        LocalDate dateNowMinusOneYear = dateNow.minusYears(1);

        long diasBetweenNowAndOneYearAgo = ChronoUnit.DAYS.between(dateNow, dateNowMinusOneYear);
        long diasUteisBetweenNowAndOneYearAgo = diasBetweenNowAndOneYearAgo;

        System.out.println(diasUteisBetweenNowAndOneYearAgo);

        /*
         * Atividade 4
         */
        System.out.println();

        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime timeFourAndHalfHoursFromNow = timeNow.plusHours(4).plusMinutes(30);

        long hoursBetweenNowAndOneYearAgo = ChronoUnit.HOURS.between(timeNow, timeFourAndHalfHoursFromNow);
        long minutesBetweenNowAndOneYearAgo = ChronoUnit.MINUTES.between(timeNow, timeFourAndHalfHoursFromNow);
        long secondsBetweenNowAndOneYearAgo = ChronoUnit.SECONDS.between(timeNow, timeFourAndHalfHoursFromNow);

        System.out.println(hoursBetweenNowAndOneYearAgo);
        System.out.println(minutesBetweenNowAndOneYearAgo);
        System.out.println(secondsBetweenNowAndOneYearAgo);

        /*
         * Atividade 5
         */
        System.out.println();

        LocalDateTime userDateTimeFrom = LocalDateTime.of(2020, Month.APRIL, 12, 11, 56, 23);
        LocalDateTime userDateTimeTo = LocalDateTime.of(2022, Month.AUGUST, 17, 5, 12, 33);
        List<ChronoUnit> listOfUnits = new ArrayList<ChronoUnit>(
                List.of(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS,
                        ChronoUnit.HOURS, ChronoUnit.MINUTES, ChronoUnit.SECONDS));

        timeBetween(userDateTimeFrom, userDateTimeTo, listOfUnits);

    }

    private static void timeBetween(LocalDateTime userDateTimeFrom, LocalDateTime userDateTimeTo, List<ChronoUnit> listOfUnits) {
        
        static LocalDateTime tempUserDateTimeFrom = LocalDateTime.from(userDateTimeFrom);

        listOfUnits.forEach(chronoUnit -> {
            long temp = tempUserDateTimeFrom.until(userDateTimeTo, chronoUnit);
            System.out.println(chronoUnit.name() + ": " + temp);
            tempUserDateTimeFrom = tempUserDateTimeFrom.plus(temp, chronoUnit);
        });
    }

}

/*
 * Exercicio 1: Converta um ZonedDateTime de "Asia/Tokyo" para "Europe/London".
 *
 * Exercicio 2: Calcule a diferença em horas entre dois ZonedDateTime em
 * diferentes timezones.
 * 
 * Exercício 3: Calcule a quantidade de dias úteis entre duas datas.
 * 
 * Exercício 4: Calcule a quantidade de horas, minutos e segundos entre dois
 * horarios.
 * 
 * Exercício 5: Escreva um código que calcule a diferença entre duas datas
 * fornecidas pelo usuário em dias, mês, ano, horas, minutos, segundos.
 */