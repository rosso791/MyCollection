package it.unive.dais.po.myCollection;


import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws NotFoundException {
        /*
        MyDeque<Integer> deque = new MyLinkedList<>();
        for(int i =  0 ;i<4; i++){
           deque.addLast(i);
        }
        for (int i = 0; i<deque.size(); i++){
           System.out.print(((MyLinkedList<Integer>) deque).get(i)+" ") ;
        }
        System.out.println(deque.removeFirstOccurence(2));

        System.out.println(deque.peekLast());
        for (int i = 0; i<deque.size(); i++){
            System.out.print(((MyLinkedList<Integer>) deque).get(i)+" ");
        }
        */
        MyCollection<Integer> a = new MyArrayList<>();
        for (int i = 0; i<10;i++){
            a.add(i);
        }
        MyCollection<Integer> b = new MyArrayList<>();
        for (int i = 10; i<20;i++){
            a.add(i);
        }
        a.add_All(b);
        MyIterator<Integer> c = a.iterator();
        while(c.hasNext()){
            System.out.println(c.next());
        }
    }



    public static void populateCresc (MyCollection<Integer> a,  int n){
        for (int i = 0; i<n; i++){
            a.add(i);
        }
    }

    public static void deleteEven(MyList<Integer> a) throws NotFoundException {
        for(int i = 0; i<a.size();i++){
            if(a.get(i) % 2 == 0){
                a.remove(i);
            }
        }
    }

    public static void print (MyList<Integer> a) throws NotFoundException {
        for (int i = 0; i<a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public static void printIter(MyIterator<Integer> it){
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void printArr(Object[] a){
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

}
