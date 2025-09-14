package deque;

public class MyArrayDeque<element> implements Deque<element> {
    private int size;
    private element[] array;
    private int head;
    private int tail;
    private int capacity=10;
    public MyArrayDeque() {
        array=(element[]) new Object[capacity];
        size=head=0;
        tail=0;
    }


    public int size() {
        return size;
    }

    public void addFirst(element e) {
        tryExpand();
        if(size==capacity) {
            return;
        }
        head = (head - 1 + capacity) % capacity;
        array[head]=e;
        size++;

    }

    public void addLast(element e) {
        tryExpand();
        if(size==capacity) {
            return;
        }
        array[tail]=e;
        tail=(tail+1)%capacity;
        size++;
    }


    public element getFirst() {
        if(size==0) {
            return null;
        }
        return array[head];
    }


    public element getLast() {
        if(size==0) {
            return null;
        }
        //return array[tail==0?capacity-1:tail-1];
        return array[(tail - 1 + capacity) % capacity];
    }

    @Override
    public element removeFirst() {
        if(size==0) {
            return null;
        }
        element temp = array[head];
        head=(head+1)%capacity;
        size--;
        tryShrink();
        return temp;
    }

    @Override
    public element removeLast() {
        if(size==0) {
            return null;
        }
        element temp=array[(tail - 1 + capacity) % capacity];
        tail=(tail-1+capacity)%capacity;
        size--;
        tryShrink();
        return temp;
    }

    @Override
    public element get(int index) {
        if(size<index) {
            return null;
        }
        return array[(head+index)%capacity];
    }

    private void resize(int newCapacity) {
        element[] a = (element []) new Object[newCapacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = array[(head+i)%capacity];
        }
        array = a;
        head=0;
        tail=size;
        capacity=newCapacity;
    }

    private void tryExpand(){
        if(size==capacity) {
            resize(capacity*2);
        }
    }

    private void tryShrink(){
        if(size<capacity/4&&size>4) {
            resize(capacity/4);
        }
    }

    @Override
    public void printDeque(){
        for (element e : array) {
            System.out.println(e);
        }
    }












}
