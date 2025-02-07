package pet_shelter.test_code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter Name : ");
            String name = scan.nextLine();
            System.out.println("Hello, " + name + "!");

        }
    }
}