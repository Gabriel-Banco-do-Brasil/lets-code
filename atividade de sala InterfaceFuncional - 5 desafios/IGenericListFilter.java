import java.util.List;

@FunctionalInterface
public interface IGenericListFilter<T> {
    List<T> filter(List<T> list);
}
