import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Path> dirPaths = new ArrayList<Path>(
                List.of(
                        Paths.get("/home/vagrant/git/ada-tech/teste/arquivos"),
                        Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/concluidos"),
                        Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/consolidado")));

        List<Tuple<Path, String>> filePathStringTupleList = new ArrayList<Tuple<Path, String>>(
                List.of(
                        new Tuple<Path, String>(
                                Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/textoIntroducao.txt"),
                                "Olá meu nome é: "),
                        new Tuple<Path, String>(
                                Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/textoNome.txt"), "Miguel!")));

        Path filePathToConsolidate = NIOUtils.incrementFileName(
                Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/consolidado/textoConsolidado.txt"));

        // create dirs and files
        dirPaths.forEach(dir -> NIOUtils.tryCreateDir(dir));
        filePathStringTupleList.forEach(tuple -> NIOUtils.tryCreateFile(tuple.getX()));

        // write to files
        filePathStringTupleList.forEach(tuple -> NIOUtils.tryWriteFile(tuple.getX(), tuple.getY()));

        // read from files
        StringBuilder sBuilder = new StringBuilder();
        filePathStringTupleList.forEach(tuple -> sBuilder.append(NIOUtils.tryReadFile(tuple.getX())));
        
        // write to consolidated file, if successful move origin files to concluidos
        NIOUtils.tryWriteConsolidatedFile(filePathToConsolidate, sBuilder.toString(), filePathStringTupleList);
        
    }

}

/// Exercicio (Fluxo de integração)
// 1. Acessar a pasta "arquivos"
// 1. Ler arquivo(s)
// 2. escrever arquivo consolidando todo o conteudo "arquivos/consolidado"
// 4. Mover o arquivo para outro diretorio "arquivos/concluidos"
// 5. Tratativa em caso de erro "arquivos/erro"