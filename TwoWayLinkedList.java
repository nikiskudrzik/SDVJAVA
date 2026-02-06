import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        Node(E e) {
            element = e;
        }
    }

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        super(objects);
    }

    public E getFirst() {
        return (size == 0) ? null : head.element;
    }

    public E getLast() {
        return (size == 0) ? null : tail.element;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(e);
    }

    public E removeFirst() {
        return (size == 0) ? null : remove(0);
    }

    public E removeLast() {
        return (size == 0) ? null : remove(size - 1);
    }

    private Node<E> nodeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index < size / 2) {
            Node<E> current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current;
        } else {
            Node<E> current = tail;
            for (int i = size - 1; i > index; i--) current = current.previous;
            return current;
        }
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node<E> current = nodeAt(index);
            Node<E> before = current.previous;

            before.next = newNode;
            newNode.previous = before;

            newNode.next = current;
            current.previous = newNode;
        }

        size++;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public E get(int index) {
        return nodeAt(index).element;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            if (e == null ? current.element == null : e.equals(current.element)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = size - 1;
        for (Node<E> current = tail; current != null; current = current.previous) {
            if (e == null ? current.element == null : e.equals(current.element)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        Node<E> current = nodeAt(index);
        E removed = current.element;

        Node<E> before = current.previous;
        Node<E> after = current.next;

        if (before == null) head = after;
        else before.next = after;

        if (after == null) tail = before;
        else after.previous = before;

        size--;
        return removed;
    }

    @Override
    public Object set(int index, E e) {
        Node<E> current = nodeAt(index);
        E old = current.element;
        current.element = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (i < size - 1) result.append(", ");
        }

        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ForwardIterator();
    }

    private class ForwardIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException();
            E e = current.element;
            current = current.next;
            return e;
        }
    }

    public ListIterator<E> listIterator() {
        return new TwoWayListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> nextNode;
        private Node<E> lastReturned = null;
        private int nextIndex;

        TwoWayListIterator(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

            nextIndex = index;
            nextNode = (index == size) ? null : nodeAt(index);
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();

            lastReturned = nextNode;
            E e = nextNode.element;

            nextNode = nextNode.next;
            nextIndex++;

            return e;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();

            if (nextNode == null) {
                nextNode = tail;
            } else {
                nextNode = nextNode.previous;
            }

            lastReturned = nextNode;
            nextIndex--;

            return nextNode.element;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.element = e;
        }

        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);

            Node<E> after = nextNode;
            Node<E> before = (after == null) ? tail : after.previous;

            newNode.previous = before;
            newNode.next = after;

            if (before == null) head = newNode;
            else before.next = newNode;

            if (after == null) tail = newNode;
            else after.previous = newNode;

            size++;
            nextIndex++;
            lastReturned = null;
        }

        @Override
        public void remove() {
            if (lastReturned == null) throw new IllegalStateException();

            Node<E> toRemove = lastReturned;
            Node<E> before = toRemove.previous;
            Node<E> after = toRemove.next;

            if (before == null) head = after;
            else before.next = after;

            if (after == null) tail = before;
            else after.previous = before;

            if (nextNode == toRemove) {
                nextNode = after;
            } else {
                nextIndex--;
            }

            size--;
            lastReturned = null;
        }
    }
}