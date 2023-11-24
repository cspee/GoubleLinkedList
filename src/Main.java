import DoubleLinkedList.DoubleLinkedList;
import DoubleLinkedList.MyList;
import DoubleLinkedList.CycleDoubleLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.sol();
        System.out.println();
    }
    CycleDoubleLinkedList<CycleDoubleLinkedList> listC = new CycleDoubleLinkedList<CycleDoubleLinkedList>();
    DoubleLinkedList<DoubleLinkedList> listD = new DoubleLinkedList<DoubleLinkedList>();
    public void sol() {

        System.out.println(" Выберите пункт\n" +
                "1. Создать двойной список\n" +
                "2. Создать двойной цикличный список \n" +
                "3. Удалить список\n" +
                "4. Посмотреть все списки\n" +
                "5. Создать список с файла");
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        String type = "Integer";
        if (temp == 1) {
            listD.add(readDoubleListFromConsole());
            sol();
        }
        if (temp == 2) {
            listC.add(readCycleListFromConsole());
            sol();
        }
        if (temp == 3) {
            System.out.println("1. Удалить двойной\n" +
                    "2. Удалить циклический\n");
            int tempDelete = scanner.nextInt();
            if (tempDelete == 1) {
                System.out.println("Введите номер списка для удаления");
                tempDelete = scanner.nextInt();
                listD.remove(tempDelete);
            } else {
                System.out.println("Введите номер списка для удаления");
                tempDelete = scanner.nextInt();
                listC.remove(tempDelete);
            }
            sol();
        }
        if (temp == 4) {
            System.out.println("Все двойные списки:");
            for (int i = 0; i < listD.getSize(); i++) {
                System.out.print(i + ": ");
                printList(listD.get(i));
            }
            System.out.println("Все цикличные списки:");
            for (int i = 0; i < listC.getSize(); i++) {
                System.out.print(i + ": ");
                printList(listC.get(i));
            }
            sol();
        }
        if (temp == 5) {
            System.out.println("1. Считать двойной список с файла\n" +
                    "2. Считать циклический список с файла");
            int tempScan = scanner.nextInt();
            System.out.println("Введите имя файла");
            String fileName = scanner.nextLine();
            if (tempScan == 1) {
                listD.add(readDoubleDataFromFile(fileName));
                sol();
            }
            if (tempScan == 2) {
                listC.add(readCycleDataFromFile(fileName));
                sol();
            }
        }
    }
    //D:\AAA.txt
    public  <T> CycleDoubleLinkedList<T> readCycleDataFromFile(String filename) {
        CycleDoubleLinkedList<T> dataList = new CycleDoubleLinkedList<T>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип данных (например, Integer):");
        String elementTypeInput = scanner.nextLine().trim();

        try {
            Class<T> elementType = (Class<T>) Class.forName("java.lang." + elementTypeInput);

            try (Scanner fileScanner = new Scanner(new File(filename))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    try {
                        if (Integer.class.equals(elementType)) {
                            dataList.add(elementType.cast(Integer.parseInt(line.trim())));
                        } else if (Double.class.equals(elementType)) {
                            dataList.add(elementType.cast(Double.parseDouble(line.trim())));
                        } else if (Float.class.equals(elementType)) {
                            dataList.add(elementType.cast(Float.parseFloat(line.trim())));
                        } else if (Long.class.equals(elementType)) {
                            dataList.add(elementType.cast(Long.parseLong(line.trim())));
                        } else if (Short.class.equals(elementType)) {
                            dataList.add(elementType.cast(Short.parseShort(line.trim())));
                        } else if (Byte.class.equals(elementType)) {
                            dataList.add(elementType.cast(Byte.parseByte(line.trim())));
                        } else if (Boolean.class.equals(elementType)) {
                            dataList.add(elementType.cast(Boolean.parseBoolean(line.trim())));
                        } else if (String.class.equals(elementType)) {
                            dataList.add(elementType.cast(line));
                        } else {
                            System.out.println("Неизвестный тип данных");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода. Пропускаем строку: " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + filename);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти класс. Проверьте правильность ввода.");
        }

        return dataList;
    }
    public  <T> DoubleLinkedList<T> readDoubleDataFromFile(String filename) {
        DoubleLinkedList<T> dataList = new DoubleLinkedList<T>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип данных (например, Integer):");
        String elementTypeInput = scanner.nextLine().trim();

        try {
            Class<T> elementType = (Class<T>) Class.forName("java.lang." + elementTypeInput);

            try (Scanner fileScanner = new Scanner(new File(filename))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    try {
                        if (Integer.class.equals(elementType)) {
                            dataList.add(elementType.cast(Integer.parseInt(line.trim())));
                        } else if (Double.class.equals(elementType)) {
                            dataList.add(elementType.cast(Double.parseDouble(line.trim())));
                        } else if (Float.class.equals(elementType)) {
                            dataList.add(elementType.cast(Float.parseFloat(line.trim())));
                        } else if (Long.class.equals(elementType)) {
                            dataList.add(elementType.cast(Long.parseLong(line.trim())));
                        } else if (Short.class.equals(elementType)) {
                            dataList.add(elementType.cast(Short.parseShort(line.trim())));
                        } else if (Byte.class.equals(elementType)) {
                            dataList.add(elementType.cast(Byte.parseByte(line.trim())));
                        } else if (Boolean.class.equals(elementType)) {
                            dataList.add(elementType.cast(Boolean.parseBoolean(line.trim())));
                        } else if (String.class.equals(elementType)) {
                            dataList.add(elementType.cast(line));
                        } else {
                            System.out.println("Неизвестный тип данных");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода. Пропускаем строку: " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + filename);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти класс. Проверьте правильность ввода.");
        }

        return dataList;
    }

    public  <T> CycleDoubleLinkedList<T> readCycleListFromConsole() {
        CycleDoubleLinkedList<T> resultList = new CycleDoubleLinkedList<T>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите тип данных (например, Integer):");
        String elementTypeInput = scanner.nextLine().trim();

        try {
            Class<T> elementType = (Class<T>) Class.forName("java.lang." + elementTypeInput);

            System.out.println("Введите элементы списка (для завершения введите 'end'):");

            while (true) {
                String input = scanner.nextLine();

                if ("end".equalsIgnoreCase(input.trim())) {
                    break;
                }

                try {
                    T parsedElement = parseInput(input, elementType);
                    resultList.add(parsedElement);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода. Попробуйте еще раз.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти класс. Проверьте правильность ввода.");
        }

        return resultList;
    }

    public  <T> DoubleLinkedList<T> readDoubleListFromConsole() {
        DoubleLinkedList<T> resultList = new DoubleLinkedList<T>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите тип данных (например, Integer):");
        String elementTypeInput = scanner.nextLine().trim();

        try {
            Class<T> elementType = (Class<T>) Class.forName("java.lang." + elementTypeInput);

            System.out.println("Введите элементы списка (для завершения введите 'end'):");

            while (true) {
                String input = scanner.nextLine();

                if ("end".equalsIgnoreCase(input.trim())) {
                    break;
                }

                try {
                    T parsedElement = parseInput(input, elementType);
                    resultList.add(parsedElement);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода. Попробуйте еще раз.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти класс. Проверьте правильность ввода.");
        }

        return resultList;
    }

    private  <T> T parseInput(String input, Class<T> elementType) {
        if (Integer.class.equals(elementType)) {
            return elementType.cast(Integer.parseInt(input));
        } else if (Double.class.equals(elementType)) {
            return elementType.cast(Double.parseDouble(input));
        } else if (Float.class.equals(elementType)) {
            return elementType.cast(Float.parseFloat(input));
        } else if (Long.class.equals(elementType)) {
            return elementType.cast(Long.parseLong(input));
        } else if (Short.class.equals(elementType)) {
            return elementType.cast(Short.parseShort(input));
        } else if (Byte.class.equals(elementType)) {
            return elementType.cast(Byte.parseByte(input));
        } else if (Boolean.class.equals(elementType)) {
            return elementType.cast(Boolean.parseBoolean(input));
        } else if (String.class.equals(elementType)) {
            return elementType.cast(input);
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных");
        }
    }

    public DoubleLinkedList readListFromConsole(DoubleLinkedList tempDlist) {
        DoubleLinkedList<String> resultList = new DoubleLinkedList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки (для завершения введите пустую строку):");

        while (true) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }

            resultList.add(line);
        }

        return resultList;
    }

    public  void TestList(MyList<Integer> list){
        RandomInit(list, 5);

        System.out.println("случайно добавили 5 элементов");
        printList(list);

        System.out.println("Получили третий");
        System.out.println(list.get(3));

        System.out.println("Удалили третий, весь список");
        printList(list);

        System.out.println("Вставили перед 2ым -100, весь список");
        list.addBefore(2, -100);
        printList(list);

        System.out.println("Вставили перед 0ым -200, весь список");
        list.addBefore(0, -200);
        printList(list);

        System.out.println("Весь список, но читаем с конца");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getFromTail(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printList(MyList list){
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void RandomInit(MyList<Integer> list, int size){
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(0, 100));
        }
    }



}