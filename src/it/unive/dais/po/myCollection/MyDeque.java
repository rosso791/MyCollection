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
    void addFirst(E element) throws NotFoundException;

    /**
     *
     * @param element
     * @return
     */
    boolean offerFirst(E element) throws NotFoundException;  //si può eliminare

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
    E removeLast() throws NotFoundException;

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
    E getFirst() throws NotFoundException;

    /**
     *
     * @return
     */
    E getLast() throws NotFoundException;

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

    boolean removeFirstOccurence(Object o) throws NotFoundException;

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
    E pop() throws NotFoundException;



}
