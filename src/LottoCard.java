import java.util.Arrays;
import java.util.Random;

public class LottoCard {
    // Массив для хранения чисел на карточке
    private int[] numbers = new int[5];
    // Массив для хранения информации о том, закрыто ли число
    private boolean[] covered = new boolean[5];

    // Конструктор, который генерирует карточку с числами
    public LottoCard() {
        generateCard();
    }

    // Метод для генерации случайных чисел для карточки
    private void generateCard() {
        Random rand = new Random();
        int[] tempNumbers = new int[100];
        // Заполняем временный массив числами от 1 до 100
        for (int i = 1; i <= 100; i++) {
            tempNumbers[i - 1] = i;
        }
        // Выбираем 5 случайных чисел и сортируем их
        for (int i = 0; i < 5; i++) {
            int randomIndex = rand.nextInt(100 - i);
            numbers[i] = tempNumbers[randomIndex];
            tempNumbers[randomIndex] = tempNumbers[100 - i - 1];
        }
        Arrays.sort(numbers);
    }

    // Метод для закрытия числа на карточке
    public boolean coverNumber(int number) {
        // Ищем число на карточке и, если находим, закрываем его
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number && !covered[i]) {
                covered[i] = true;
                return true;
            }
        }
        return false;
    }

    // Метод для подсчёта количества закрытых чисел
    public int getCoveredCount() {
        int count = 0;
        for (boolean b : covered) {
            if (b) count++;
        }
        return count;
    }

    // Метод для подсчёта количества оставшихся чисел, которые не закрыты
    public int getRemainingCount() {
        return 5 - getCoveredCount();
    }

    // Метод для проверки, полностью ли закрыта карточка
    public boolean isFullyCovered() {
        return getCoveredCount() == 5;
    }

    // Метод для вывода карточки на экран
    public void printCard() {
        for (int i = 0; i < numbers.length; i++) {
            // Если число закрыто, выводим "X", если нет, выводим само число
            System.out.print(covered[i] ? "X " : numbers[i] + " ");
        }
        System.out.println();
    }
}
