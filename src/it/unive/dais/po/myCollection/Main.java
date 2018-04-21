package it.unive.dais.po.myCollection;


public class Main {

    public static void main(String[] args) throws NotFoundException {
        MyArrayList arr = new MyArrayList();
        populateCresc(arr,10);
        print(arr);
        deleteEven(arr);
        MyIterator<Integer> it = arr.iterator();
        printIter(it);
        Object[] conv;
        conv = arr.toArray();
        printArr(conv);

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
