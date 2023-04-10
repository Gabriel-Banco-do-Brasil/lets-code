public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private int idade;

    public Pessoa(final String nome, final int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "O meu nome é " + this.nome + " e tenho " + this.idade + " anos!";
    }

    @Override
    public int compareTo(Pessoa pessoa) {

        for (int i = 0; i < this.nome.length() && i < pessoa.getNome().length(); i++){
            if ((int)this.nome.toCharArray()[i] < (int)pessoa.getNome().toCharArray()[i]){
                return -1;
            }
            if ((int)this.nome.toCharArray()[i] > (int)pessoa.getNome().toCharArray()[i]){
                return 1;
            }
        }

        return 0;

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

}
