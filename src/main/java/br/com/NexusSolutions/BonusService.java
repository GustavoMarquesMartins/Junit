package br.com.NexusSolutions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public static BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        int resultado = valor.compareTo(new BigDecimal("1000"));

        if (resultado > 0) {
            throw new IllegalArgumentException(" funcionarios com salario maior que R$1000 reais nao podem receber bonus");
        }

        return valor.setScale(2, RoundingMode.HALF_UP);
    }

}