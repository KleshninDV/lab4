package zadanie1;

// Класс, представляющий человека
// Реализует интерфейс ComparableCustom для сравнения по возрасту
public final class Person implements ComparableCustom<Person> {
    // Имя человека
    private final String name;
    // Возраст человека
    private final int age;

    // Конструктор с проверкой на null для имени
    public Person(String name, int age) {
        if (name == null) throw new NullPointerException("name");
        this.name = name;
        this.age = age;
    }

    // Возвращает имя человека
    public String getName() {
        return name;
    }

    // Возвращает возраст человека
    public int getAge() {
        return age;
    }

    // Метод сравнения по возрасту
    // Возвращает отрицательное число, если this младше other
    // 0, если равны, положительное, если this старше other
    @Override
    public int сравнить(Person other) {
        return Integer.compare(this.age, other.age);
    }

    // Преобразует объект в строку вида "Имя (возраст)"
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
