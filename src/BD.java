import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Computador> computadores = new HashMap<>();

    public static Computador getComputador(Integer id) {
        return computadores.get(id);
    }

    public static void addComputador(Computador computador) {
        computadores.put(computador.getId(), computador);
    }
}
