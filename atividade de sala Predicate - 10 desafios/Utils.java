import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Utils {
    static <T> Stream<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate);
    }

    static <T> List<Boolean> compareTwoLists(List<T> lista1, List<T> lista2,
            BiPredicate<T, T> biPredicate) throws IllegalArgumentException {

        List<Boolean> result = new ArrayList<Boolean>();
        Map<T, T> tempMap = combineListsIntoOrderedMap(lista1, lista2);

        tempMap.forEach((s1, s2) -> result.add(biPredicate.test(s1, s2)));

        return result;

    }

    static <T> Map<T, T> combineListsIntoOrderedMap(List<T> list1, List<T> list2) {

        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("Cannot combine lists with dissimilar sizes");
        }

        Map<T, T> map = new LinkedHashMap<T, T>();

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), list2.get(i));
        }

        return map;

    }
}
