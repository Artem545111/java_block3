package practical17.circular;

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
        if (isEmpty()) {
            head = node;
            tail = node;
            node.next = node;
        } else {
            node.next = head;
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public ProductNode find(int code) {
        if (isEmpty()) return null;
        ProductNode current = head;
        do {
            if (current.getCode() == code) return current;
            current = current.next;
        } while (current != head);
        return null;
    }

    public boolean remove(int code) {
        if (isEmpty()) return false;
        ProductNode current = head;
        ProductNode before = tail;
        do {
            if (current.getCode() == code) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    before.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = before;
                    tail.next = head;
                }
                current.next = null;
                size--;
                return true;
            }
            before = current;
            current = current.next;
        } while (current != head);
        return false;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        ProductNode current = head;
        do {
            current.print();
            current = current.next;
        } while (current != head);
    }

    public void printItem(int code) {
        ProductNode node = find(code);
        if (node == null) System.out.println("Товар не найден");
        else node.print();
    }
}
