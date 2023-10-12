package Session4;

import java.util.ArrayList;
import java.util.List;

public class lista1 {
    public static void main(String[] args){
        // List 1
        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(4);
        myList.add(6);

        // Reemplazar lo que hay en la posición x  por el elemento y
        myList.set(1,40);

        System.out.println("Tamaño de la lista: " + myList.size());
        for (int i=0; i<myList.size(); i++){
            System.out.println(myList.get(i));
        }

        // List 2
        ArrayList<String> names = new ArrayList<>();
        // Añadir elementos a la lista
        names.add("Felipe");
        names.add("Carlos");
        names.add("María");

        // Obtener un elemento
        names.get(0);

        // Obtener el tamaño
        int size = names.size();

        // Remover un elemento
        names.remove(1);
        int size2 = names.size();

        // Obtener el índice de un elemento
        int index= names.indexOf("María");
        names.get(index);
    }
}
