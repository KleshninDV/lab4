package zadanie3;

// Функциональный интерфейс для создания новой коллекции типа C
@FunctionalInterface
public interface SupplierCollection<C> {
    // Метод возвращает новый экземпляр коллекции
    C get();
}
