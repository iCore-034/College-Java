package codewith;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        double m = System.currentTimeMillis();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {//--------------- Работы программы начнется с определенного момента(через 0.01с)
            int i = 0;
            @Override
            public void run() {
                if (i == 1){
                    juice lovely = new juice();//-----------------Инициализация основного кода(функция goo класса juice)
                    juice.goo();
                    double i = (System.currentTimeMillis() - m)/1000;
                    System.out.println("Program worked " + i + " seconds");
                    timer.cancel();
                    return;
                }
                i++;
            }
        },000001, 000001);//---------------------------------------------------------- Условные 0.01 секунды
    }
}
