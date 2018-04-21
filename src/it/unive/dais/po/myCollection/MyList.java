package it.unive.dais.po.myCollection;

public interface MyList<E> extends MyCollection<E>{


    /**
     * Aggiunge l'elemento elem in posizione pos
     * @param position
     * @param elem
     */
    void add (int position, E elem) throws NotFoundException;

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



}
