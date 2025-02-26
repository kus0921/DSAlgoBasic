import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Item {
    String name;
    int quantity;
    BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

public class Java8Grouping {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item("apple", 5, new BigDecimal(5)),
            new Item("apple", 20, new BigDecimal(20)),
            new Item("apple", 1, new BigDecimal(1)),
            new Item("banana", 10, new BigDecimal(10)),
            new Item("banana", 20, new BigDecimal(20)),
            new Item("orange", 60, new BigDecimal(60)),
            new Item("orange", 20, new BigDecimal(20))
        );

        // Group by item name, sum quantity, and sum total price
//       Map<String,int[]> itemTotalPriceMap = items.stream()
//               .collect(Collectors.groupingBy(Item::getName,
//              Collectors.reducing(new int[]{0,0},
//                      item->new int[]{item.getQuantity(),item.getQuantity()*item.getPrice().intValue()},
//                      (a,b)->new int[]{a[0]+b[0],a[1]+b[1]})));
//    itemTotalPriceMap.entrySet().forEach(stringEntry -> System.out.println(stringEntry.getKey()+":"+stringEntry.getValue()[0]+":"+stringEntry.getValue()[1]));

//        Map<String,Integer> itemQuantityMap = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQuantity)));
//        Map<String, Integer> itemTotalPriceMap = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(item->item.getQuantity()*item.getPrice().intValue())));
//
//        itemQuantityMap.entrySet().forEach(stringIntegerEntry -> System.out.println(
//                stringIntegerEntry.getKey()+":"+stringIntegerEntry.getValue()+":"+itemTotalPriceMap.get(stringIntegerEntry.getKey())));
//
List<Integer> list =Arrays.asList(2,2);// Arrays.asList(2, 1, 4, 3, 9, 8, 7, 6);
Integer secondLargest=list.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1).findFirst().orElse(null);
        System.out.println(secondLargest);


    }
}










/*
 Map<String, int[]> result = items.stream()
            .collect(Collectors.groupingBy(Item::getName,
                Collectors.reducing(new int[]{0, 0}, // Initial {quantitySum, priceSum}
                    item -> new int[]{item.getQuantity(), item.getQuantity() * item.getPrice().intValue()},
                    (a, b) -> new int[]{a[0] + b[0], a[1] + b[1]}
                )
            ));

        // Sort by quantity in descending order
        result.entrySet().stream()
            .sorted((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
            .forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1])
            );
 */





