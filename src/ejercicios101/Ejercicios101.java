package ejercicios101;

import java.util.Scanner;

/**
 *
 * @author pingvii1
 */
public class Ejercicios101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMain;

        do {
            System.out.println("\n--- 101 Ejercicios ---");
            System.out.println("1. FizzBuzz");
            System.out.println("2. Anagrama");
            System.out.println("3. Sucesion de Fibonacci");
            System.out.println("4. Numero Primo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionMain = sc.nextInt();

            switch (opcionMain) {
                case 1:
                    fizzBuzz();
                    break;
                case 2:
                    anagrama();
                    break;
                case 3:
                    fibonacci();
                    break;
                case 4:
                    primo();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion inválida. Intente nuevamente.");
            }
        } while (opcionMain != 0);

        sc.close();
    }

    /*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
     */
    public static void fizzBuzz() {
        System.out.println("\n--- FizzBuzz ---");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    /*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
     */
    public static void anagrama() {
        String palabra1;
        String palabra2;
        char letra;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la primera palabra: ");
        palabra1 = sc.nextLine().toLowerCase();

        System.out.print("Ingrese la segunda palabra: ");
        palabra2 = sc.nextLine().toLowerCase();

        if (palabra1.equals(palabra2)) {

            System.out.println("Las palabras NO son anagramas. ");
            sc.close();
            return;
        }

        if (palabra1.length() != palabra2.length()) {

            System.out.println("Las palabras NO son anagramas. ");
            sc.close();
            return;

        }
        for (int i = 0; i < palabra1.length(); i++) {
            letra = palabra1.charAt(i);
            index = palabra2.indexOf(letra);
        }
        if (index == -1) {
            System.out.println("Las palabras NO son anagramas");
            return;
        }
        palabra2 = palabra2.substring(0, index) + palabra2.substring(index + 1);
        System.out.println("Las palabras son anagramas");
    }

    /*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
     */
    public static void fibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Sucesion de Fibonacci ---");
        System.out.print("Ingrese cuantos numeros de la sucesion desea ver: ");
        int fin = sc.nextInt();

        if (fin <= 0) {
            System.out.println("Ingrese un numero mayor a 0.");
            return;
        }

        int num1 = 0, num2 = 1, fibonacci;
        System.out.print("Sucesion de Fibonacci: " + num1 + ", " + num2);

        for (int i = 2; i < fin; i++) {
            fibonacci = num1 + num2;
            System.out.print(", " + fibonacci);
            num1 = num2;
            num2 = fibonacci;
        }

        System.out.println();
    }

    /*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 * Un numero es primo cuando es divisible por 1 y por si mismo
 * Ejemplo: 2,3,5,7,etc.
     */
    public static void primo() {

        int num;
        boolean primo = true;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero a comprobar: ");
        num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Ingrese un numero mayor a 0");
            return;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }

    }
}
