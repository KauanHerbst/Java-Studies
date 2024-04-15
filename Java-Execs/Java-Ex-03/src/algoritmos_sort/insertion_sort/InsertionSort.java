package algoritmos_sort.insertion_sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
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
        insertionSort(numbers);
        System.out.println(numbers);
    }

    public static void insertionSort(List<Integer> vetor){
        for(int i=1; i<vetor.size(); i++){
            int j = i;
            while (j > 0 && vetor.get(j) < vetor.get(j-1)){
                int aux = vetor.get(j);
                vetor.set(j,vetor.get(j-1));
                vetor.set(j-1, aux);
                j--;
            }
        }

    }
}
