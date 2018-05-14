package it.unive.dais.po.myCollection;


public class ListNew<E> implements MyList<E>{

    private MyNode<E> head;
    private int size;

    /*
     * COSTRUTTORI
     */

    public ListNew(){
        head = null;
        size  = 0;
    }


    public ListNew(int capacity){
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
        MyList<E> res = new ListNew<>();
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
    public void addAll(MyCollection<? extends E> c) {
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
        return size() == 0;
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
                return pos < ListNew.this.size();
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
}
