package it.unive.dais.po.myCollection;

public interface MyIterator<E> {

    /**
     * Metodo per controllare se l'iteratore ha un elemento successivo
     * @return true se c'è un altro elemento false altrimenti
     */
    boolean hasNext();

    /**
     * Restituisce l'elemento successivo e fa avanzare di un passo il cursore
     * @return restituisce l'elemento successivo
     */
    E next() throws IndexNotCorrect;

}
