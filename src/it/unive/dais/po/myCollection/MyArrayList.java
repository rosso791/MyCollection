package it.unive.dais.po.myCollection;


public class MyArrayList<E> implements MyList<E>{

    private MyNode<E> head;
    int size;

    /*
     * COSTRUTTORI
     */

    public MyArrayList(){
        head = null;
        size  = 0;
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
            head = new MyNode<E>(element, head);
        }
        else{
            MyNode<E> app = head;
            while(position > 1){
                position--;
                app = app.getNext();
            }
            app.setNext(new MyNode<E>(element, app.getNext()));
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
    public int indexOf(Object o) {
        int conta = 0;
        MyNode<E> app = head;
        while(app.getNext() != null){
            if(o.equals(app.getInfo()) == true){
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



    /*
     *IMPLEMENTAZIONE METODI MYCOLLECTION
     */


    @Override
    public void add(E element){
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
        }
        size++;
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
            if(o.equals(app.getInfo())== true){
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
    public void remove(Object o) throws NotFoundException {
        MyNode<E> app = head;
        for(int i= 0; i<size(); i++){
            if (app.getInfo().equals(o)){
                remove(i);
            }
            app= app.getNext();
        }
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
        return new MyIterator<E>(){
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
}
