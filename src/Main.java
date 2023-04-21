import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        firstTask();
        secondTask();
        thirdTask();
        fourthTask();

    }
    public static void firstTask(){
        //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
        System.out.print("Введите число типа float: ");

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                float n = in.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели число не того типа попробуйте еще раз ");

            }
        }
        System.out.println("Поздравляю ");
    }

    public static void secondTask(){
        //Если необходимо, исправьте данный код (задание 2
        try {
            int d = 0;
            int [] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс маловат " + e);
        } catch (ArithmeticException e){
            System.out.println("Деление на 0  " + e);
        }

    }
    public static void thirdTask()  {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void fourthTask(){
        try {
            String s = inputString();
        } catch (MyException e){
            System.out.println("Вызвано исключение " + e);
        }
    }

    public static String inputString() throws MyException{
        System.out.print("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();
        if (result.isEmpty() ) {
            throw new MyException("Строка не может быть пустоой");
        }

        return result;
    }

    private static class MyException extends Exception {
        public MyException(String str) {
            super(str);
        }
    }
}