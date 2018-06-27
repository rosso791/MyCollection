package it.unive.dais.po.myCollection;

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
        MyIterator<? extends E> it = c.iterator();
        while(it.hasNext()){
            add(it.next());
        }
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
    public void add (int pos, E elem ) {
        if (pos < 0 || pos > size()){
            throw new IndexNotCorrect( "MyLinkedList.add la posizione" + pos + " non esiste");
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
    public E get(int position){
        if (position < 0 || position >= size())
            throw new IndexNotCorrect("MyNodeList.getAt(): cannot get element at position " + position);
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
    public void remove(int position){
        if (position <0 || position > size()){
            throw new IndexNotCorrect("MyLinkedList.remove la posizione" + position + " non esiste");
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
    public E set(int position, E element) {
        if (position < 0 || position >= size())
            throw new IndexNotCorrect("MyNodeList.getAt(): cannot get element at position " + position);
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
    public MyList<E> subList(int from, int to){
        if (from < 0 || from >= size()){
            throw new IndexNotCorrect("MyList.subList from value" + from +  "not valid");
        }
        if(to<0 || to >= size()){
            throw new IndexNotCorrect("MyList.subList to value" + to +  "not valid");
        }
        if (from> to){
            throw new IndexNotCorrect("MyList.subList from value major of" + to +  "value");
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
     public E element() {
         if (size() == 0){
             throw new IndexNotCorrect("MyLinkedList.element coda vuota");
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
    public E remove()  {
        if (size() == 0){
            throw new IndexNotCorrect("MYLinkedList.element coda vuota");
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
            if (hasNext()){
                return get(pos++);
            }
            else{
                throw  new IndexNotCorrect("MyIterator.next ha fallito");
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
    public E removeFirst(){
        if (size() == 0){
            throw new IndexNotCorrect("MyLinkedList.removeFirst la lista è vuota");
        }
        else{
            E res = head.getInfo();
            remove(0);
            return res;
        }
    }

    @Override
    public E removeLast(){
        if (size() == 0){
            throw new IndexNotCorrect("MyLinkedList.removelast size is 0");
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
    public E getFirst(){
        if (size() == 0){
            throw new IndexNotCorrect("MyLinkedList.getFirst  length is 0");
        }
        else{
            return get(0);
        }
    }

    @Override
    public E getLast(){
        if (size() == 0){
            throw new IndexNotCorrect("MyLinkedList.getLast  length is 0");
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
    public boolean removeFirstOccurrence(Object o) {
        if(size() == 0) {
            return false;
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
    public E pop(){
        if (size() == 0){
            throw new IndexNotCorrect("MyList.pop size = 0");
        }
        else{
            return removeFirst();
        }

    }


    /*

        IMPLEMENTAZIONE METODI MYLISTITERATOR

     */



    public MyListIterator<E> listIterator(){
        return new ListItr<>(this);
    }

    public MyListIterator<E> listIterator(int from) {
        if (from < 0 || from >= size()){
            throw new IndexNotCorrect("MyListIterator.listIterator from non valido");
        }
        return  new ListItr<>(from, this);
    }

    private static class ListItr<E> implements MyListIterator<E>{
        private int pos;
        private MyLinkedList<E> enclosing;
        public ListItr(int from, MyLinkedList<E> enclosing){
            pos = from;
            this.enclosing = enclosing;
        }

        public ListItr(MyLinkedList<E> enclosing){
            this.pos = 0;
            this.enclosing = enclosing;
        }


        @Override
        public void add( E element){
           try{
               int i = pos;
               enclosing.add(i,element);
           }
           catch(IndexNotCorrect e){
               System.out.print("Indice non esistente");
           }

        }

        @Override
        public boolean hasPrevious() {
            return pos >= 0;
        }

        @Override
        public int nextIndex() {
            if (pos > enclosing.size()){
                return enclosing.size();
            }
            else{
                return pos+ 1;
            }
        }

        @Override
        public E previous(){
            if (hasPrevious()){
                return enclosing.get(pos--);
            }
            else{
                throw new IndexNotCorrect("MyListIterator.previous iteratore terminato");
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
        public boolean hasNextTimes(int skip) {
            return pos + skip < enclosing.size();
        }

        @Override
        public boolean hasPrevTimes(int skip) {
            return pos - skip >= 0;
        }


        @Override
        public E nextTimes(int skip) throws IndexNotCorrect {
            if (hasNext()){
                E elem = enclosing.get(pos);
                pos = pos+skip;
                return elem;
            }
            else{
                throw new IndexNotCorrect("MyListIterator.previous iteratore terminato");
            }

        }

        @Override
        public E prevTimes(int skipTimes) throws IndexNotCorrect {
            if (hasPrevious()){
                if (pos == enclosing.size()){
                    pos = pos-1;
                }
                E elem = enclosing.get(pos);
                pos = pos-skipTimes;
                return elem;

            }
            else{
                throw new IndexNotCorrect("MyListIterator.previous iteratore terminato");
            }
        }

        @Override
        public boolean hasNext() {
            return pos < enclosing.size();
        }

        @Override
        public E next() throws IndexNotCorrect {
            if (hasNext()){
                return enclosing.get(pos++);
            }
            else{
                throw new IndexNotCorrect("MyListIterator.previous iteratore terminato");
            }
        }



    }


}
