import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tasks {
    public static void main(String[] args) throws IOException {
        // Задание 3
        //Пользователь с клавиатуры вводит путь к файлу
        //и слово для поиска. После работы программы на экран
        //отображается количество раз сколько слово встречается
        //в файле.


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу: ");
        String str = bufferedReader.readLine();
        File file = new File(str);
        System.out.println("Введите слово для поиска: ");
        String word = bufferedReader.readLine();



    }
}
