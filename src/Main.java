import java.util.BitSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello world!");
        System.out.print("Введите число n: ");
        int n= in.nextInt();
        System.out.println("Треугольное число: " + sumNumber(n));
        System.out.println("Факториял числа: " + multNumber(n));
        System.out.println("Простые числа до 1000: ");
        printAllPrimes(1000);
        System.out.println("Калькулятор: ");
        System.out.print("Введите первое число: ");
        int firstNum = in.nextInt();
        System.out.print("Введите второе число: ");
        int secondNum = in.nextInt();
        System.out.print("Введите операцию + - * /: ");
        String operation = in.next();
        calculate(firstNum, secondNum, operation);
    }
    public static void calculate(int firstNum, int secondNum, String operation){
        System.out.print("Результат: ");
        switch (operation){
            case "+":
                System.out.println(firstNum + secondNum);
                break;
            case "-":
                System.out.println(firstNum - secondNum);
                break;
            case "*":
                System.out.println(firstNum * secondNum);
                break;
            case "/":
                if (secondNum == 0){
                    System.out.println("второе число не может быть 0 ");
                    break;
                }
                System.out.println(firstNum / secondNum);
                break;
            default:
                System.out.println("Введен не корректный оператор ");
        }

    }
    public static int sumNumber(int n){
        int result = 0;
        for (int i=1; i<=n; i++) {
            result += i;
        }
        return result;
    }
    public static int multNumber(int n){
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
    public static void printAllPrimes(int sieveSize) {
        var sieve = new BitSet(sieveSize);
        sieve.set(0, sieveSize - 1, true);
        sieve.set(0, false);
        sieve.set(1, false);
        for (int i = 2; i * i < sieve.length(); i++) {
            if (sieve.get(i)) {
                for (int j = i * i; j < sieve.length(); j += i) {
                    sieve.set(j, false);
                }
            }
        }
        for (int i = 2; i < sieve.length(); i++) {
            if (sieve.get(i)) {
                System.out.print(" " + i);
            }
        }
    }
}