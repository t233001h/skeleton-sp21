package deque;

public interface Deque<element> {
    void addFirst(element item);

    void addLast(element item);

    default boolean isEmpty(){
        return size() == 0;
    }

    int size();

    void printDeque();

    element removeFirst();

    element removeLast();

    element get(int index);

    element getFirst();
}
