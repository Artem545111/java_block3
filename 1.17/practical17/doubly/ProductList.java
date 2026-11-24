package practical17.doubly;

public class ProductList {
    private ProductNode head;
    private ProductNode tail;
    private int size;

    public ProductList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void createEmpty() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }
    public void clear() { createEmpty(); }

    public boolean add(ProductNode product) {
        if (product == null || product.getCode() <= 0 || product.getName() == null
                || product.getName().trim().isEmpty() || product.getQuantity() < 0) return false;
        if (find(product.getCode()) != null) return false;
        // Создаём отдельный узел: его ссылки принадлежат только этому списку.
        ProductNode node = new ProductNode(product.getCode(), product.getName(), product.getQuantity());
        node.previous = tail;
        if (isEmpty()) head = node;
        else tail.next = node;
        tail = node;
        size++;
        return true;
    }

    public boolean remove(int code) {
        ProductNode current = find(code);
        if (current == null) return false;
        if (current.previous == null) head = current.next;
        else current.previous.next = current.next;
        if (current.next == null) tail = current.previous;
        else current.next.previous = current.previous;
        current.next = null;
        current.previous = null;
        size--;
        return true;
    }

    public void printBackwards() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        ProductNode current = tail;
        while (current != null) {
            current.print();
            current = current.previous;
        }
    }

    public ProductNode find(int code) {
        ProductNode current = head;
        while (current != null) {
            if (current.getCode() == code) return current;
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        ProductNode current = head;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }

    public void printItem(int code) {
        ProductNode node = find(code);
        if (node == null) System.out.println("Товар не найден");
        else node.print();
    }
}
