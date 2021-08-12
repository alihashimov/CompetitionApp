package com.company.util;

import java.util.Scanner;

public class TextUtil {

    public static int enterNumber(String text) {
        System.out.println(text);
        return new Scanner(System.in).nextInt();
    }

    public static String enterText(String text) {
        System.out.println(text);
        return new Scanner(System.in).nextLine();
    }

}
