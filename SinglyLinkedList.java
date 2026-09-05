public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        Node<E> curr = head;
        StringBuilder sb = new StringBuilder();

        while(curr != null){
            sb.append(curr.getElement());
            curr = curr.getNext();
        }

        return sb.toString();

    }

    public E removeLast(){
        Node<E> curr = head;

        if(head == null){
            return null;
        }

        E ans = tail.getElement();

        if(head == tail){
            head = null;
            tail = null;
            return ans;
        }

        while(curr.getNext() != tail){
            curr = curr.getNext();
        }

        tail = curr;
        curr.setNext(null);

        return ans;

    }

    public void reverse(){       
        Node<E> curr = head;
        Node<E> prev = null;

        tail = head;
        
        while(curr != null){
            Node<E> next = curr.getNext();

            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}