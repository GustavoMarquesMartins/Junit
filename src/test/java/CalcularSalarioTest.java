import br.com.NexusSolutions.CalcularSalario;
import br.com.NexusSolutions.Desempenho;
import br.com.NexusSolutions.Funcionario;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalcularSalarioTest {

    private CalcularSalario calcularSalario;
    private Funcionario funcionario;

    @BeforeAll
    public static void inicioAntesDeTodos() {
        System.out.println("Inicio antes de todos");
    }

    @AfterAll
    public static void finalAntesDeTodos() {
        System.out.println("Final antes de todos");
    }

    @BeforeEach
    public void finalAntesDeCadaUm() {
        System.out.println("inicio antes de cada um !!!!!");
        this.funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal("1000.00"));
        this.calcularSalario = new CalcularSalario();
    }

    @AfterEach
    public void inicioAntesDeCadaUm() {
        System.out.println("final antes de cada um !!!!!");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        calcularSalario.calcularSalario(this.funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForOtimo() {
        calcularSalario.calcularSalario(this.funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        calcularSalario.calcularSalario(this.funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
