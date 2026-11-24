package practical17.singly;
import java.util.Scanner;

public class CardFileApp {
    private static int readCode(Scanner in) {
        System.out.println("Введите код товара:");
        if (!in.hasNextInt()) {
            System.out.println("Нужно целое число");
            if (in.hasNextLine()) in.nextLine();
            return -1;
        }
        int code = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        if (code <= 0) {
            System.out.println("Код должен быть положительным");
            return -1;
        }
        return code;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProductList list = new ProductList();
        boolean running = true;
        System.out.println("Односвязный список товаров");
        while (running) {
            System.out.println("\n1 - Создать пустой список");
            System.out.println("2 - Добавить товар");
            System.out.println("3 - Удалить товар по коду");
            System.out.println("4 - Показать товар по коду");
            System.out.println("5 - Показать все товары");
            System.out.println("6 - Очистить список");
            System.out.println("7 - Проверить, пуст ли список");
            
            System.out.println("0 - Выход");
            if (!in.hasNextLine()) return;
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    list.createEmpty();
                    System.out.println("Создан пустой список");
                    break;
                case "2":
                    ProductNode node = new ProductNode();
                    if (node.readFromConsole(in)) {
                        if (list.add(node)) System.out.println("Товар добавлен");
                        else System.out.println("Такой код уже есть или данные неверны");
                    }
                    break;
                case "3":
                case "4":
                    int code = readCode(in);
                    if (code == -1) break;
                    if (choice.equals("3")) {
                        if (list.remove(code)) System.out.println("Товар удалён");
                        else System.out.println("Товар не найден");
                    } else {
                        list.printItem(code);
                    }
                    break;
                case "5":
                    list.printAll();
                    break;
                case "6":
                    list.clear();
                    System.out.println("Список очищен");
                    break;
                case "7":
                    if (list.isEmpty()) System.out.println("Список пуст");
                    else System.out.println("Список не пуст");
                    break;
                
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }
    }
}
