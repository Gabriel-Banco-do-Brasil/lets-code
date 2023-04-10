import java.util.Map;

public class Estudante extends Pessoa {

    private Map<String, Double> materiaNotaMap;

    public Estudante(String nome, int idade, Map<String, Double> materiaNotaMap) {
        super(nome, idade);
        this.materiaNotaMap = materiaNotaMap;
    }

    public Map<String, Double> getMateriaNotaMap() {
        return materiaNotaMap;
    }

    public void setMateriaNotaMap(Map<String, Double> materiaNotaMap) {
        this.materiaNotaMap = materiaNotaMap;
    }

}
