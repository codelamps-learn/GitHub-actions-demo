package com.example;

/**
 * Entry point aplikasi. Project ini sengaja dibuat sederhana
 * agar fokus materi ada di setup GitHub Actions-nya, bukan di kompleksitas kode.
 */
public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("=== Demo Calculator ===");
        System.out.println("5 + 3 = " + calculator.add(5, 3));
        System.out.println("5 - 3 = " + calculator.subtract(5, 3));
        System.out.println("5 * 3 = " + calculator.multiply(5, 3));
        System.out.println("6 / 3 = " + calculator.divide(6, 3));
        System.out.println("Apakah 17 prima? " + calculator.isPrime(17));
    }
}
