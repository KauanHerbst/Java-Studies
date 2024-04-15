package algoritmos_sort.Quick_Sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(5);
        numbers.add(0);
        numbers.add(1);
        numbers.add(8);
        numbers.add(7);
        numbers.add(6);
        numbers.add(9);
        numbers.add(4);
        System.out.println(numbers);
        particionamento(numbers, 0, numbers.size()-1);
        System.out.println(numbers);
        numbers2.add(3);
        numbers2.add(2);
        numbers2.add(0);
        numbers2.add(1);
        particionamento(numbers2, 0, numbers.size()-1);
        System.out.println(numbers2);
    }

    public static void quickSort(List<Integer> numbers, Integer start, Integer end){
        if(start < end){
            int indice = particionamento(numbers, start, end);

            quickSort(numbers, start, indice-1);
            quickSort(numbers, indice+1, end);
        }
    }


    public static Integer particionamento(List<Integer> numbers, Integer start, Integer end){
        int pv = numbers.get(end);
        int k = start-1;
        for(int i=0; i<=end; i++){
            if(numbers.get(i) <= pv){
                k++;
                if(i != k){
                    int aux_1 = numbers.get(i);
                    int aux_2 = numbers.get(k);
                    numbers.set(i, aux_2);
                    numbers.set(k, aux_1);
                }
            }
        }
        return k+1;
    }

}
