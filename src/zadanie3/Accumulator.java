package zadanie3;

// Функциональный интерфейс для добавления элемента T в коллекцию C
@FunctionalInterface
public interface Accumulator<C, T> {
    // Метод добавляет элемент element в коллекцию collection
    void accept(C collection, T element);
}
