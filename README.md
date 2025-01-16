## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

#### Выполнил: `Киблицкий Ян Денисович`

#### Вариант: `11`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Разработать программу для упрощённой версии игры «Лото». Реализовать функционал создания карточек с наборами чисел, отслеживания прогресса игры, обработки
выпадающих чисел и определения победителя..

- 1 подзадача:
Создание карточки с числами от 1 до 100. Карточка может быть задана массивом чисел или набором аргументов фиксированного размера (например, 5 чисел).

- 2 подзадача:
Функция возвращает количество закрытых чисел и количество оставшихся открытыми чисел на карточке.

- 3 подзадача:
Закрытие числа на карточке. Проверка, есть ли указанное число на карточке. Если число найдено, оно закрывается (заменяется на «X» или -1).

- 4 подзадача:
Проверка закрытия всей карточки
Функция определяет, закрыты ли все числа на карточке. Если все числа закрыты,
карточка считается полностью закрытой.

- 5 подзадача:
Определение выигрыша по массиву чисел.
На вход подаётся массив чисел или число n, за которым следует n чисел. Функция
определяет, какое из этих чисел позволяет игроку закрыть всю карточку. Если ни
одно из чисел не закрывает карточку полностью, возвращается -1.

- 6 подзадача:
Определение победителя среди нескольких игроков
Для нескольких игроков (карточек) функция возвращает, кто из них первым закроет карточку, и общее количество игроков, которые смогут закрыть свои карточки.

### 2. Описание класса и методов 

#### Данные на вход

#### Класс Card

1. private HashSet<Integer> closedNumbers:

   • Тип: HashSet<Integer>

   • Описание: Это множество, которое хранит закрытые числа на карточке. Использование HashSet позволяет эффективно добавлять и проверять наличие чисел.

2. private int[] originalNumbers:

   • Тип: int[]

   • Описание: Это массив, который хранит оригинальные числа на карточке. В конструкторе класса задаются пять чисел, которые будут представлять лотерейные числа игрока.

▎Методы класса:

1. public Card(int a, int b, int c, int d, int e):

   • Конструктор, который инициализирует массив originalNumbers с пятью переданными числами и создает пустое множество closedNumbers.

2. public int countClosedNumbers():

   • Метод, который возвращает количество закрытых чисел на карточке, используя размер множества closedNumbers.

3. public boolean closeNumber(int number):

   • Метод, который принимает число и проверяет, есть ли оно в массиве originalNumbers. Если число найдено, оно добавляется в множество closedNumbers, и метод возвращает true. Если число не найдено, метод возвращает false.

4. public boolean isCardFullClosed():

   • Метод, который проверяет, закрыты ли все числа на карточке (т.е. количество закрытых чисел равно 5). Возвращает true, если все числа закрыты, иначе — false.

5. @Override public String toString():

   • Метод, который переопределяет стандартный метод toString() и возвращает строковое представление состояния карточки. Закрытые числа отображаются как "X", а открытые — как сами числа.

6. public static String lottoWinner(Card[] cards, int[] numbers):

   • Статический метод, который принимает массив карточек и массив чисел (выигрышных). Он проверяет каждую карточку на наличие закрытых чисел и определяет, есть ли победитель среди игроков. Возвращает строку с информацией о победителе или сообщение о том, что победителей нет.



#### Класс Test

▎Описание класса:

Класс Test используется для проверки и демонстрации работы методов класса Card. Он позволяет убедиться в корректности реализации логики игры, а также в правильности работы методов, таких как closeNumber, countClosedNumbers, countOpenedNumbers, winNumber и toString.

▎Методы класса:

1. public static void main(String[] args):

   • Основной метод, который выполняет тестирование функциональности класса Card.

   • В этом методе происходит создание нескольких объектов карточек и тестирование их методов.

▎Логика тестирования:

1. Создание карточек:

   • Создаются четыре карточки с различными числами, причем одна из них идентична другой (первая и четвертая).

2. Подсчет закрытых чисел:

   • Вызывается метод countClosedNumbers() для каждой карточки, чтобы проверить, сколько чисел закрыто (в начале все числа открыты, поэтому ожидается 0).

3. Подсчет открытых чисел:

   • Вызывается метод countOpenedNumbers() для каждой карточки, чтобы проверить количество открытых чисел (в начале все числа открыты, поэтому ожидается 5).

4. Закрытие некоторых чисел:

   • Пробуются различные числа для закрытия с помощью метода closeNumber(int number), и результаты выводятся на экран.

5. Вывод состояния карточек:

   • После закрытия некоторых чисел выводится текущее состояние карточек.

6. Тестирование метода winNumber:

   • Проверяется, какие числа позволяют закрыть всю карточку. Результаты выводятся на экран.

7. Тестирование метода toString:

   • Вызывается метод toString() для получения строкового представления состояния карточек и выводится на экран.

8. Определение победителя:

   • Вызывается метод lottoWinner для определения победителя среди карточек и выводится результат.



