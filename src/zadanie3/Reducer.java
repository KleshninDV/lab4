package zadanie3;

// Функциональный интерфейс для свёртки (редуцирования) двух элементов типа T в один
@FunctionalInterface
public interface Reducer<T> {
    // Метод применяет операцию к двум элементам и возвращает результат
    T apply(T a, T b);
}
