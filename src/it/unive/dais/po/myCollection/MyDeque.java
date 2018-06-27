package it.unive.dais.po.myCollection;

public interface MyDeque<E> extends  MyQueue<E> {

    /**
     * Inserisce l'elemento al termine della MyDeque
     * @param element elemento da aggiungere
     */
    void addLast(E element);

    /**
     * Inserisce l'elemento all'inizio della MyDeque
     * @param element elemento da aggiugnere
     */
    void addFirst(E element) ;


    /**
     * Rimuove il primo elemento dalla MyDeque
     * @return ritorna l'elemento che è stato rimosso, se è vuota solleva un'eccezione
     */
    E removeFirst();

    /**
     * Rimuove l'elemento in fondo alla MyDeque
     * @return ritorna l'ultimo elemento, quello che è stato rimosso, se è vuota solleva un'eccezione
     * @throws IndexNotCorrect solleva un'eccezione se la lista è già vuota
     */
    E removeLast();

    /**
     * Restituisce e rimuove il primo elemento della MyDeque
     * @return ritorna il primo elemento della MyDeque, se la lista è vuota allora ritorna null
     */
    E pollFirst();

    /**
     * Restituisce e rimuove l'ultimo elemento della MyDeque
     * @return ritorna l'ultimo elemento della MyDeque, se la lista è vuota ritorna null
     */
    E pollLast();

    /**
     * Restituisce il primo elemento della MyDeque, ma non lo rimuove
     * @return il primo elemento della MyDeque, se è vuota solleva un'eccezione
     * @throws IndexNotCorrect  solleva un'eccezione se la lista è vuota
     */
    E getFirst();

    /**
     * Restituisce l'ultimo elemento della MyDeque, ma non lo rimuove
     * @return restiuisce l'ultimo elemento della MyDeque, se è vuota solleva un'eccezione
     * @throws IndexNotCorrect solleva un'eccezione se la lista è vuota
     */
    E getLast();

    /**
     * Restituisce il primo elemento della MyDeque, ma non lo rimuove
     * @return il primo elemento della MyDeque, se è vuota restituisce null
     */
    E peekFirst();

    /**
     * Restituisce l'ultimo elemento della MyDeque, ma non lo rimuove
     * @return restiuisce l'ultimo elemento della MyDeque, se è vuota restituisce null
     */
    E peekLast();

    /**
     * Rimuove la prima occorrenza dell'elemento o
     * @param o elemento da cercare e rimuovere
     * @return true se lo ha trovato e lo ha rimosso, false se l'elemento non è presente, quindi anche se la lista è vuota

     */
    boolean removeFirstOccurrence(Object o);

    //boolean removeLastOccurence(Object o);

    /**
     * Inserisce in testa alla MyDeque l'elemento element. Funziona come uno stack, quindi in modalità FIFO
     * @param element elemento da inserire nello stack
     */
    void push(E element);

    /**
     * Ritorna e rimuove la testa della MyDeque. Funziona come uno stack, quindi in modalità FIFO
     * @return l'elemento rimosso
     * @throws IndexNotCorrect solleva un'eccezione se lo stack è vuoto
     */
    E pop();



}
