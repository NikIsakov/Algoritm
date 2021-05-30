package Lesson3.HW;

import Lesson3.dack.DackQueueImpl;
import Lesson3.stack.Stack;
import Lesson3.stack.StackImpl;

public class HW3 {
    public static void main(String[] args) {

        /*
        Второе задание
         */
        String str = "qwerty";
        new HW3().turn(str);

        /*
        Третье задание - тест
         */
        testDeckQueue();

    }

    private void turn(String str) {
        Stack<Character> stack = new StackImpl<>(str.length());

        for (int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            stack.push(currentChar);
        }

        System.out.print("Массив введеной строки: "); stack.display();

        for (int i = 0; i < str.length(); i++) {
            Character lastOpened =  stack.pop();
            System.out.print(lastOpened);
        }
    }

    private static void testDeckQueue(){
        DackQueueImpl dackQueue = new DackQueueImpl(5);
        System.out.println(dackQueue.insertLeft(3));
        System.out.println(dackQueue.insertLeft(5));
        System.out.println(dackQueue.insertLeft(1));
        System.out.println(dackQueue.insertLeft(2));
        System.out.println(dackQueue.insertLeft(6));
        System.out.println(dackQueue.insertLeft(4));

        System.out.println("dackQueue peek: " + dackQueue.peekFront());
        System.out.println("dackQueue size: " + dackQueue.size());
        System.out.println("dackQueue is full: " + dackQueue.isFull());
        dackQueue.display();

        while (!dackQueue.isEmpty()) {
            System.out.println(dackQueue.removeRight());
        }
    }
}
