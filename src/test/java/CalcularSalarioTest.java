import br.com.NexusSolutions.Agendamento.CalcularSalario;
import br.com.NexusSolutions.Agendamento.Desempenho;
import br.com.NexusSolutions.Agendamento.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalcularSalarioTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal("1000.00"));
        CalcularSalario calcularSalario = new CalcularSalario();
        calcularSalario.calcularSalario(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForOtimo() {
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal("1000"));
        CalcularSalario calcularSalario = new CalcularSalario();
        calcularSalario.calcularSalario(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal("1000"));
        CalcularSalario calcularSalario = new CalcularSalario();
        calcularSalario.calcularSalario(funcionario, Desempenho.OTIMO);
        Assert.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
