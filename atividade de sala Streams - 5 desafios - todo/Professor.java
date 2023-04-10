import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    private List<Estudante> estudanteList = new ArrayList<Estudante>();
    private String materiaEnsinada;
    private Double avaliacao;

    public Professor(String name, Integer age, List<Estudante> estudanteList, String materia) {
        super(name, age);
        this.estudanteList = estudanteList;
        this.materiaEnsinada = materia;
        atualizaAvaliacao();
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    public void atualizaAvaliacao() {
        this.avaliacao = this.estudanteList.stream()
                .filter(estudante -> estudante.getMateriaNotaMap().containsKey(this.materiaEnsinada))
                .mapToDouble(estudante -> estudante.getMateriaNotaMap().get(this.materiaEnsinada))
                .average()
                .orElse(0.0);
    }

}
