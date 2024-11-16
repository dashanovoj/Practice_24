/* Задание 1.
Разработать программную реализацию по UML диаграмме,
представленной на рис.24.1с использованием изучаемых паттернов. */

public class Task1 {

    // Реализуем интерфейс
    interface ComplexAbstractFactory {
        // Реализуем методы класса Complex
        Complex createComplex(); // возвращает объект типа Complex, параметры не принимает
        Complex CreateComplex(int real, int image); // возвращает объект типа Complex, параметры принимает (действительную и мнимую части числа)
    }

    // Создаём класс, реализующий интерфейс
    class ConcreteFactory implements ComplexAbstractFactory {
        // Реализуем методы интерфейса
        @Override
        public Complex createComplex() {
            // Возвращает новый экземпляр класса Complex, инициализированный значениями по умолчанию (0, 0)
            return new Complex();
        }

        @Override
        public Complex CreateComplex(int real, int image) {
            // Возвращает новый экземпляр класса Complex, инициализированный с переданными значениями
            return new Complex(real, image);
        }
    }

    // Реализуем сам класс Complex
    class Complex {
        // Поля данных
        private int real; // действительная часть
        private int image; // мнимая часть

        // Конструктор без параметров, который инициализирует real и image значениями 0.
        public Complex() {
            this.real = 0;
            this.image = 0;
        }

        // Конструктор с параметрами, которые передаём при создании объекта
        public Complex(int real, int image) {
            this.real = real;
            this.image = image;
        }

        // Getter'ы и Setter'ы
        public int getReal() {
            return real;
        }

        public void setReal(int real) {
            this.real = real;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }
}