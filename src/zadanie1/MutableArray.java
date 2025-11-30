package zadanie1;

import java.util.Arrays;
import java.util.Objects;

public final class MutableArray<T> {
    // Внутренний массив для хранения элементов
    private Object[] data;
    // Текущее количество элементов в массиве
    private int size;

    // Конструктор по умолчанию с начальной ёмкостью 10
    public MutableArray() {
        this(10);
    }

    // Конструктор с указанием начальной ёмкости
    public MutableArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException();
        data = new Object[initialCapacity];
        size = 0;
    }

    // Конструктор с массивом начальных значений
    public MutableArray(T[] initialValues) {
        Objects.requireNonNull(initialValues);
        data = Arrays.copyOf(initialValues, initialValues.length, Object[].class);
        size = initialValues.length;
    }

    // Добавляет новый элемент в массив, расширяя при необходимости
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    // Возвращает элемент по индексу с проверкой границ
    public T get(int index) {
        rangeCheck(index);
        return (T) data[index];
    }

    // Заменяет элемент в массиве по указанному индексу с проверкой границ
    public void set(int index, T value) {
        rangeCheck(index);
        data[index] = value;
    }

    // Возвращает текущее количество элементов в массиве
    public int size() {
        return size;
    }

    // Преобразует внутренний массив в массив типа T
    public T[] toArray(Class<T> clazz) {
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        for (int i = 0; i < size; i++) arr[i] = (T) data[i];
        return arr;
    }

    // Преобразует массив в строку вида [элемент1, элемент2, ...]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Проверяет, хватает ли места в массиве, и расширяет при необходимости
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length)
            data = Arrays.copyOf(data, Math.max(minCapacity, data.length * 2));
    }

    // Проверяет, что индекс находится в пределах массива
    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }
}
