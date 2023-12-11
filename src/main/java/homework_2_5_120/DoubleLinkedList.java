package homework_2_5_120;

import java.util.Iterator;
import java.util.ListIterator;

public class DoubleLinkedList<F> implements CustomList<F>{
    private Node head;
    private Node tail;

    @Override
    public void add(F data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void reversPrint() {
        System.out.println(this.reverstoString());
    }

    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder("[");
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(currentNode.next != null ? ", " : "");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String reverstoString() {
        Node currentNode = tail;
        StringBuilder sb = new StringBuilder("[");
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(currentNode.prev != null ? ", " : "");
            currentNode = currentNode.prev;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public ListIterator<F> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements ListIterator{
        Node head;
        Node current;
        public MyIterator(Node head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            current = current==null ? head : current.next;
            return current!=null;
        }

        @Override
        public boolean hasPrevious(){
            current = current==null ? tail : current.prev;
            return current!=null;
        }

        @Override
        public Object previous() {
            return current!=null ? current.data : null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }

        @Override
        public F next() {
            return current!=null ? current.data : null;
        }
    }

    public void forEachRev(){
        ListIterator<F> iter = this.iterator();
        while (iter.hasPrevious()){
            System.out.println(iter.previous());
        }
    }

    public void forEachTo(F data){
        Iterator<F> iter = this.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
            if(iter.next()==data){
                break;
            }
        }
    }

    public void TailForEachTo(F data){
        ListIterator<F> iter = this.iterator();
        while (iter.hasPrevious()){
            System.out.println(iter.previous());
            if(iter.previous()==data){
                break;
            }
        }
    }

    public void forEachAfter(F data){
        Iterator<F> iter = this.iterator();
        int var = 0;
        while (iter.hasNext()){
            iter.next();
            if(iter.next()==data){
                System.out.println(iter.next());
                var++;
                break;
            }
        }
        if(var == 1){
            while (iter.hasNext()){
                System.out.println(iter.next());
            }
        }
    }

    public void TailForEachAfter(F data){
        ListIterator<F> iter = this.iterator();
        int var = 0;
        while (iter.hasPrevious()){
            iter.previous();
            if(iter.previous()==data){
                System.out.println(iter.previous());
                var++;
                break;
            }
        }
        if(var == 1){
            while (iter.hasPrevious()){
                System.out.println(iter.previous());
            }
        }
    }

    public class Node {
        private F data;
        private Node next;
        private Node prev;
        public Node(F data) {
            this.data = data;
            next = null;
            prev = null;

        }
    }

    public F getHead() {
        if (head!=null) {
            return head.data;
        }
        return null;
    }

    public F getTail() {
        if (head!=null) {
            return tail.data;
        }
        return null;
    }

    public F getHeadAndDelete() {
        if (head!=null) {
            F var = getHead();
            if (head.next == null) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return var;
        }
        return null;
    }

    public F getTailAndDelete() {
        if (head!=null) {
            F var = getTail();
            if (tail.prev == null) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
            return var;
        }
        return null;
    }

    public void addByIndex(F data, int index){
        Node currentNode = head;
        int c = 0;
        Node newNode = new Node(data);

        if (index==0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            while (currentNode.next != null && c != index) {
                currentNode = currentNode.next;
                c++;
            }
            if (index>c){
                throw  new IllegalArgumentException();
            }
            currentNode.prev.next = newNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
            newNode.next = currentNode;
        }
    }

    public void addHead(F data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
        }else {
            head.prev = newNode;
        }
        newNode.next= head;
        head=newNode;
    }

    public void find(F data){
        Node currentNode = head;
        int count = 0;
        if (currentNode.data == data) count++;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            if(currentNode.data == data){
                count++;
            }
        }
        System.out.println("Совпадение присутствует " + count + " раз(а)");
    }

    public void remove(F data){
        if(head!=null) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.data == data) {
                    if (currentNode == head) {
                        if(currentNode.next==null){
                            head = null;
                            tail = null;
                        }else {
                            currentNode.next.prev = null;
                            head = currentNode.next;
                        }
                    } else if (currentNode == tail) {
                        currentNode.prev.next = null;
                        tail = currentNode.prev;

                    } else {
                        currentNode.next.prev = currentNode.prev;
                        currentNode.prev.next = currentNode.next;
                    }
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void replaceAll(F data){
        if(head == null){return;}
        Node currentNode = head;
        head.data = data;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            currentNode.data = data;
        }
    }

    public void addArray(F[] array){
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    public void addTailLinkedList(DoubleLinkedList list){
        if(head == null){return;}
        Node currentNode = list.head;
        while (currentNode != null) {
            add((F) list.getHeadAndDelete());
            currentNode = currentNode.next;
        }
    }

    public void addLinkedList(DoubleLinkedList list){
        if(head == null){return;}
        Node currentNode = list.tail;
        while (currentNode != null) {
            addHead(currentNode.data);
            currentNode = currentNode.prev;
        }
        list.tail = list.head = null;
    }
}

