package Lesson5.HW;

import java.util.Objects;

public class Item {
    private String name;
    private int weght;
    private int cost;

    public Item(String name, int weght, int cost) {
        this.name = name;
        this.weght = weght;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weght == item.weght && cost == item.cost && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weght, cost);
    }

    public String getName() {
        return name;
    }

    public int getWeght() {
        return weght;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Предмет {" +
                "'" + name + '\'' +
                ", вес = " + weght +
                ", стоимость = " + cost +
                "}\n";
    }
}
