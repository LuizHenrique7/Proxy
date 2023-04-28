import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComputadorProxyTest {

    @BeforeEach
    void setUp() {
        BD.addComputador(new Computador(1, "Dell", "Inspiron 15", "Intel Core i5", "8 GB", "500 GB"));
        BD.addComputador(new Computador(2, "HP", "Pavilion x360", "AMD Ryzen 5", "16 GB", "1 TB"));
    }

    @Test
    void deveRetornarDadosComputador() {
        ComputadorProxy computador = new ComputadorProxy(1);

        assertEquals(Arrays.asList("Dell", "Inspiron 15"), computador.obterDadosComputador());
    }

    @Test
    void deveRetonarConfiguracoes() {
        Funcionario funcionario = new Funcionario("Paulo", true);
        ComputadorProxy computador = new ComputadorProxy(2);

        assertEquals(Arrays.asList("HP", "Pavilion x360", "AMD Ryzen 5", "16 GB", "1 TB"), computador.obterConfiguracao(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarConfiguracoes() {
        try {
            Funcionario funcionario = new Funcionario("Eduardo", false);
            ComputadorProxy computador = new ComputadorProxy(2);

            computador.obterConfiguracao(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}