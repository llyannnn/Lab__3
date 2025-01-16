public class Main {

    public static void main(String[] args) {

        // Создаем карточки с различными числами
        Card first = new Card(1, 2, 3, 4, 5);
        Card second = new Card(67, 2, 43, 49, 95);
        Card third = new Card(34, 43, 100, 23, 5);
        Card fourth = new Card(1, 2, 3, 4, 5); // Четвертая карточка, идентичная первой

        // Смотрим количество закрытых чисел на каждой карточке
        System.out.println("Закрытые числа:");
        System.out.println(first.countClosedNumbers()); // 0
        System.out.println(second.countClosedNumbers()); // 0
        System.out.println(third.countClosedNumbers()); // 0

        // Смотрим количество открытых чисел на каждой карточке
        System.out.println("\nОткрытые числа:");
        System.out.println(first.countOpenedNumbers()); // 5
        System.out.println(second.countOpenedNumbers()); // 5
        System.out.println(third.countOpenedNumbers()); // 5

        // Закрываем некоторые числа и проверяем результат
        System.out.println("\nЗакрытие числа:");
        System.out.println(first.closeNumber(1)); // true (число закрыто)
        System.out.println(first.closeNumber(43)); // false (число не закрыто)
        System.out.println(second.closeNumber(67)); // true (число закрыто)
        System.out.println(second.closeNumber(95)); // true (число закрыто)
        System.out.println(third.closeNumber(1)); // false (число не закрыто)
        System.out.println(third.closeNumber(2)); // false (число не закрыто)

        // Выводим состояние карт после закрытия некоторых чисел
        System.out.println("\nСостояние карточек:");
        System.out.println(first); // X 2 3 4 5
        System.out.println(third); // 34 43 100 23 5

        // Тестирование метода winNumber для определения победителя
        System.out.println("\nКакое из этих чисел позволяет игроку закрыть всю карточку:");
        int[] numbersToClose = {1, 2, 3, 4, 5}; // Числа для закрытия
        int resultFirst = first.winNumber(numbersToClose); // Проверка первой карточки на выигрыш
        int resultSecond = second.winNumber(numbersToClose); // Проверка второй карточки на выигрыш

        // Выводим результаты проверки на выигрыш
        System.out.println("\nПервая карточка: " + resultFirst); // true (если все числа закрыты)
        System.out.println("Вторая карточка: " + resultSecond); // false (если не все числа закрыты)

        // Тестирование метода toString для отображения состояния карточек
        System.out.println("\nВывод карточек:");
        String firstCardString = first.toString(); // Получаем строковое представление первой карточки
        String thirdCardString = third.toString(); // Получаем строковое представление третьей карточки

        // Выводим результаты вызова toString()
        System.out.println("\nПервая карточки: " + firstCardString); // X 2 3 4 5
        System.out.println("Третьей карточки: " + thirdCardString); // 34 43 100 23 5

        // Определяем победителя среди карточек
        System.out.println("\nПобедитель лотереи:");
        System.out.println(Card.lottoWinner(new Card[]{second, first, third, fourth}, new int[]{1,2,3,4,5})); // Выводим победителя
    }
}