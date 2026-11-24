package practical17.circular;
import java.util.Scanner;

// Узел хранит данные одного товара и ссылки для соединения с другими узлами.
public class ProductNode {
    private int code;
    private String name;
    private int quantity;
    ProductNode next;


    public ProductNode() { }

    public ProductNode(int code, String name, int quantity) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public boolean readFromConsole(Scanner in) {
        System.out.println("Введите положительный код товара:");
        if (!in.hasNextInt()) {
            System.out.println("Нужно целое число");
            if (in.hasNextLine()) in.nextLine();
            return false;
        }
        int newCode = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        System.out.println("Введите название товара:");
        if (!in.hasNextLine()) return false;
        String newName = in.nextLine().trim();
        System.out.println("Введите количество товара:");
        if (!in.hasNextInt()) {
            System.out.println("Нужно целое число");
            if (in.hasNextLine()) in.nextLine();
            return false;
        }
        int newQuantity = in.nextInt();
        if (in.hasNextLine()) in.nextLine();
        if (newCode <= 0 || newName.isEmpty() || newQuantity < 0) {
            System.out.println("Код должен быть положительным, название непустым, количество неотрицательным");
            return false;
        }
        code = newCode;
        name = newName;
        quantity = newQuantity;
        return true;
    }

    public void print() {
        System.out.println("Код: " + code + ", товар: " + name + ", количество: " + quantity);
    }
}
