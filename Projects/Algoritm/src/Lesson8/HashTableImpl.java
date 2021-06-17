package Lesson8;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final Item<K, V> emptyItem = new Item<>(null, null);

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    //private List<Item<K, V>> next = new ArrayList<>();// массив ссылок на следующий элемент
    //private List<K> keys = new ArrayList<>();//массив с ключами
    //int cnt = 1; // ссылка на место для вставки нового эдемента

    private final Item<K, V>[] data;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        int count = 0;
        while (data[index] != null && data[index] != emptyItem) {
            if (isKeysEqual(data[index], key)) {
                data[index].setValue(value);
                return true;
            }

            if (count >= data.length) {
                return false;
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }

        data[index] = new Item<>(key, value);
        size++;
        return true;
    }

    @Override
    public boolean add(K key, V value) {//добавление методом цепочек
        int h = hashFunc(key);

        int count = 0;


        if (data[h] == null){
            data[h] = new Item<>(key, value);
        }else {
            Item<K, V> list = data[h];
            while (list.getNext() != null && list.getKey() != key) {
                list = list.getNext();
            }
            if (list.getKey() == key){
                list.setValue(value);
            }else {
                list.setNext(new Item(key,value));
            }
            System.out.println(list.getNext());
        }

//        while (data[h] != null && data[h] != emptyItem){
//
//            if (isKeysEqual(data[h], key)){//если нашли ячейку которая по ключу совпадает//
//                data[h] = new Item<>(key, value);//
//                next.set(cnt, data[h]);
//                keys.set(cnt, key);
//                cnt++;
//                return true;
//            }
//
////            if (count>= data.length){//если нет свободных ячеек то false
////                return false;
////            }
//
//            count++;//считаем ячейки
//            h++;//проверяем каждую следующую ячейку на пустоту
//            h %= data.length;
//        }

        //data[h] = new Item<>(key, value);//когда нашли пустую ячейку добавляем туда наш ключ и значение
        size++;
        return true;

    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index != -1 ? data[index].getValue() : null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            Item<K, V> item = data[index];
            if (item == null) {
                break;
            } else if (isKeysEqual(item, key)) {
                return index;
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }

    protected int getStep(K key) {
        return 1;
    }

    private boolean isKeysEqual(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K, V> item = data[index];
        data[index] = emptyItem;

        size--;
        return item.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
            System.out.println();
        }
        System.out.println("----------");
    }
}
