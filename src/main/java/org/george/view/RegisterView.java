package org.george.view;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.george.controller.RegisterController;
import org.george.domain.Rebel;
import org.george.enums.RaceEnum;

import static java.lang.System.exit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterView {
    private final String[] options = {"1 - Register", "0 - Exit"};

    private void printMenu(@NonNull String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option: ");
    }

    public void show() {
        System.out.println("------REBEL ALLIANCE------");

        int option = -1;

        while (option!=0 && option!=2) {
            printMenu(options);
            try {
                option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1 : register(); break;
                    case 0 : exit(0); break;
                    default:
                        abort();
                        break;
                }
            } catch (Exception e) {
                abort();
            }
        }
    }

    @SneakyThrows
    private void abort() {
        System.err.println("Self Destruction - ACTIVATED!");
        for (int i = 2; i >= 0; i--) {
            System.err.println("..." + (i+1));
            Thread.sleep(1000);
        }
        new RegisterController().abort();
        System.err.println("ABORTED");
        exit(1);
    }

    @SneakyThrows
    private void register() {
        System.out.println("------REBEL ALLIANCE------");
        System.out.println("---------REGISTER---------");
        String name;
        int age;
        RaceEnum raceEnum;

        System.out.print("Name: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Age: ");
        age = new Scanner(System.in).nextInt();
        System.out.println("Race: ");
        for (RaceEnum race :
                RaceEnum.values()) {
            System.out.println(race.ordinal() + " - " + race.name());
        }
        raceEnum = RaceEnum.values()[new Scanner(System.in).nextInt()];

        new RegisterController().register(new Rebel(name, age, raceEnum));

        exit(0);

    }
}
