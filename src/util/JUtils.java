package util;

import entity.ListNode;

import java.util.Arrays;
import java.util.Random;

public class JUtils {
    public static Integer[] intsToInteger(int[] array) {
        Integer[] Integers =  Arrays.stream(array).boxed().toArray(Integer[]::new);
        return Integers;
    }

    public static void showListNode(ListNode phead) {
        while(phead!=null){
            System.out.println(phead.val+" ");
            phead = phead.next;
        }
    }

    // public static void main(String[] args) {
    //     int[] array = new Random().ints().limit(10).toArray();
    //     Integer[] integers = JUtils.intsToInteger(array);
    //     System.out.println(Arrays.toString(integers));
    // }
}