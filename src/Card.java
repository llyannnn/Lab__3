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

        massive_2 = new int[5];
        massive_2[0] = a;
        massive_2[1] = b;
        massive_2[2] = c;
        massive_2[3] = d;
        massive_2[4] = e;
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
    public boolean coverNumber(int number) {
        for (int i = 0; i < this.massive.length; i++) {
            if (this.massive[i] == number) {
                this.massive[i] = -1; // Число закрыто
                return true;
            }
        }
        return false;
    }

    // Метод для проверки, закрыта ли вся карточка
    public boolean isCardFullyCovered() {
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
    public String getOriginalCard(){
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
    public int winner(int n){
        for(int i = 0; i < n; i ++){
            int num = in.nextInt();
            this.coverNumber(num);
            if(this.isCardFullyCovered()){
                return num;
            }
        }
        return -1;
    }

    //Определение выигрыша по массиву чисел
    public int winner(int[] arg){
        for(int i = 0; i < arg.length; i ++){
            this.coverNumber(arg[i]);
            if(this.isCardFullyCovered()){
                return arg[i];
            }
        }
        return -1;
    }

    //Метод определение победителя среди нескольких игроков
    public static String Loto(Card[] a, int[] b){
        Card ans = a[0];
        int count = 0;
        boolean flag = false; // пока победителя нет
        for(int i = 0; i < b.length; i ++){
            for(int j = 0; j < a.length; j ++){
                a[j].coverNumber(b[i]);
                if(a[j].isCardFullyCovered()){
                    count ++;
                    if(!flag){
                        ans = a[j];
                        flag = true;
                    }

                }
            }
        }

        if(flag){
            return "Победитель: "+ ans.getOriginalCard() + " Кол-во закрытых карт: " + count;
        }else{
            return "Победителей не будет";
        }
    }
}

