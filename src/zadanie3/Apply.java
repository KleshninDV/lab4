package zadanie3;

// Функциональный интерфейс для преобразования элемента типа T в элемент типа R
@FunctionalInterface
public interface Apply<T, R> {
    // Метод применяет преобразование к элементу t и возвращает результат типа R
    R apply(T t);
}
