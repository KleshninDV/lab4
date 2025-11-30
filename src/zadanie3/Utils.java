package zadanie3;

import java.util.*;
import java.util.stream.Collectors;

// Класс с утилитными методами для работы с обобщёнными списками
public final class Utils {
    // Приватный конструктор, чтобы нельзя было создавать экземпляры
    private Utils() {}

    // map: применяем функцию к каждому элементу списка и возвращаем новый список результатов
    public static <T, P> List<P> map(List<T> source, Apply<T, P> mapper) {
        List<P> result = new ArrayList<>(source.size()); // создаём список нужного размера
        for (T t : source) { // проходим по каждому элементу
            result.add(mapper.apply(t)); // применяем функцию к каждому элементу
        }
        return result;
    }

    // filter: оставляем только те элементы, которые проходят проверку predicate
    public static <T> List<T> filter(List<T> source, Test<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : source) {
            if (predicate.test(t)) result.add(t); // добавляем элемент, если условие верно
        }
        return result;
    }

    // reduce: сводим список к одному значению с помощью функции reducer
    public static <T> T reduce(List<T> source, T identity, Reducer<T> reducer) {
        T acc = identity; // начальное значение аккумулятора
        for (T t : source) {
            acc = reducer.apply(acc, t); // применяем функцию ко всем элементам
        }
        return acc; // возвращаем результат
    }

    // collect: собираем элементы списка в любую коллекцию через supplier и accumulator
    public static <T, C> C collect(List<T> source, SupplierCollection<C> supplier, Accumulator<C, T> accumulator) {
        C collection = supplier.get(); // создаём пустую коллекцию
        for (T t : source) {
            accumulator.accept(collection, t); // добавляем элементы
        }
        return collection; // возвращаем заполненную коллекцию
    }

    // toSet: простой пример коллекционирования в Set (уникальные элементы)
    public static <T> Set<T> toSet(List<T> list) {
        return collect(list, HashSet::new, Set::add); //HashSet хранит только уникальные элементы
    }
}
