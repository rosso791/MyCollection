package it.unive.dais.po.myCollection;

public class MyDLNode<T> {

    public T info;
    public MyDLNode<T> prev;
    public MyDLNode<T> next;

    public MyDLNode(MyDLNode<T> prev,T info, MyDLNode<T> next ){
        this. prev = prev;
        this.info = info;
        this.next = next;
    }

    public MyDLNode(){
        info = null;
        prev = null;
        next = null;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(MyDLNode<T> next) {
        this.next = next;
    }

    public void setPrev(MyDLNode<T> prev) {
        this.prev = prev;
    }

    public MyDLNode<T> getNext() {
        return next;
    }

    public MyDLNode<T> getPrev() {
        return prev;
    }

    public T getInfo() {
        return info;
    }
}
