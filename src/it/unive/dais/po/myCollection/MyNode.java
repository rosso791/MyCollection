package it.unive.dais.po.myCollection;

public class MyNode<T> {

    /**
     * info contiene il dato del nodo.
     * next contiene il collegamento al nodo successivo.
     */

    public T info;
    public MyNode<T> next;


    /**
     * @param info contiene il dato del nodo.
     * @param next contiene il collegamento al nodo successivo.
     */
    public MyNode(T info, MyNode<T> next){
        this.info = info;
        this.next = next;
    }

    /**
     * Metodo che restituisce il campo info del nodo
     * @return info di tipo generico
     */
    public T getInfo(){
        return info;
    }

    /**
     * Metodo che restituisce il nodo successivo
     * @return next restituisce il campo next del nodo
     */
    public MyNode<T> getNext(){
        return next;
    }

    /**
     * Metodo che collega il nodo passato come paramentro al successivo
     * @param next collega il nodo next al nodo successivo
     */
    public void setNext(MyNode<T> next){
        this.next = next;
    }

    /**
     * Restituisce il campo info del nodo.
     * @param info
     */
    public void setInfo(T info){
        this.info = info;
    }
}
