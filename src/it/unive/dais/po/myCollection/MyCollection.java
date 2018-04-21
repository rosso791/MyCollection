package it.unive.dais.po.myCollection;

public interface MyCollection<E> extends MyIterable<E>  {

    /**
     * Aggiunge l'elemento alla collezione
     * @param elem elemento da aggiungere alla collezione
     */
    void add(E elem);

    /**
     * Elimina tutti gli elementi dalla collezione
     */
    void clear();

    /**
     * Restituisce true se la collezione corrente contiene l'oggetto elem.
     * @param o paramentro da controllare
     * @return true se l'oggetto è contenuto false altrimenti
     */
    boolean contains(Object o);

    /**
     * Controlla se la collezione è vuota o meno
     * @return true se la collezione è vuota false se ha almeno un elemento
     */
    boolean isEmpty();

    /**
     * Rimuove dalla collezione l'elemento o.
     * @param o elemento da rimuovere
     * @throws NotFoundException
     */
    void remove(Object o) throws NotFoundException;


    /**
     * Restituisce le dimensioni della collezione corrente, cioè il numero degli elementi che contiene
     * @return un intero corrispondente al numero degli elementi della collezione
     */
    int size();

    /**
     * Ritorna un array contenente tutti gli elementi della collezione
     * @return un arrauy contentente tutti gli elementi della collezione
     */
    Object[] toArray();
}
