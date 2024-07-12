import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        exp = exp.replace("\"", "");
        char action;
        String[] data;
        if (exp.contains("+")) {
            data = exp.split("\\+");
            action = '+';
        } else if (exp.contains("-")) {
            data = exp.split("-");
            action = '-';
        } else if (exp.contains("*")) {
            data = exp.split("\\*");
            action = '*';
        } else if (exp.contains("/")) {
            data = exp.split("/");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (data[0].length() > 10) throw new Exception("Введено больше 10 символов в первой части");
        if (data.length > 1 && data[1].length() > 10) throw new Exception("Введено больше 10 символов во второй части");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        String result = "";
        if (action == '+') {
            result = data[0] + data[1];
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < multiplier; i++) {
                sb.append(data[0]);
            }
            result = sb.toString();
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                result = data[0];
            } else {
                result = data[0].substring(0, index) + data[0].substring(index + data[1].length());
            }
        } else {
            int divisor = Integer.parseInt(data[1]);
            if (divisor == 0) throw new Exception("Деление на ноль");
            int newLen = data[0].length() / divisor;
            result = data[0].substring(0, newLen);
        }

        printInQuotes(result);
    }

    public static void printInQuotes(String text) {
        if (text.length() > 40) {
            System.out.println("\"" + text.substring(0, 40) + "...\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}
