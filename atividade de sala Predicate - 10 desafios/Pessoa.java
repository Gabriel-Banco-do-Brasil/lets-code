public class Pessoa {
    private String nome;
    private int idade;
    private EstadoCivil estadoCivil;
    
    public Pessoa(String nome, int idade, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.idade = idade;
        this.estadoCivil = estadoCivil;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
