package it.unive.dais.po.myCollection;

public interface MyList<E> {

    /**
     * Aggiunge un elemento alla fine della lista
     * @param elem
     */
    void add (E elem);

    /**
     * Aggiunge l'elemento elem in posizione pos
     * @param position
     * @param elem
     */
    void add (int position, E elem) throws NotFoundException;

    /**
     * Controlla se l'oggetto è contenuto all'interno della lista
     * @param o paramentro da controllare
     * @return true se l'oggetto è contenuto false altrimenti
     */
    boolean contains(Object o);


    /**
     * Ritorna l'elemento in posizione pos
     * @param position
     * @return l'elemento in posizione pos
     */
    E get(int position) throws NotFoundException;

    /**
     * Ritorna l'indice del primo elemento ricercato se non lo trova ritorna -1
     * @param o elemento da cercare
     * @return -1 se non lo trova, la posizione del primo elemento nella lista;
     */
    int indexOf(Object o);

    /**
     * Controlla se la lista è vuota o meno
     * @return true se la lista è vuota false se ha almeno un elemento
     */
    boolean isEmpty();

    /**
     * Rimuove l'elemento in posizione pos
     * @param position
     *
     */
    void remove (int position) throws NotFoundException;

    /**
     * Sostituisce l'elemento in posizione position con l'elemento element
     * @param position posizione dell'elemento da sostituire
     * @param element elemento da sostituire
     * @return l'elemento sostituito
     */
    E set(int position, E element) throws NotFoundException;

    /**
     * Ritorna la lunghezza della lista
     * @return un intero corrispondente alla lunghezza della lista
     */
    int size();


}
