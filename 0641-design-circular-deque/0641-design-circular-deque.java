class MyCircularDeque {
    private int[] d;
    private int f, r, sz, cap;
    public MyCircularDeque(int k) { d = new int[k]; f = 0; r = 0; sz = 0; cap = k; }
    public boolean insertFront(int v) { if (isFull()) return false; f = (f - 1 + cap) % cap; d[f] = v; sz++; return true; }
    public boolean insertLast(int v) { if (isFull()) return false; d[r] = v; r = (r + 1) % cap; sz++; return true; }
    public boolean deleteFront() { if (isEmpty()) return false; f = (f + 1) % cap; sz--; return true; }
    public boolean deleteLast() { if (isEmpty()) return false; r = (r - 1 + cap) % cap; sz--; return true; }
    public int getFront() { return isEmpty() ? -1 : d[f]; }
    public int getRear() { return isEmpty() ? -1 : d[(r - 1 + cap) % cap]; }
    public boolean isEmpty() { return sz == 0; }
    public boolean isFull() { return sz == cap; }
}