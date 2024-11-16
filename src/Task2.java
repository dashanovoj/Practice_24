/* Задание 2.
Реализовать класс Абстрактная фабрика для различных типов
стульев: Викторианский стул, Многофункциональный стул, Магический
стул, а также интерфейс Стул, от которого наследуются все классы стульев,
и класс Клиент, который использует интерфейс стул в своем методе Sit
(Chair chair). */

// Реализуем интерфейс, который объявляет методы для создания различных типов стульев
interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicChair();
    FunctionalChair createFunctionalChair();

}

// Опишем фабрику стульев, которая реализует интерфейс AbstractChairFactory
class ChairFactory implements AbstractChairFactory {

    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair(); // передаём в конструктор поле данных age
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}

// Реализуем интерфейс Chair
interface Chair {
    // Определим метод
    void sit();
}

// Класс VictorianChair, реализующий интерфейс Chair
class VictorianChair implements Chair {
    // Поля данных
    private int age;

    // Getter
    public int getAge() {
        return age;
    }

    // Переопределяем метод из интерфейса
    @Override
    public void sit() {
        System.out.println("Сидя на Викторианском стуле, вы чувствуете себя аристократом.");
    }
}

// Класс MagicChair, реализующий интерфейс Chair
class MagicChair implements Chair {

    // Реализуем метод для класса
    public void doMagic() {
        System.out.println("Магический стул творит чудеса!");
    }

    // Переопределяем метод из интерфейса
    @Override
    public void sit() {
        System.out.println("Сидя на Магическом стуле, вы чувствуете себя волшебником.");
    }
}

// Класс FunctionalChair, реализующий интерфейс Chair
class FunctionalChair implements Chair {

    // Реализуем метод для класса
    public int sum(int a, int b) {
        return a + b;
    }

    // Переопределяем метод из интерфейса
    @Override
    public void sit() {
        System.out.println("Сидя на Многофункциональном стуле, вы можете работать, отдыхать и играть.");
    }
}

// Класс клиента
class Client {
    // Поля данных
    public Chair chair; // переменная типа Chair

    // Конструктор
    public Client(Chair chair) {
        this.chair = chair;
    }

    // Определяем метод для взаимодействия с любым из стулов
    public void sit() {
        chair.sit();
    }
}

public class Task2 {
    
    public static void main(String[] args) {
        AbstractChairFactory chairFactory = new ChairFactory();
        Chair victorianChair = chairFactory.createVictorianChair();
        Client client = new Client(victorianChair);
        client.sit();

        Chair magicChair = chairFactory.createMagicChair();
        client = new Client(magicChair);
        client.sit();

        Chair functionalChair = chairFactory.createFunctionalChair();
        client = new Client(functionalChair);
        client.sit();
    }
}
