package br.com.prothera.iniflex.utils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatador {
    private static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat formatoSalario;

    static {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        formatoSalario = new DecimalFormat("#,##0.00", simbolos);
    }

    public static String formatarData(LocalDate data) {
        return data.format(formatoData);
    }

    public static String formatarValor(BigDecimal valor) {
        return formatoSalario.format(valor);
    }
}