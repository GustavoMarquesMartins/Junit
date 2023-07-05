import br.com.NexusSolutions.BonusService;
import br.com.NexusSolutions.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
//        Assert.assertThrows(IllegalArgumentException.class,
//                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
//                        new BigDecimal("25000"))));
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                    new BigDecimal("25000")));
            Assert.fail("nao deu exception");
        } catch (Exception erro) {
            Assert.assertEquals(" funcionarios com salario maior que R$1000 reais nao podem receber bonus",
                    erro.getMessage());
        }
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
