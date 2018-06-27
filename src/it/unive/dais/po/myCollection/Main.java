package it.unive.dais.po.myCollection;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IndexNotCorrect, GenericException {

        System.out.println(" *******    COLLECTION TEST    *******");
        System.out.println();
        System.out.println();
        addAllCollection();
        System.out.println();
        System.out.println();
        System.out.println(" *******    LIST TEST    *******");
        System.out.println();
        System.out.println();
        listTest();
        System.out.println();
        System.out.println();
        System.out.println(" *******    DEQUE TEST    *******");
        System.out.println();
        System.out.println();
        dequeTest();
        System.out.println();
        System.out.println();
        System.out.println(" *******    QUEUE TEST    *******");
        System.out.println();
        System.out.println();
        queueTest();
        System.out.println();
        System.out.println();
        System.out.println(" *******    LISTITERATOR SKIP TEST    *******");
        listItaratorTest();


    }




    /*
        CREARE UNA SERIE DI FUNZIONI PER TESTARE OGNI INTERFACCIA E ITERATORE CREATO

     */
    public static void listTest() throws IndexNotCorrect {

        MyList<Integer> list = new ListNew<>();
        crescente(list, 20);
        System.out.print("Lista:");
        print(list);
        System.out.println("Elemento in posizione 5 : " + list.indexOf(5));
        System.out.println("Indice dell'ultima occorrenza di 25 : "+ list.lastIndexOf( 25));
        list.remove(5);
        System.out.print("Remove:");
        print(list);
        list.set(0,10);
        System.out.print("Set:");
        print(list);
        System.out.print("Sublist:");
        MyList<Integer> sub = list.subList(10,15);
        print(sub);
        try{
            list.remove(65);
        }
        catch (IndexNotCorrect e){
            System.out.println("Elemento in posizione 65 non esiste");
        }
        Object[] array = list.toArray();
        System.out.print("Array:[ ");
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
    }

    public static void dequeTest(){
        MyDeque<Integer> list = new MyLinkedList<>();
        for (int i = 0; i<=10; i++){
            list.addFirst(i);
        }

        for(int i = 9; i>= 0; i--){
            list.addLast(i);
        }
        print(list);
        System.out.println("Rimuovi primo elemento: " + list.removeFirst());
        System.out.println("Rimuovi ultimo elemento: " + list.removeLast());
        print(list);
        System.out.println("Primo elemento: " + list.getFirst());
        System.out.println("Ultimo elemento: " + list.getFirst());
        list.removeFirstOccurrence(9);
        System.out.print("Remove first: ");
        print(list);
        list.clear();
        System.out.print("Clear: ");
        print(list);
        for (int i = 0; i<=10; i++){
            list.push(i);
        }
        print(list);
        MyListIterator<Integer> prev = ((MyLinkedList<Integer>) list).listIterator(5);
        MyListIterator<Integer> succ = ((MyLinkedList<Integer>) list).listIterator(5);
        System.out.print("Succ: ");
        printNext(succ);
        System.out.print("Prev: ");
        printPrev(prev);

    }

    public static void queueTest(){
        MyQueue<Integer> queue = new MyLinkedList<>();
        System.out.println("Primo elemento: " + queue.peek());
        System.out.println("Primo elemento: " + queue.poll());
        try{
            queue.element();
        }
        catch(IndexNotCorrect e){
            System.out.println("Coda vuota");
        }
        try{
            queue.remove();
        }
        catch(IndexNotCorrect e){
            System.out.println("Coda vuota");
        }
        crescente(queue,10);
        System.out.println("Primo elemento: " + queue.element());
        print(queue);
        System.out.println("Primo elemento: " + queue.peek());
        System.out.println("Primo elemento: " + queue.remove());
        queue.offer(12);
        print(queue);


    }

    public static void listItaratorTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        crescente(list, 10);
        print(list);
        MyListIterator<Integer> it = list.listIterator();
        System.out.println(it.nextIndex());
        while (it.hasNext()){
            System.out.print(it.nextTimes(2) + " ");
        }
        System.out.println();
        while (it.hasPrevious()){
            System.out.print(it.prevTimes(2) + " ");
        }
    }

    public static void addAllCollection(){
        MyCollection<Integer> coll = new MyLinkedList<>();
        MyCollection<Integer> list = new MyLinkedList<>();
        crescente(coll,10);
        crescente(list, 10);
        coll.addAll(list);
        list.clear();
        System.out.println("Collezione vuota list:" + list.isEmpty());
        System.out.println("Contiene 8?" + coll.contains(8));
        coll.remove(8);
        MyIterator<Integer> it = coll.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

    public static void crescente(MyCollection<Integer> coll, int lungh){
        for (int j = 0; j < lungh; j++ ){
            coll.add(j);
        }
    }

    public static void alfabeto(MyCollection<Character> coll, int lungh){
        for (int i = 97; i < 97+lungh; i++){
            char c = (char) i;
            coll.add(c);
        }
    }

    public static void print(MyCollection<?> coll){
        MyIterator<?> it = coll.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void printNext(MyListIterator<?> iter){
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    public static void printPrev(MyListIterator<?> iter) {
        while(iter.hasPrevious()){
            System.out.print(iter.previous() + " ");
        }
        System.out.println();
    }

}
