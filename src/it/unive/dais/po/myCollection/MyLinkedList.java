package it.unive.dais.po.myCollection;


import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, MyDeque<E>{

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
    public boolean add_All(MyCollection<? extends E> c) {
        return false;
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
    public int lastIndexOf(Object o) {
        int pos = -1;
        MyDLNode<E> app = head;
        for (int i =0;i<size();i++){
            if(o.equals(app.getInfo())){
                pos = i;
            }
            app= app.getNext();
        }
        return pos;
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
    public E set(int position, E element) throws NotFoundException {
        if (position < 0 || position >= size())
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        MyDLNode<E> app = head;
        E res;
        while(position > 0){
            app = app.getNext();
        }
        res = app.getInfo();
        app.setInfo(element);
        return res;
    }

    @Override
    public MyList<E> subList(int from, int to) throws NotFoundException {
        if (from < 0 || from >= size()){
            throw new NotFoundException("MyList.subList from value" + from +  "not valid");
        }
        if(to<0 || to >= size()){
            throw new NotFoundException("MyList.subList to value" + to +  "not valid");
        }
        if (from> to){
            throw new NotFoundException("MyList.subList from value major of" + to +  "value");
        }
        MyList<E> res = new MyLinkedList<>();
        MyDLNode<E> app = head;
        while(from >0){
            app = app.getNext();
            from--;
        }
        while(to>1){
            res.add(app.getInfo());
            app = app.getNext();
            to--;
        }
        return res;
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
            head = head.getNext();
            head.setPrev(null);
            size--;
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
            head = head.getNext();
            size--;
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
    public MyIterator iterator() {
        return new LinkedIterator();
    }


    private class LinkedIterator implements MyIterator<E>{
        private int pos;
        @Override
        public E next() {
            try{
                return get(pos++);
            } catch (NotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("iterator.next failed");
            }
        }

        @Override
        public boolean hasNext() {
            if ((pos<size())) return true;
            else return false;
        }
    }



    /*

        IMPLEMENTAZIONE METODI MYDEQUE


     */

    @Override
    public void addLast(E element) {
        if (size() == 0){
            add(element);
        }
        else{
            MyDLNode<E> app = head;
            while(app.getNext() != null){
                app = app.getNext();
            }
            add(element);
        }

    }

    @Override
    public void addFirst(E element) throws NotFoundException {
        add(0,element);
    }

    @Override //posso toglierli
    public boolean offerFirst(E element) throws NotFoundException {
        addFirst(element);
        return true;
    }

    @Override //posso toglierli
    public boolean offerLast(E element) {
        addLast(element);
        return true;
    }

    @Override
    public E removeFirst() throws NoSuchElementException{
        if (size() == 0){
            throw new NoSuchElementException("MyLinkedList.removeFirst la lista è vuota");
        }
        else{
            E res = head.getInfo();
            try {
                remove(0);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            return res;
        }
    }

    @Override
    public E removeLast() throws NotFoundException {
        if (size() == 0){
            throw new NotFoundException("MyLinkedList.removelast size is 0");
        }
        else{
            E res = get(size()-1);
            remove(size()-1);
            return res;
        }
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        if (size == 0){
            return null;
        }
        else{
            MyDLNode<E> app = head;
            E res;
            while(app.getNext() != null){
                app = app.getNext();
            }
            res = app.getInfo();
            app = app.getPrev();
            app.setNext(null);
            size--;
            return res;
        }
    }

    @Override
    public E getFirst() throws NotFoundException {
        if (size() == 0){
            throw new  NotFoundException("MyLinkedList.getFirst  length is 0");
        }
        else{
            return get(0);
        }
    }

    @Override
    public E getLast() throws NotFoundException {
        if (size() == 0){
            throw new  NotFoundException("MyLinkedList.getLast  length is 0");
        }
        else{
            return get(size());
        }
    }

    @Override
    public E peekFirst() {
        if (size()  == 0){
            return null;
        }
        else{
            return head.getInfo();
        }
    }

    @Override
    public E peekLast() {
        if (size()  == 0){
            return null;
        }
        else{
            MyDLNode<E> app = head;
            while(app.getNext() != null){
                app = app.getNext();
            }
            return app.getInfo();
        }
    }

    @Override
    public boolean removeFirstOccurence(Object o) throws NotFoundException {
        if(size() == 0) {
            throw new NotFoundException("MyLinkedList.removeFirstOccurence  size = 0");
        }
        else{
            MyDLNode<E> app = head;
            while(app.getNext() != null ){
                if(o.equals(app.getInfo())){
                    app = app.getPrev();
                    app.setNext(app.getNext().getNext());
                    size--;
                    return true;
                }
                app = app.getNext();
            }
            return false;
        }
    }

    @Override
    public void push(E element) {

    }

    @Override  //Perchè se chiamo solo returnFirst non mi da errore manca eccezzione?
    public E pop() throws NotFoundException {
        if (size() == 0){
            throw  new NotFoundException("MyList.pop size = 0");
        }
        else{
            return removeFirst();
        }

    }
}
