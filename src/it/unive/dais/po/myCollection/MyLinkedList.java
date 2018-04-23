package it.unive.dais.po.myCollection;


import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, MyQueue<E>{

    private  MyDLNode<E> head;
    private int size;


    /*
     * COSTRUTTORI
     */

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    /*
        IMPLEMENTAZIONE METODI MYCOLLECTION
     */
    public boolean add(E elem){
        MyDLNode<E> nuovo = new MyDLNode<>(null,elem,null);
        if (head== null){
            head = nuovo;
            size++;
        }
        else{
            MyDLNode<E> app = head;
            while(app.getNext() != null){
                app = app.getNext();
            }
            nuovo.setPrev(app);
            app.setNext(nuovo);
            size++;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size  = 0;
    }

    @Override
    public boolean contains(Object o) {
        MyDLNode<E> app = head;
        while(app.getNext() != null){
            if(o.equals(app.getInfo())){
                return true;
            }
            app = app.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        else return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public void remove(int position) throws NotFoundException {
        if (position <0 || position > size()){
            throw new NotFoundException("MyLinkedList.remove la posizione" + position + " non esiste");
        }
        if(position == 0){
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
        else{
            MyDLNode<E> app = head;
            while(position > 0){
                app = head.getNext();
                position--;
            }
            app.setNext(app.getNext().getNext());
            size--;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Object[] toArray(){
        Object[] res = new Object[size()];
        MyDLNode<E> app = head;
        for(int i =0; i<size(); i++){
            res[i] = app.getInfo();
            app = app.getNext();
        }
        return res;
    }

    /*
        IMPLEMENTAZIONE METODI MYLIST
     */



    @Override
    public void add (int pos, E elem ) throws NotFoundException {
        if (pos < 0 || pos > size()){
            throw new NotFoundException("MyLinkedList.add la posizione" + pos + " non esiste");
        }
        if (pos==0){
            head = new MyDLNode<>(null, elem, head);
        }
        else{
            MyDLNode<E> app = head;
            while(pos > 1 ){
                pos--;
                app = app.getNext();
            }
            app.setNext(new MyDLNode<>(app,elem,app.getNext()));
        }
        size++;
    }


    @Override
    public E get(int position) throws NotFoundException{
        if (position < 0 || position >= size())
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        if (position == 0)
            return head.getInfo();
        else {
            MyDLNode<E> n = head;
            while (position-- > 1) {
                n = n.getNext();
            }
            return n.getNext().getInfo();
        }
    }

    @Override
    public boolean remove(Object o) {
        MyDLNode<E> app = head;
        for(int i = 0; i<size();i++){
            if(o.equals(app.getInfo())){
                if (i == 0){
                    head = head.getNext();
                    head.setPrev(null);
                }
                else{
                    app = app.getPrev();
                    app.setNext(app.getNext().getNext());
                }
                size--;
                return true;
            }
            app = app.getNext();
        }
        return false;
    }

    @Override
    public E set(int position, E element) {
        return null;
    }

     /*

        IMPLEMENTAZIONE METODI MYQUEUE

     */

     @Override
     public E element() throws NoSuchElementException {
         if (size() == 0){
             throw new NoSuchElementException("MYLinkedList.element coda vuota");
         }
         else{
             return head.getInfo();
         }
     }

    @Override
    public E peek() {
        if (size() == 0){
            return  null;
        }
        else{
            return head.getInfo();
        }
    }

    @Override
    public E remove() throws NoSuchElementException {
        if (size() == 0){
            throw new NoSuchElementException("MYLinkedList.element coda vuota");
        }
        else{
            E res = head.getInfo();
            head= head.getNext();
            head.setPrev(null);
            return res;
        }
    }

    @Override
    public E poll() {
        if (size() == 0){
            return  null;
        }
        else{
            E res = head.getInfo();
            head= head.getNext();
            head.setPrev(null);
            return res;
        }
    }

    @Override
    public boolean offer(E elem) {
        return add(elem);
    }


    /*

        IMPLEMENTAZIONE METODI ITERATOR

     */

    @Override
    public MyIterator<E> iterator() {
        return null;
    }


}