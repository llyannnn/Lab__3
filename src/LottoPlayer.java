public class LottoPlayer {
    // Переменная для хранения карточки игрока
    private LottoCard card;

    // Конструктор, который создаёт новую карточку игрока
    public LottoPlayer() {
        this.card = new LottoCard();
    }

    // Метод для получения карточки игрока
    public LottoCard getCard() {
        return card;
    }

    // Метод для попытки закрыть число на карточке
    public boolean coverNumber(int number) {
        return card.coverNumber(number);
    }

    // Метод для проверки, выиграл ли игрок
    public boolean hasWon() {
        return card.isFullyCovered();
    }

    // Метод для вывода карточки игрока на экран
    public void printCard() {
        card.printCard();
    }
}
