import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIOUtils {

    public static Path incrementFileName(Path p1) {

        String p1toString = p1.toString();
        String extension = "";
        String name = "";

        int indexOfDot = p1toString.lastIndexOf('.'); // Get the last index of . to separate extension
        extension = p1toString.substring(indexOfDot + 1);
        name = p1toString.substring(0, indexOfDot);

        int counter = 1;

        while (Files.exists(p1)) {
            p1toString = name + "(" + counter + ")." + extension;
            p1 = Paths.get(p1toString);
            counter++;
        }

        return p1;
    }

    public static void tryCreateDir(Path p1) {
        try {
            Files.createDirectories(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryCreateFile(Path p1) {
        try {
            Files.createFile(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String tryReadFile(Path p1) {
        try {
            return Files.readString(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void tryWriteFile(Path p1, String msg) {
        try {
            Files.writeString(p1, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryMoveFileToConcluidosDir(Path p1) {
        try {
            Files.move(p1, incrementFileName(
                    Paths.get("/home/vagrant/git/ada-tech/teste/arquivos/concluidos/" + p1.getFileName())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryWriteConsolidatedFile(Path p1, String msg, List<Tuple<Path, String>> originPaths) {
        try {
            Files.writeString(p1, msg);
            originPaths.forEach(path -> tryMoveFileToConcluidosDir(path.getX()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
