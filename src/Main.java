import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        check(string);
    }

    private static void check(String string) {
        String temp;
        Pattern date = Pattern.compile("^[\\d]{2}.[\\d]{2}.[\\d]{4}$");
        Pattern dateTime = Pattern.compile("^[\\d]{2}.[\\d]{2}.[\\d]{4}T[\\d]{2}:[\\d]{2}$");
        Pattern email = Pattern.compile("^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*\\.[A-Za-z]{2,}$");

        Matcher dateM = date.matcher(string);
        Matcher dateTimeM = dateTime.matcher(string);
        Matcher emailM = email.matcher(string);
        if (dateTimeM.find()) {
            temp = dateTimeM.replaceFirst("");
            if (temp.length() != 0) {
                System.out.println("Строка " + string + " не является датой и временем");

            } else
                System.out.println("Строка " + string + " является датой и временем");
        }
        else if (dateM.find()) {
            temp = dateM.replaceFirst("");
            if (temp.length() != 0) {
                System.out.println("Строка " + string + " не является датой");

            } else
                System.out.println("Строка " + string + " является датой");
        } else if (emailM.find()) {
            temp = emailM.replaceFirst("");
            if (temp.length() != 0) {
                System.out.println("Строка " + string + " не является адресом эл. почты");
            } else
                System.out.println("Строка " + string + " является адресом эл. почты");
        } else {
            System.out.println("Данная строка не подходит под возможный формат");
        }
    }
}