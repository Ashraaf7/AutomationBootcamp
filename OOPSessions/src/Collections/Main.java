package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Set >> unique - unordered
       /* Set<Integer> set = new HashSet<>();
        //1 2 3 4 5 6 7 8 9
        set.add(1);
        set.add(1);
        for (int i : set)
        {
            System.out.println(i);
        }*/

        /*//List >> duplicated - ordered
        List<Integer> list = new ArrayList<>(5);
        list.add(0,1); //1
        list.add(1,2); //2
        list.add(2,3); //3
        list.add(3,10); //4
        list.add(1);
        for (int i : list)
        {
            System.out.println(i);
        }*/

       /* //ArrayList > duplicated - ordered - random access fast - modify frequently
        ArrayList<Integer> arrayList= new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(7);
        arrayList.add(5);
        System.out.println(arrayList.contains(5));*/

        HashMap <String,Integer> hashMap = new HashMap<>();
        hashMap.put("numberOfEmp" , 100);
        hashMap.put("numberOfData",5000);
        System.out.println(hashMap.get("numberOfEmp"));

    }

}
