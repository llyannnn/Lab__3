import java.util.ArrayList;
import java.util.Random;

public class LottoGame {
    // Список игроков в игре
    private ArrayList<LottoPlayer> players;
    // Объект для генерации случайных чисел
    private Random random;
    // Список уже вытянутых чисел
    private ArrayList<Integer> drawnNumbers;

    // Конструктор, который инициализирует игру с заданным количеством игроков
    public LottoGame(int numPlayers) {
        players = new ArrayList<>();
        random = new Random();
        drawnNumbers = new ArrayList<>();
        // Создаём игроков
        for (int i = 0; i < numPlayers; i++) {
            players.add(new LottoPlayer());
        }
    }

    // Метод для запуска игры
    public void startGame() {
        while (true) {
            // Рандомно выбираем число от 1 до 100
            int number = random.nextInt(100) + 1;
            // Если это число ещё не вытягивали
            if (!drawnNumbers.contains(number)) {
                drawnNumbers.add(number);
                System.out.println("Выпавшее число: " + number);
                // Все игроки пытаются закрыть это число на своей карточке
                for (LottoPlayer player : players) {
                    if (player.coverNumber(number)) {
                        System.out.println("Игрок закрыл число " + number);
                    }
                }

                // Проверяем, есть ли победитель
                for (LottoPlayer player : players) {
                    if (player.hasWon()) {
                        System.out.println("У нас есть победитель!");
                        player.printCard();
                        return;
                    }
                }
            }
        }
    }
}
