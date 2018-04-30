package it.unive.dais.po.myCollection;

public interface MyDeque<E> extends  MyQueue<E> {

    /**
     *
     * @param element
     */
    void addLast(E element);

    /**
     *
     * @param element
     */
    void addFirst(E element) ;

    /**
     *
     * @param element
     * @return
     */
    boolean offerFirst(E element) ;  //si può eliminare

    /**
     *
     * @param element
     * @return
     */
    boolean offerLast (E element); //si può eliminare

    /**
     *
     * @return
     */

    /**
     *
     * @return
     */
    E removeFirst();

    /**
     *
     * @return
     */
    E removeLast();

    /**
     *
     * @return
     */
    E pollFirst();

    /**
     *
     * @return
     */
    E pollLast();

    /**
     *
     * @return
     */
    E getFirst();

    /**
     *
     * @return
     */
    E getLast();

    /**
     *
     * @return
     */
    E peekFirst();

    /**
     *
     * @return
     */
    E peekLast();

    //boolean removeFirstOccurence(Object o);

    //boolean removeLastOccurence(Object o);

    /**
     *
     * @param element
     */
    void push(E element);

    /**
     *
     * @return
     */
    E pop();



}
