package deque;

public class LinkedListDeque<element> implements Deque<element> {
    private class Node{
        public element item;
        public Node next;
        public Node prev;

        public Node(element i ,Node next,Node prev) {
            item=i;
            this.next=next;
            this.prev=prev;
        }
    }

    private Node sentinel;
    private Node last;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null,null,null);
        last=new Node(null,null,null);
        sentinel.next=last;
        last.prev=sentinel;
        size=0;
    }


    public void addFirst(element e) {
        Node temp=new Node(e,null,null);
        sentinel.next.prev=temp;
        temp.next=sentinel.next;
        temp.prev=sentinel;
        sentinel.next=temp;
        size++;
    }

    public void addLast(element e) {
        Node temp=new Node(e,null,null);
        last.prev.next=temp;
        temp.next=last;
        temp.prev=last.prev;
        last.prev=temp;
        size++;
    }


    public int size(){
        return size;
    }

    public void printDeque(){
        Node temp=sentinel.next;
        while(temp!=last){
            System.out.print(temp.item+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public element removeFirst(){
        if(size==0){
            return null;
        }
        element temp=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size--;
        return temp;

    }

    public element removeLast(){
        if(size==0){
            return null;
        }
        element temp=last.prev.item;
        last.prev=last.prev.prev;
        last.prev.next=last;
        size--;
        return temp;
    }

    public element get(int index){
        if(size<index){
            return null;
        }
        Node temp=sentinel.next;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.item;
    }

    public element getRecursive(int index){
        if(size<index){
            return null;
        }
        return getRecursive(index, sentinel);
    }

    private element getRecursive(int index,Node node){
        if(index==0){
            return node.item;
        }
        return getRecursive(index-1,node.next);
    }








}
