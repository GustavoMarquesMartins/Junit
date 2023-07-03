package br.com.NexusSolutions.Agendamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularSalario {

    public void calcularSalario(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal resultado = desempenho.percentualReajuste();
        resultado = funcionario.getSalario().multiply(resultado);
        funcionario.reajustarSalario(resultado.setScale(2,RoundingMode.HALF_UP));
    }
}
