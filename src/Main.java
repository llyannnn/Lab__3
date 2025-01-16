public class Main {

    public static void main(String[] args) {

        // создаем карточки
        Card first = new Card(1,2,3,4,5);
        Card second = new Card(67,2,43,49,95);
        Card third = new Card(34,43,100,23,5);

        // смотрим закрытые и открытые числа
        System.out.println(first.countClosedNumbers());
        System.out.println(second.countClosedNumbers());
        System.out.println(third.countClosedNumbers());
        System.out.println(first.countOpenedNumbers());
        System.out.println(second.countOpenedNumbers());
        System.out.println(third.countOpenedNumbers());

        // закрываем числа
        System.out.println(first.coverNumber(1));
        System.out.println(first.coverNumber(43));
        System.out.println(second.coverNumber(67));
        System.out.println(second.coverNumber(95));
        System.out.println(third.coverNumber(1));
        System.out.println(third.coverNumber(2));

        // вывод карт
        System.out.println(first);
        System.out.println(third);

        System.out.println(Card.Loto(new Card[]{ second, first, third}, new int[]{1,2,3,4,5}));



    }
}





