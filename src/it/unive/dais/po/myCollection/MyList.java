package it.unive.dais.po.myCollection;

public interface MyList<E> extends MyCollection<E>{


    /**
     * Aggiunge l'elemento elem in posizione pos
     * @param position posizione in cui aggiugnere l'elemento
     * @param elem da aggiungere alla lista
     */
    void add (int position, E elem) throws NotFoundException;

    /**
     * Ritorna l'elemento in posizione pos
     * @param position posizione dell'elemento da ritornare
     * @return l'elemento in posizione pos
     * @throws NotFoundException eccezione in caso la posizione non sia valida, quindi se minore di 0 o maggiore della
     * dimensione
     */
    E get(int position) throws NotFoundException;

    /**
     * Ritorna l'indice del primo elemento ricercato se non lo trova ritorna -1
     * @param o elemento da cercare
     * @return -1 se non lo trova, la posizione del primo elemento nella lista;
     */
    int indexOf(Object o);

    /**
     * Ritorna l'indice dell'ultimo elemento ricercato se non lo trova ritorna -1
     * @param o elemento da cercare
     * @return -1 se non lo trova oppure la posizione dell'ultimo elemento nella lista
     */
    int lastIndexOf(Object o);

    /**
     * Rimuove l'elemento in posizione pos
     * @param position positione dell'elemento da rimuovere
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
     * Restituisce una nuova lista dalla posizione from alla posizione to
     * @param from posizione da cui partire
     * @param to posizione a cui a arrivare
     * @return ritorna la lista dalla posizione froma alla posizione to
     * @throws NotFoundException solleva un'eccezione se le posizioni non sono corrette o fuori da limiti della lista
     */
    MyList<E> subList(int from, int to) throws NotFoundException;


}
