
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final static String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])"
            + "\\.((19|20)\\d\\d)";
    private final static String PHONE_PATTERN = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    public static void main(String[] args)
    {
        System.out.println("Введите: Фамилия Имя Отчество дата рождения(дд.мм.гггг) номер телефона(8-ххх-ххх-хх-хх) пол(f или m) через пробел");
        int length_Data = 6;

        Scanner in = new Scanner(System.in);
        String inData = in.nextLine();
        String[] arr = inData.split(" ");

        try {
            if (arr.length != length_Data) {throw new MyException();}
        } catch (MyException e){
            System.out.println(e);
            return;
        }

        try {
            CheckAndCallThrows(arr[0], "^[a-zA-Z]*$", "Ошибка в фамилии ");
            CheckAndCallThrows(arr[1], "^[a-zA-Z]*$", "Ошибка в имени ");
            CheckAndCallThrows(arr[2], "^[a-zA-Z]*$", "Ошибка в отчестве ");
            CheckAndCallThrows(arr[3], DATE_PATTERN     , "Ошибка в дате ");
            CheckAndCallThrows(arr[4], PHONE_PATTERN    , "Ошибка в номере телефона ");
            CheckAndCallThrows(arr[5], "[fm]"       , "Ошибка в пол ");

        } catch (MyException e) {
            System.out.println(e);
            return;
        }

        try(FileWriter writer = new FileWriter("text.txt", false))
        {
            writer.write(inData);
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }




    private static void CheckAndCallThrows(String text, String reg, String errText)throws MyException{
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches()) {throw new MyException(errText);}
    }


    private static class MyException extends Exception {
        public MyException() {
            this("Не правильный формат ввода, необходим ввод: Фамилия Имя Отчество дата рождения номер телефона пол через пробел");
        }
       public MyException(String str ) {
            super(str);
        }
    }
}