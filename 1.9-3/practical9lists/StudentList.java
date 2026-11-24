package practical9lists;

public class StudentList {
    private static class Node {
        Student student;
        Node next;

        Node(Student student) { this.student = student; }
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }

    public void add(Student student) {
        if (student == null) return;
        Node node = new Node(student);
        if (isEmpty()) head = node;
        else tail.next = node;
        tail = node;
        size++;
    }

    public Student get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.student;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    private static Node merge(Node first, Node second) {
        Node dummy = new Node(null);
        Node last = dummy;
        while (first != null && second != null) {
            if (first.student.compareTo(second.student) <= 0) {
                last.next = first;
                first = first.next;
            } else {
                last.next = second;
                second = second.next;
            }
            last = last.next;
        }
        if (first != null) last.next = first;
        else last.next = second;
        return dummy.next;
    }

    private static Node mergeSort(Node start) {
        if (start == null || start.next == null) return start;
        Node slow = start;
        Node fast = start.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right = slow.next;
        slow.next = null;
        Node leftSorted = mergeSort(start);
        Node rightSorted = mergeSort(right);
        return merge(leftSorted, rightSorted);
    }

    public void sort() {
        head = mergeSort(head);
        tail = head;
        if (tail != null) {
            while (tail.next != null) tail = tail.next;
        }
    }

    public static StudentList combine(StudentList first, StudentList second) {
        StudentList result = new StudentList();
        // копируем узлы чтобы сохранить исходные списки.
        Node current = first.head;
        while (current != null) {
            result.add(current.student);
            current = current.next;
        }
        current = second.head;
        while (current != null) {
            result.add(current.student);
            current = current.next;
        }
        result.sort();
        return result;
    }
}
