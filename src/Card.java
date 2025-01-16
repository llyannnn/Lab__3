import java.util.Scanner;

public class Card{
    Scanner in = new Scanner(System.in);
    private int[] massive;
    private int[] massive_2;
    public Card(int a, int b, int c,int d,int e){
        this.massive = new int[5];
        this.massive[0] = a;
        this.massive[1] = b;
        this.massive[2] = c;
        this.massive[3] = d;
        this.massive[4] = e;

        this.massive_2 = new int[5];
        this.massive_2[0] = a;
        this.massive_2[1] = b;
        this.massive_2[2] = c;
        this.massive_2[3] = d;
        this.massive_2[4] = e;
    }

    // Метод для подсчёта закрытых чисел
    public int countClosedNumbers() {
        int count = 0;
        for (int i = 0; i < this.massive.length; i++) {
            if (this.massive[i] == -1) {
                count++;
            }
        }
        return count;
    }

    // Метод для подсчёта оставшихся чисел
    public int countOpenedNumbers() {
        return 5 - this.countClosedNumbers();
    }

    //Метод закрытия числа на карточке
    public boolean closeNumber(int number) {
        for (int i = 0; i < this.massive.length; i++) {
            if (this.massive[i] == number) {
                this.massive[i] = -1; // Число закрыто
                return true;
            }
        }
        return false;
    }

    // Метод для проверки, закрыта ли вся карточка
    public boolean isCardFullClosed() {
        return this.countClosedNumbers() == 5;
    }

    // Метод для вывода состояния карточки
    @Override
    public String toString(){
        String ans = "[";
        for(int i = 0; i < this.massive.length; i ++){
            if(this.massive[i] == -1){
                if(i == 4){
                    ans += "X]";
                }else {
                    ans += "X ";
                }
            }else{
                if(i == 4){
                    ans += this.massive[i]+"]";
                }else{
                    ans += this.massive[i]+" ";
                }
            }
        }
        return ans;
    }

    // Метод для вывода оригинальной карточки
    public String printOriginalCard(){
        String ans = "[";
        for(int i = 0; i < this.massive_2.length; i ++){
            if(this.massive_2[i] == -1){
                if(i == 4){
                    ans += "X]";
                }else {
                    ans += "X ";
                }
            }else{
                if(i == 4){
                    ans += this.massive_2[i]+"]";
                }else{
                    ans += this.massive_2[i]+" ";
                }
            }
        }
        return ans;
    }

    //Метод определение выигрыша по числу n
    public int winNumber(int n){
        for(int i = 0; i < n; i ++){
            int num = in.nextInt();
            this.closeNumber(num);
            if(this.isCardFullClosed()){
                return num;
            }
        }
        return -1;
    }

    //Определение выигрыша по массиву чисел
    public int winNumber(int[] arg){
        for(int i = 0; i < arg.length; i ++){
            this.closeNumber(arg[i]);
            if(this.isCardFullClosed()){
                return arg[i];
            }
        }
        return -1;
    }

    //Метод определение победителя среди нескольких игроков
    public static String lottoWinner(Card[] a, int[] b){
        Card ans = a[0];
        boolean flag = false; // пока победителя нет
        for(int i = 0; i < b.length; i ++){//по каждому числу из массива b
            for(int j = 0; j < a.length; j ++){//по каждой карточке в массиве a
                a[j].closeNumber(b[i]);
                if(a[j].isCardFullClosed()){
                    if(!flag){
                        ans = a[j];
                        flag = true;
                    }

                }
            }
        }

        if(flag){
            return "Победитель: "+ ans.printOriginalCard();
        }else{
            return "Победителей не будет";
        }
    }
}

