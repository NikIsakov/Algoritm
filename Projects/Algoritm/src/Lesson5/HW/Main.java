package Lesson5.HW;

import java.util.*;

public class Main { // вторая задача
    private static List<Item> bestItems;
    private static int cost;
    private static Map<Integer, List<Item>> bestCost = new HashMap<>();

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга",1,600));
        items.add(new Item("Бинокль",2,5000));
        items.add(new Item("Аптечка",4,1500));
        items.add(new Item("Ноутбук",2,40000));
        items.add(new Item("Котелок",1,500));

        extracted(items);

        System.out.println("Лучшая максимальная цена: "+
                        Collections.max(bestCost.keySet())+"\n"+"\n"+
                bestCost.get(Collections.max(bestCost.keySet()))
                );

    }

    private static void extracted(List<Item> items) {
        Backpack backpack = new Backpack(5);

        if (items.isEmpty()) {
            return;
        }
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.getWeght();
        }

        int sumCost = 0;
        for (Item item : items) {
            sumCost += item.getCost();
        }

        //System.out.println("Вес предметов: "+sumWeight);
        //System.out.println("Цена предметов: "+sumCost);

        if (sumWeight<= backpack.getWeght()){
            //System.out.println("ОК - в рюкзак влезает");
            bestItems = items;
            //System.out.println(bestItems.toString());
            cost = sumCost;

            bestCost.put(cost, bestItems);

        } else{
            //System.out.println("No ok");
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            //System.out.println("-------------------------------");
            extracted(copiedItems);
        }

    }
}
