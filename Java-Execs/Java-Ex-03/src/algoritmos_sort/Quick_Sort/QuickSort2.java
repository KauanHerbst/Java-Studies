package algoritmos_sort.Quick_Sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort2 {
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
        quickSort(numbers, 0, numbers.size()-1);
        System.out.println(numbers);
    }

    public static void quickSort(List<Integer> vetor, Integer start, Integer end){
        if(start < end){
            int indice = particionamento(vetor, start, end);

            quickSort(vetor, start, indice);
            quickSort(vetor, indice+1, end);
        }
    }
    public static int particionamento(List<Integer> vetor, Integer start, Integer end){
        int meio = (int) (start + end) / 2;
        int pivo = vetor.get(meio);
        int k = start-1;
        int i = end+1;
        while(true){
            do{
                k++;
            }while(vetor.get(k) < pivo);
            do{
                i--;
            }while(vetor.get(i) > pivo);
            if(k >= i){
                return i;
            }
            int aux = vetor.get(k);
            vetor.set(k, vetor.get(i));
            vetor.set(i, aux);
        }
    }
}
