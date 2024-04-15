package algoritmos_sort.Bubble_Sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(49);
        numbers.add(98);
        numbers.add(12);
        numbers.add(3);
        numbers.add(56);
        numbers.add(6);
        numbers.add(42);
        numbers.add(0);
        System.out.println(numbers);
        bubble(numbers);
        System.out.println(numbers);
    }

    public static void bubble(List<Integer> numbers){
        int aux = 0;
        for(int j=0; j<numbers.size(); j++){
            for(int i=0; i <= numbers.size()-1; i++){
                if( i != numbers.size()-1){
                    if(numbers.get(i) > numbers.get(i+1)){
                        aux = numbers.get(i);
                        numbers.set(i, numbers.get(i+1));
                        numbers.set(i+1, aux);
                    }
                }
            }
        }
    }

}
