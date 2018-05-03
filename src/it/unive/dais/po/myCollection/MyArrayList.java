package it.unive.dais.po.myCollection;


public class MyArrayList<E> implements MyList<E>{

    private MyNode<E> head;
    private int size;

    /*
     * COSTRUTTORI
     */

    public MyArrayList(){
        head = null;
        size  = 0;
    }


    public MyArrayList(int capacity){
        while(capacity>0){
            add(null);
            capacity--;
        }
    }


    /*
     *IMPLEMENTAZIONE METODI MYLIST
     */


    @Override
    public void add(int position, E element) throws NotFoundException {
        if (position < 0 || position > size()) {
            throw new NotFoundException("MyNodeList.insertAt(): cannot insert at position " + position);
        }
        if (position==0){
            head = new MyNode<>(element, head);
        }
        else{
            MyNode<E> app = head;
            while(position > 1){
                position--;
                app = app.getNext();
            }
            app.setNext(new MyNode<>(element, app.getNext()));
        }
        size++;
    }



    @Override
    public E get(int position) throws NotFoundException {
        if (position < 0 || position >= size())
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        if (position == 0)
            return head.getInfo();
        else {
            MyNode<E> n = head;
            while (position-- > 1) {
                n = n.getNext();
            }
            return n.getNext().getInfo();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int pos = -1;
        MyNode<E> app = head;
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
        int conta = 0;
        MyNode<E> app = head;
        while(app.getNext() != null){
            if(o.equals(app.getInfo())){
                return conta;
            }
            app = app.getNext();
            conta++;
        }
        return -1;
    }


    @Override
    public void remove(int position) throws NotFoundException {
        if (position < 0 || position >= size()) {
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        }
        if (position == 0){
            head = head.getNext();

        }
        else{
            MyNode<E> n = head;
            while(position>1){
                position--;
                n=n.getNext();
            }
            n.setNext(n.getNext().getNext());
        }
        size--;
    }

    @Override
    public E set(int position, E element) throws NotFoundException {
        if (position < 0 || position >= size())
            throw new NotFoundException("MyNodeList.getAt(): cannot get element at position " + position);
        E ret;
        if (position == 0){
            ret = head.getInfo();
            head.setInfo(element);
        }
        else{
            MyNode<E> app = head;
            while(position > 0){
                position--;
                app = app.getNext();
            }
            ret = app.getInfo();
            app.setInfo(element);
        }
        return ret;
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
        MyList<E> res = new MyArrayList<>();
        MyNode<E> app = head;
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
     *IMPLEMENTAZIONE METODI MYCOLLECTION
     */


    @Override
    public boolean add(E element){
        boolean add = false;
        MyNode<E> nuovo = new MyNode<>(element,null);
        if (head == null){
            head = nuovo;
        }
        else{
            MyNode<E> h = head;
            while(h.getNext() != null){
                h = h.getNext();
            }
            h.setNext(nuovo);
            add = true;
        }
        size++;
        return add;
    }

    @Override
    public boolean add_All(MyCollection<? extends E> c) {
        /*
            ? extends E, dichiaro una MyCollection il cui tipo può essere un tipo arbitrario che deve essere combatibile con E.
            Più correttamente ho utilizzato un segnaposto vincolato in quando E deve essere il vincolo superiore sul tipo che ci si aspetta,
            qualunque sia il tipo ottenuto deve essere almeno un E. Più precisamente per esempio:
            Collection<Number> a = new ArrayList<>();
            Collection<Integer>  b = new ArrayList<>();
            a.addAll(b);
            Number è quindi il vincolo superiore per il tipo che ci si aspetta.
         */

        MyIterator<? extends E> it = c.iterator();
        while(it.hasNext()){
            add(it.next());
        }
        return true;
    }




    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<E> app = head;
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
        if (size() == 0) return  true;
        else return false;
    }

    @Override
    public boolean remove(Object o) {
        MyNode<E> app = head;
        for(int i= 0; i<size(); i++){
            if (app.getInfo().equals(o)){
                app.setNext(app.getNext().getNext());
                return true;
            }
            app= app.getNext();
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size()];
        MyNode<E> app = head;
        for (int i = 0;i<size(); i++){
            res[i] = app.getInfo();
            app = app.getNext();
        }
        return res;
    }

    /*
     *IMPLEMENTAZIONE METODI MYITERABLE
     */
    public MyIterator<E> iterator(){
        return new MyIterator<>(){
            private int pos = 0;

            @Override
            public boolean hasNext() {
                if(pos < MyArrayList.this.size()){
                    return true;
                }
                else
                    return false;
            }

            @Override
            public E next() {
                try{

                    return get(pos++);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("iterator.next() failed");
                }
            }


        };
    }



    /*
     * IMPLEMENTAZIONE METODI ARRAYLIST
     */

    /**
     * Aumenta la dimensione dell'arraylist della dimensione minCapacity
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity){
        for (int i = 0; i<minCapacity;i++){
            add(null);
        }
    }


    /**
     * Rimuove dalla lista gli elementi da fromIndex a toIndex
     * @param fromIndex elemento da cui partire a eliminare
     * @param toIndex elemento fino a cui eliminare
     * @throws NotFoundException controllo che fromIndex e toIndex siano all'interno della dimensione dell'arrayList
     */
    public void removeRange (int fromIndex, int toIndex) throws  NotFoundException{
        if (fromIndex < 0 || fromIndex >= size() ){
            throw new NotFoundException("MyNodeList.removeRange(): cannot get element at position " +fromIndex);
        }
        if (toIndex < 0 || toIndex >= size() || toIndex<fromIndex){
            throw new NotFoundException("MyNodeList.removeRange(): cannot get element at position " +toIndex);
        }
        MyNode<E> app = head;
        for(int i = 0; i<fromIndex-1; i++){
            app = app.getNext();
        }
        for(int i = fromIndex; i<=toIndex;i++){
            app.setNext(app.getNext().getNext());
            size--;
        }
    }
}
