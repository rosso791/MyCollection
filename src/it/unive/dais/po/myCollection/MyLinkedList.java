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
    public void addAll(MyCollection<? extends E> c) {

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
        return size() == 0;
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
    public E set(int position, E element) throws NotFoundException {
        if (position < 0 || position >= size())
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        MyDLNode<E> app = head;
        E res;
        while(position > 0){
            app = app.getNext();
            position--;
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


        In questo caso per creare l'iteratore utilizzo una classe privata all'interno della classe MyLinkedList

        La classe privata chiamata LinkedIterator implementa l'interfaccia MyIterator in quanto all'interno devo andare a
        sviluppare i metodi dell'interfaccia MyIterator next e hasNext

        Successivamente il metodo iterator() restisuisce un oggetto di tipo MyIterator il quale si ottiene semplicemente
        chiamando il cosrtruttore vuoto della classe LinkedIterator creata precedentemente. andrò a costriuire quindi un
        oggetto anonimo.
     */



    @Override
    public MyIterator<E> iterator() {
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
                throw new RuntimeException("iterato.next ha fallito, sei andato oltre l'iteratore");
            }
        }

        @Override
        public boolean hasNext() {
            return (pos < size());
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
    public void addFirst(E element){
        add(element);
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
        if (size() == 0){
            return null;
        }
        else{
            E res = head.getInfo();
            MyDLNode<E> app = head;
            app.setNext(app.getNext());
            return res;
        }
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
        MyDLNode<E> nuovo = new MyDLNode<>(null,element,null);
        if(size() == 0){
            head = nuovo;
            size++;
        }
        else{
            nuovo.setNext(head);
            head = nuovo;
            size++;
        }
    }

    @Override
    public E pop() throws NotFoundException {
        if (size() == 0){
            throw new NotFoundException("MyList.pop size = 0");
        }
        else{
            return removeFirst();
        }

    }


    /*

        IMPLEMENTAZIONE METODI MYLISTITERATOR

     */



    public MyListIterator<E> listIterator(){
        return new ListItr();
    }

    public MyListIterator<E> listIterator(int from){
        return  new ListItr(from);
    }

    private class ListItr implements MyListIterator<E>{
        private int pos;

        public ListItr(int from){
            pos = from;
        }

        public ListItr(){
            this.pos = 0;
        }


        @Override
        public void add(int position, E element) throws NotFoundException {
            try {
                MyLinkedList.this.add(position, element);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasPrevious() {
            return pos >= 0;
        }

        @Override
        public int nextIndex() {
            if (pos > MyLinkedList.this.size()){
                return size();
            }
            else{

                return pos+ 1;
            }
        }

        @Override
        public E previous() throws NotFoundException {
            try{
                return get(pos--);
            }
            catch (NotFoundException e){
                e.printStackTrace();
                throw new NotFoundException("MyListIterator.previous, non c'è precedente. Non faccio nulla");
            }
        }

        @Override
        public int previousIndex() {
            if (pos == 0){
                return -1;
            }
            else{
                return pos-1;
            }
        }

        @Override
        public void set(E elem) throws GenericException, NotFoundException {
            /*try{
                MyLinkedList.this.set(pos, elem);
            }
            catch (NotFoundException e){
                e.printStackTrace();
                throw new GenericException("MyLinkedList.ListItr.set non dovremmo essere mai qui");
            }*/

        }

        @Override //da controllare
        public E nextTimes(int skip) throws NotFoundException {
            if(pos + skip > MyLinkedList.this.size()){
                throw new NotFoundException("MyLinkedList.ListItr.nextTimes," + (skip+pos) +  "è maggiore di size" +  MyLinkedList.this.size() );
            }
            else if(skip < 0 ){
                throw new NotFoundException("MyLinkedList.ListItr.nextTimes skip è negativo" );
            }
            else{
                pos = pos +skip;
                return  get(pos);
            }
        }

        @Override //da controllare
        public E prevTimes(int skipTimes) throws NotFoundException {
            if(pos - skipTimes< 0){
                throw new NotFoundException("MyLinkedList.ListItr.prevTimes," + (pos - skipTimes) +  "è minore di zero" +  MyLinkedList.this.size());
            }
            else if(skipTimes<0 ){
                throw new NotFoundException("MyLinkedList.ListItr.nextTimes skip è negativo");
            }
            else{
                pos = pos-skipTimes;
                return  MyLinkedList.this.get(pos);
            }
        }

        @Override
        public boolean hasNext() {
            return pos<MyLinkedList.this.size();
        }

        @Override
        public E next()  {
            try{
                return get(pos++);
            } catch (NotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("MyLinkedList.ListItr.next ha fallito, sei andato oltre l'iteratore");
            }
        }



    }


}
