import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
public interface IGenericListForEach<T> {
    void forEach(Consumer<T> action, List<T> list);
}
