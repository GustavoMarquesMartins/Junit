import br.com.NexusSolutions.Agendamento.BonusService;
import br.com.NexusSolutions.Agendamento.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BigDecimal resultado = BonusService.calcularBonus(
                new Funcionario("Rodrigo", LocalDate.now(),
                        new BigDecimal("25000")));
        Assert.assertEquals(new BigDecimal("0.00"), resultado);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        Assert.assertEquals(new BigDecimal("1000.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerVintePorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        Assert.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
