package zadanie3;

// Функциональный интерфейс для проверки условия на элемент типа T
@FunctionalInterface
public interface Test<T> {
    // Метод возвращает true, если элемент t удовлетворяет условию, иначе false
    boolean test(T t);
}
