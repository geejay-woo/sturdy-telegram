package ctci.chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution3_7 {



    @Test
    public void test(){

        new ArrayList<int[]>();
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0,1});
        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
        animalShelf.enqueue(new int[]{1,0});
        System.out.println(Arrays.toString(animalShelf.dequeueCat()));
        animalShelf.enqueue(new int[]{2,1});
        System.out.println(Arrays.toString(animalShelf.dequeueCat()));
        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
    }
    private class AnimalShelf {

        private LinkedList<int[]> catList;
        private LinkedList<int[]> dogList;
        private int timeStamp;

        public AnimalShelf() {
            catList = new LinkedList<>();
            dogList = new LinkedList<>();
            timeStamp = 0;
        }

        public void enqueue(int[] animal) {
            int kind = animal[1];
            animal[1] = timeStamp++;
            if(kind==0) {
                catList.offer(animal);
            } else {
                dogList.offer(animal);
            }
        }

        public int[] dequeueAny() {
            if(dogList.isEmpty()&&catList.isEmpty()) return new int[]{-1,-1};
            if(dogList.isEmpty()) {
                int[] catArr = catList.poll();
                catArr[1] = 0;
                return catArr;
            }
            if(catList.isEmpty()) {
                int[] dogArr = dogList.poll();
                dogArr[1] = 1;
                return dogArr;
            }
            int[] dogArr = dogList.peek();
            int[] catArr = catList.peek();
            if(dogArr[1]>catArr[1]) {
                catList.poll();
                catArr[1] = 0;
                return catArr;
            } else {
                dogList.poll();
                dogArr[1] = 1;
                return dogArr;
            }
        }

        public int[] dequeueDog() {
            if(dogList.isEmpty()) return new int[]{-1,-1};
            int[] dogArr = dogList.poll();
            dogArr[1] = 1;
            return dogArr;
        }

        public int[] dequeueCat() {
            if(catList.isEmpty()) return new int[]{-1,-1};
            int[] catArr = catList.poll();
            catArr[1] = 0;
            return catArr;
        }
    }

}
