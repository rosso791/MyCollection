package it.unive.dais.po.myCollection;

public class Main {

    public static void main(String[] args) throws NotFoundException {
        MyArrayList<Integer> app = new MyArrayList<>();
        for (int i = 0; i<10; i++){
            app.add(i,i);
        }
        for (int i=0;i<app.size();i++){
            System.out.print(app.get(i) + " ");
        }
        System.out.println();
        app.remove(9);
        Integer set = app.set(2, 10);
        for (int i=0;i<app.size();i++){
            System.out.print(app.get(i)+ " ");
        }
        System.out.println();
        System.out.println(app.contains(5));
        int a = app.indexOf(1);
        System.out.println(a);
        a = app.indexOf(15);
        System.out.println(a);
    }


}
