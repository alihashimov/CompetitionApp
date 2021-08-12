package com.company.service;

import com.company.bean.Competitor;
import com.company.exception.MyException;
import com.company.myStorage.AppStoreage;
import com.company.util.TextUtil;

import java.util.Random;

public class CompetitorService {

    public static void check() {
        int x = 0;
        while (x != 3) {
            if (x != 0) {
                System.out.println("Zehmet olmasa  " + (x + 1) + "-i defe cehd edin.");
            }
            String name = TextUtil.enterText("Please enter name:");
            String password = TextUtil.enterText("Please enter password:");
            try {
                if (!name.equals("Sarkhan") && !password.equals("12345"))
                    throw new MyException();
                else {
                    System.out.println("Successfully logged in\n");
                    menu();
                    break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (x == 2) {
                System.out.println("You banned");
            }
            x++;
        }
    }

    public static void menu() {
        System.out.println("Zehmet olmasa menu seçin:");
        int menuNumber = TextUtil.enterNumber("1.Yarışmacıları register et. " +
                "\n2.Yarışmaya başla. " +
                "\n3.Logout. " +
                "\n4.Exit.");
        if (menuNumber == 1) {
            registerCompetitor();
        } else if (menuNumber == 2) {
            if (AppStoreage.competitors != null) {
                startCompetitor();
            } else {
                System.err.println("Yarışmaçı olmadan yarışmaya başlaya bilmersiniz!!!\nEvvelce Yarışmacıları qeydiyyatdan kecirin.\n");
                menu();
            }
        } else if (menuNumber == 3) {
            check();
        } else if (menuNumber == 4) {
            System.exit(0);
        } else {
            System.err.println("Sehv reqem daxil etdiniz  \n Zehmet olmasa 1 ve 4 araliginda bir reqem daxil edin.");

        }
    }

    public static void registerCompetitor() {
        int number = TextUtil.enterNumber("Yarışmada necə şəxs iştirak edəcək.?");
        AppStoreage.competitors = new Competitor[number];
        for (int i = 0; i < AppStoreage.competitors.length; i++) {
            String name = TextUtil.enterText("Enter name:");
            String surname = TextUtil.enterText("Enter surname:");
            int age = TextUtil.enterNumber("Enter age:");
            AppStoreage.competitors[i] = new Competitor(i + 1, name, surname, age);
        }
        System.out.println("Yarışmada iştirak edən şəxslər uğurla qeydiyyatdan keçdi Növbəti əməliyyati seçin.");
        showAllCompetitor();
        menu();

    }

    public static void startCompetitor() {
        showAllCompetitor();
        Random random = new Random();
        int randomNumber = random.nextInt(AppStoreage.competitors.length);
        int number = TextUtil.enterNumber("Please enter a number:");
        if (number == randomNumber) {
            System.out.println("Congratulations. You Won!!!");
            System.out.println(AppStoreage.competitors[randomNumber - 1]);
        } else {
            System.out.println("You failed  :( ");
            menu();
        }
    }

    public static void showAllCompetitor() {
        for (int i = 0; i < AppStoreage.competitors.length; i++) {
            System.out.println(AppStoreage.competitors[i]);
        }
    }
}
