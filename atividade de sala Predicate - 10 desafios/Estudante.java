import java.util.Map;

public class Estudante extends Pessoa {

    private Map<String, Double> materiaNotaMap;

    public Estudante(String nome, int idade, EstadoCivil estadoCivil, Map<String, Double> materiaNotaMap) {
        super(nome, idade, estadoCivil);
        this.materiaNotaMap = materiaNotaMap;
    }

    public Map<String, Double> getMateriaNotaMap() {
        return materiaNotaMap;
    }

    public void setMateriaNotaMap(Map<String, Double> materiaNotaMap) {
        this.materiaNotaMap = materiaNotaMap;
    }

    public Double getMediaNotas() {
        return this.materiaNotaMap.values().stream().mapToDouble(d -> d).sum() / this.materiaNotaMap.size();
    }

    
    
    
}
