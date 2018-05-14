package it.unive.dais.po.myCollection;

import java.util.NoSuchElementException;

public interface MyQueue<E> extends MyCollection<E> {

    /**
     * Restituisce ma non elimina l'elemento che si trova in testa alla coda. Se la coda è vuota solleva l'eccezione NoSuchElementException
     * @return  l'elemento in testa alla coda
     * @throws NoSuchElementException solleva un'eccezione se la coda è vuota
     */
    E element() throws NoSuchElementException;


    /**
     * Restituisce, ma non elemina, l'oggetto che si trova in testa alla coda. Se la coda è vuota resistuisce null.
     * @return restituisce senza eliminare l'oggetto in testa, se la coda è vuota resistuisce null.
     */
    E peek();

    /**
     * Restituisce e elimina l'elemento che si trova in testa alla coda. Se la coda è vuota solleva NoSuchElementException
     * @return Restituisce e elimina l'elemento che si trova in testa alla coda. Se la coda è vuota solleva NoSuchElementException
     * @throws NoSuchElementException se la coda è vuota solleva un'eccezione
     */
    E remove() throws NoSuchElementException;

    /**
     * Restituisce ed elimina l'oggetto che si trova in testa alla coda. Se la coda è vuota restituisce null.
     * @return Restituisce ed elimina l'oggetto che si trova in testa alla coda. Se la coda è vuota restituisce null.
     */
    E poll();

    /**
     * Tenta di inserire l'elemento assegnato all'interno della coda. Se tale tentativo ha esito positivo, viene restituito true,
     * altrimenti false. Per le code che hanno una capacità finita questo metodo è preferibile ad add della collection.
     * @param elem elemento da aggiungere
     * @return true se l'elemento è stato aggiunto, false se l'elemento non è stato aggiunto
     */
    boolean offer(E elem);

}
