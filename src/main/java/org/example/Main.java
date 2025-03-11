package org.example;
import java.util.Scanner;
import java.util.Random;

public class Main {

    // Константи для діапазону рандомних чисел
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування розмірів матриці
        System.out.println("Введіть ширину матриці (не більше 20):");
        int width = readValidDimension(scanner);

        System.out.println("Введіть висоту матриці (не більше 20):");
        int height = readValidDimension(scanner);

        // Обираємо спосіб створення матриці
        System.out.println("Оберіть спосіб створення матриці: 1 - ручний, 2 - рандомний:");
        int choice = scanner.nextInt();

        int[][] matrix;
        if (choice == 1) {
            matrix = createMatrixManually(width, height, scanner);
        } else if (choice == 2) {
            matrix = createMatrixRandomly(width, height);
        } else {
            System.out.println("Неправильний вибір. Програма завершується.");
            return;
        }

        System.out.println("Створена матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);

        double average = calculateAverage(matrix);
        System.out.printf("Середнє арифметичне: %.2f%n", average);

        double geometricMean = calculateGeometricMean(matrix);
        System.out.printf("Середнє геометричне: %.2f%n", geometricMean);

        scanner.close();
    }

    // Метод для зчитування коректного розміру матриці
    private static int readValidDimension(Scanner scanner) {
        int dimension;
        while (true) {
            dimension = scanner.nextInt();
            if (dimension > 0 && dimension <= 20) {
                break;
            }
            System.out.println("Розмір повинен бути від 1 до 20. Спробуйте ще раз:");
        }
        return dimension;
    }

    // Метод для створення матриці ручним чином
    private static int[][] createMatrixManually(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];
        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("Елемент [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Метод для створення матриці рандомно
    private static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }

        return matrix;
    }

    // Метод для виведення матриці
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    // Метод для пошуку мінімального значення
    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    // Метод для пошуку максимального значення
    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // Метод для розрахунку середнього арифметичного
    private static double calculateAverage(int[][] matrix) {
        double sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return sum / count;
    }

    // Метод для розрахунку середнього геометричного
    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element != 0) { // Уникати множення на нуль
                    product *= Math.abs(element);
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0; // Якщо всі елементи дорівнюють нулю
        }

        return Math.pow(product, 1.0 / count);
    }
}