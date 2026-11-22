public class StackRiwayat {
    private String[] data;
    private int top;
    private int kapasitas;

    public StackRiwayat(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new String[kapasitas];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == kapasitas - 1);
    }

    public void push(String riwayat) {
        if (!isFull()) {
            data[++top] = riwayat;
        } else {
            System.out.println("Stack Penuh! Riwayat tidak dapat ditambah.");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            System.out.println("Stack Kosong! Tidak ada riwayat untuk dibatalkan.");
            return null;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return data[top];
        }
        return null;
    }

    public int size() {
        return top + 1;
    }

    public void tampilkanStack() {
        if (isEmpty()) {
            System.out.println("Riwayat aktivitas kosong.");
        } else {
            System.out.println("--- Riwayat Aktivitas (Stack LIFO) ---");
            for (int i = top; i >= 0; i--) {
                System.out.println("- " + data[i]);
            }
        }
    }
}