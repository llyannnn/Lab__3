public class LottoTest {
    public static void main(String[] args) {
        // Создаём игру с 2 игроками
        LottoGame game = new LottoGame(2);

        // Тест генерации карточки
        testCardGeneration(game);

        // Тест покрытия чисел
        testCoverNumber(game);

        // Тест полного покрытия карточки
        testFullCardCoverage(game);

        // Тест общего хода игры
        testGameFlow(game);
    }

    public static void testCardGeneration(LottoGame game) {
        // Проверяем, что на карточке каждого игрока 5 чисел
        System.out.println("Тест: Генерация карточки");
        for (int i = 0; i < game.getPlayers().size(); i++) {
            LottoPlayer player = game.getPlayers().get(i);
            int remaining = player.getCard().getRemainingCount();
            if (remaining == 5) {
                System.out.println("Игрок " + (i + 1) + ": Правильное количество чисел на карточке: " + remaining);
            } else {
                System.out.println("Игрок " + (i + 1) + ": Ошибка! Ожидалось 5 чисел, но их " + remaining);
            }
        }
    }

    public static void testCoverNumber(LottoGame game) {
        // Проверяем, что игроки могут закрывать числа на карточке
        System.out.println("\nТест: Покрытие числа");
        LottoPlayer player1 = game.getPlayers().get(0);
        if (player1.coverNumber(1)) {
            System.out.println("Игрок 1 успешно закрыл число 1");
        } else {
            System.out.println("Игрок 1 не смог закрыть число 1");
        }
    }

    public static void testFullCardCoverage(LottoGame game) {
        // Проверяем, что карточка становится полностью закрытой, когда все числа закрыты
        System.out.println("\nТест: Полное покрытие карточки");
        LottoPlayer player1 = game.getPlayers().get(0);
        player1.coverNumber(1);
        player1.coverNumber(2);
        player1.coverNumber(3);
        player1.coverNumber(4);
        player1.coverNumber(5);
        if (player1.hasWon()) {
            System.out.println("Игрок 1 победил! Все числа закрыты.");
        } else {
            System.out.println("Игрок 1 не победил.");
        }
    }

    public static void testGameFlow(LottoGame game) {
        // Моделируем ход игры и проверяем, кто победит
        System.out.println("\nТест: Ход игры");
        LottoPlayer player1 = game.getPlayers().get(0);
        LottoPlayer player2 = game.getPlayers().get(1);

        // В начале игры оба игрока не должны победить
        if (!player1.hasWon() && !player2.hasWon()) {
            System.out.println("Игра началась. Нет победителя.");
        }

        // Игроки начинают закрывать числа
        player1.coverNumber(1);
        player2.coverNumber(2);
        System.out.println("Игрок 1 закрыл число 1.");
        System.out.println("Игрок 2 закрыл число 2.");

        // Проверяем состояние карточек после первого хода
        System.out.println("\nКарточка Игрока 1:");
        player1.getCard().printCard();
        System.out.println("Карточка Игрока 2:");
        player2.getCard().printCard();

        // Закрываем все числа у Игрока 1
        player1.coverNumber(3);
        player1.coverNumber(4);
        player1.coverNumber(5);

        // Проверяем, что Игрок 1 победил
        if (player1.hasWon()) {
            System.out.println("Игрок 1 победил! Все числа закрыты.");
        } else {
            System.out.println("Игрок 1 не победил.");
        }

        // Проверяем, что Игрок 2 не победил
        if (!player2.hasWon()) {
            System.out.println("Игрок 2 не победил.");
        }
    }
}
