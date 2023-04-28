import java.util.Arrays;
import java.util.List;

public class Computador implements IComputador {

    private Integer id;
    private String marca;
    private String modelo;
    private String processador;
    private String memoriaRAM;
    private String armazenamento;


    public Computador(int id) {
        this.id = id;
        Computador objeto = BD.getComputador(id);
        this.marca = objeto.marca;
        this.modelo = objeto.modelo;
        this.processador = objeto.processador;
        this.memoriaRAM = objeto.memoriaRAM;
        this.armazenamento = objeto.armazenamento;
    }

    public Computador(Integer id, String marca, String modelo, String processador, String memoriaRAM, String armazenamento) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.armazenamento = armazenamento;
    }

    public Integer getId() { return id; }

    @Override
    public List<String> obterDadosComputador() {
        return Arrays.asList(this.marca, this.modelo);
    }

    @Override
    public List<String> obterConfiguracao(Funcionario funcionario) {
        return Arrays.asList(this.marca, this.modelo, this.processador, this.memoriaRAM, this.armazenamento);
    }
}
