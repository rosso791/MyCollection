package it.unive.dais.po.myCollection;

public interface MyListIterator<E> extends  MyIterator<E>{


    void add(int position, E element) throws NotFoundException;

    boolean hasPrevious();

    int nextIndex();

    E previous() throws NotFoundException;

    int previousIndex();

    //void remove();  forse da aggiugnere bisogna valutare come farlo se chiamarlo removePrev, removeNext, o farlo come
    // l'interfaccia reale. Se faccio con remove removePrev e removeNext è possibile creare un metodo remove con indice,
    //precedente e successivo

    void set (E e) throws GenericException, NotFoundException;

    E nextTimes(int skip) throws NotFoundException;

    E prevTimes(int skipTimes) throws NotFoundException;


}
