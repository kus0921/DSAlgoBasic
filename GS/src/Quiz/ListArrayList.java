package Quiz;

import java.util.*;

public class ListArrayList {
    public static void main(String[] args) {


        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add(7);
//        for (String s : list)
//            System.out.print(s);

        //HashSet<Number> hs = new HashSet<Integer>();
         HashSet<? super ClassCastException> set = new HashSet<Exception>();
        List<String> list1 = new Vector<String>();
       // List<Object> values = new HashSet<Object>();
       //  List<Object> objects = new ArrayList<? extends Object>();

         Map<String, ? extends Number> hm = new HashMap<String, Integer>();

         TreeSet<String> treeSet =  new TreeSet<>();
        Map<String, Double> map = new HashMap<>();
//        map.add("pi", 3.14159);
//        map.add("e", 2L);
//        map.add("log(1)", new Double(0.0));
//        map.add('x', new Double(123.4));

        map.put("pi", 3.14159);
       // map.put("e", 2L);
        //map.put("log(1)", new Double(0.0));
        //map.put('x', new Double(123.4));

//        Map<Integer, Integer> map = new HashMap<>(10);
//         for (int i = 1; i <= 10; i++) {
//         map.put(i, i * i);
//         }
//        System.out.println(map.get(4));


        //Which one will not compile
        List<?> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList();
        //List<? super Object> l3 = new ArrayList<String>();
        List<? extends Object> l4 = new ArrayList<String>();


        //Which one will generate error
        List<? super Number> list3 = new ArrayList<Object>(); // 1
        list3.add(Integer.valueOf(2)); // 2
        //list3.add(new Object()); // 3
        // A b = (String s) -> 1;
       // A a = a -> a.length();
      // A x = y -> {return y;};
      // A s = "2" -> Integer.parseInt(s);


    }


    interface A {
        int aMethod(String s);
    }
}