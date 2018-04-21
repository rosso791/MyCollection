package it.unive.dais.po.myCollection;

public interface MyIterable<E>  {

    /**
     * Restituisce un iteratore che permette di esaminare in sequenza tutti gli elementi della collezione corrente
     * @return restituisce un iteratore che permette di esaminare in sequenza tutti gli elementi della collezione corrente
     */
    MyIterator<E> iterator();
}
