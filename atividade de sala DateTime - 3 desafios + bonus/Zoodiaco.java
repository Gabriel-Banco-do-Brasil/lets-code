import java.time.MonthDay;

public enum Zoodiaco {
    AQUARIO(MonthDay.of(1, 21), MonthDay.of(2, 19)),
    PEIXES(MonthDay.of(2, 19), MonthDay.of(3, 20)),
    ARIES(MonthDay.of(3, 21), MonthDay.of(4, 20)),
    TOURO(MonthDay.of(4, 21), MonthDay.of(5, 20)),
    GEMEOS(MonthDay.of(5, 21), MonthDay.of(6, 20)),
    CANCER(MonthDay.of(6, 21), MonthDay.of(7, 22)),
    LEAO(MonthDay.of(7, 23), MonthDay.of(8, 22)),
    VIRGEM(MonthDay.of(8, 23), MonthDay.of(9, 22)),
    LIBRA(MonthDay.of(9, 23), MonthDay.of(10, 22)),
    ESCORPIAO(MonthDay.of(10, 23), MonthDay.of(11, 21)),
    SAGITARIO(MonthDay.of(11, 22), MonthDay.of(12, 21)),
    CAPRICORNIO(MonthDay.of(12, 22), MonthDay.of(1, 20));

    private final MonthDay dataInicio;
    private final MonthDay dataFim;

    Zoodiaco(MonthDay dataInicio, MonthDay dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public static Zoodiaco matchMonthDayToZoodiaco(MonthDay monthDay) {

        for (Zoodiaco zoodiaco : Zoodiaco.values()) {
            if (isBetween(monthDay, zoodiaco.dataInicio, zoodiaco.dataFim)) {
                return zoodiaco;
            }
        }

        return null;

    }

    private static boolean isBetween(MonthDay current, MonthDay from, MonthDay until) {
        if (from.compareTo(until) <= 0) {
            return from.compareTo(current) <= 0 && current.compareTo(until) <= 0;
        } else {
            return current.compareTo(until) <= 0 || current.compareTo(from) >= 0;
        }
    }

}

/*
 * Áries: 21 de março a 20 de abril
 * Touro: 21 de abril a 20 de maio
 * Gêmeos: 21 de maio a 20 de junho
 * Câncer: 21 de junho a 22 de julho
 * Leão: 23 de julho a 22 de agosto
 * Virgem: 23 de agosto a 22 de setembro
 * Libra: 23 de setembro a 22 de outubro
 * Escorpião: 23 de outubro a 21 de novembro
 * Sagitário: 22 de novembro a 21 de dezembro
 * Capricórnio: 22 de dezembro a 20 de janeiro
 * Aquário: 21 de janeiro a 19 de fevereiro
 * Peixes: 19 de fevereiro a 20 de março
 */