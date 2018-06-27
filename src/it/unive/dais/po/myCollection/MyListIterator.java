package it.unive.dais.po.myCollection;

public interface MyListIterator<E> extends  MyIterator<E>{


    void add(E element) throws IndexNotCorrect;

    boolean hasPrevious();

    int nextIndex();

    E previous() throws IndexNotCorrect;

    int previousIndex();

    boolean hasNextTimes(int skip);

    boolean hasPrevTimes(int skip);

    E nextTimes(int skip) throws IndexNotCorrect;

    E prevTimes(int skipTimes) throws IndexNotCorrect;


}
