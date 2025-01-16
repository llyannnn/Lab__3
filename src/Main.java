//public class Main {
//
//    public static void main(String[] args) {
//
//        // создаем карточки
//        Card first = new Card(1,2,3,4,5);
//        Card second = new Card(67,2,43,49,95);
//        Card third = new Card(34,43,100,23,5);
//        Card fourth = new Card(1,2,3,4,5);
//
//        // смотрим закрытые и открытые числа
//        System.out.println(first.countClosedNumbers());
//        System.out.println(second.countClosedNumbers());
//        System.out.println(third.countClosedNumbers());
//        System.out.println(first.countOpenedNumbers());
//        System.out.println(second.countOpenedNumbers());
//        System.out.println(third.countOpenedNumbers());
//
//        // закрываем числа
//        System.out.println(first.closeNumber(1));
//        System.out.println(first.closeNumber(43));
//        System.out.println(second.closeNumber(67));
//        System.out.println(second.closeNumber(95));
//        System.out.println(third.closeNumber(1));
//        System.out.println(third.closeNumber(2));
//
//        // вывод карт
//        System.out.println(first);
//        System.out.println(third);
//
//        System.out.println(Card.lottoWinner(new Card[]{ second, first, third}, new int[]{1,2,3,4,5}));
//    }
//}
//
//
//
//
//
public class Main {

    public static void main(String[] args) {

        // Создаем карточки с различными числами
        Card first = new Card(1, 2, 3, 4, 5);
        Card second = new Card(67, 2, 43, 49, 95);
        Card third = new Card(34, 43, 100, 23, 5);
        Card fourth = new Card(1, 2, 3, 4, 5); // Четвертая карточка, идентичная первой

        // Смотрим количество закрытых чисел на каждой карточке
        System.out.println("Закрытые числа:");
        System.out.println(first.countClosedNumbers()); // Ожидается: 0
        System.out.println(second.countClosedNumbers()); // Ожидается: 0
        System.out.println(third.countClosedNumbers()); // Ожидается: 0

        // Смотрим количество открытых чисел на каждой карточке
        System.out.println("Открытые числа:");
        System.out.println(first.countOpenedNumbers()); // Ожидается: 5
        System.out.println(second.countOpenedNumbers()); // Ожидается: 5
        System.out.println(third.countOpenedNumbers()); // Ожидается: 5

        // Закрываем некоторые числа и проверяем результат
        System.out.println("Закрытие числа:");
        System.out.println(first.closeNumber(1)); // true (число закрыто)
        System.out.println(first.closeNumber(43)); // false (число не закрыто)
        System.out.println(second.closeNumber(67)); // true (число закрыто)
        System.out.println(second.closeNumber(95)); // true (число закрыто)
        System.out.println(third.closeNumber(1)); // false (число не закрыто)
        System.out.println(third.closeNumber(2)); // false (число не закрыто)

        // Выводим состояние карт после закрытия некоторых чисел
        System.out.println("Состояние карточек:");
        System.out.println(first); // Ожидается: X 2 3 4 5
        System.out.println(third); // Ожидается: 34 43 100 23 5

        // Тестирование метода winNumber для определения победителя
        System.out.println("Тестирование метода winNumber:");
        int[] numbersToClose = {1, 2, 3, 4, 5}; // Числа для закрытия
        int resultFirst = first.winNumber(numbersToClose); // Проверка первой карточки на выигрыш
        int resultSecond = second.winNumber(numbersToClose); // Проверка второй карточки на выигрыш

        // Выводим результаты проверки на выигрыш
        System.out.println("Первая карточка выиграла: " + resultFirst); // true (если все числа закрыты)
        System.out.println("Вторая карточка выиграла: " + resultSecond); // false (если не все числа закрыты)

        // Тестирование метода toString для отображения состояния карточек
        System.out.println("Тестирование метода toString:");
        String firstCardString = first.toString(); // Получаем строковое представление первой карточки
        String thirdCardString = third.toString(); // Получаем строковое представление третьей карточки

        // Выводим результаты вызова toString()
        System.out.println("Строковое представление первой карточки: " + firstCardString); // Ожидается: X 2 3 4 5
        System.out.println("Строковое представление третьей карточки: " + thirdCardString); // Ожидается: 34 43 100 23 5

        // Определяем победителя среди карточек
        System.out.println("Победитель лотереи:");
        System.out.println(Card.lottoWinner(new Card[]{second, first, third}, numbersToClose)); // Выводим победителя
    }
}