import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String text = "Тестовый текст";
        File file = new File("file1.txt");

        try (FileOutputStream fos = new FileOutputStream(file); BufferedOutputStream bufOutStr = new BufferedOutputStream(fos)){
            bufOutStr.write(text.getBytes(), 0, text.getBytes().length);
//            bufOutStr.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bufInputStr = new BufferedInputStream(fis)){
            byte[] mass = new byte[bufInputStr.available()];
            bufInputStr.read(mass);
            System.out.println(new String(mass));
//            int b;
//            while ((b = bufInputStr.read()) != -1){
//                System.out.println((char) b);
//            }
        } catch (IOException e) {
            e.printStackTrace();
       }

        Student st1 = new Student("Иванов", "MA", 8.0);
        Student st2 = new Student("Сидоров", "MA", 9.0);

//        try (FileOutputStream fos1 = new FileOutputStream("file2.txt"); ObjectOutputStream objOutStr = new ObjectOutputStream(fos1)){
//            objOutStr.writeObject(st1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileInputStream fis1 = new FileInputStream("file2.txt"); ObjectInputStream objIntStr = new ObjectInputStream(fis1)){
            Student result = (Student) objIntStr.readObject();
//            System.out.println("результат " + result.getFio() + " " + result.getGroup());
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        String text2 = "Строка для записи файла";
        try (FileWriter writer = new FileWriter("file3.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(text2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("file3.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8")){
//            char[] result = new char[fis.available()];
//            isr.read(result);
//            System.out.println(new String(result));
            int b;
            while ((b = isr.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder res =  new StringBuilder();

        try (FileReader reader = new FileReader("file3.txt");
        BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.append(line);
            }
            bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
