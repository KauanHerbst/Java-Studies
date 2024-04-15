package algoritmos_sort.Quick_Sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort3 {
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
//        quickSort(numbers, 0, numbers.size()-1);
        insertionSort(numbers);
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
        int meio = (int) (start + end) /2;
        int pivo = vetor.get(meio);
        int k = start-1;
        int j = end+1;
        while(true){
            do{
                k++;
            }while(vetor.get(k) < pivo);
            do{
                j--;
            }while (vetor.get(j) > pivo);
            if(k >= j){
                return j;
            }
            int aux = vetor.get(k);
            vetor.set(k, vetor.get(j));
            vetor.set(j, aux);
        }
    }

    public static void insertionSort(List<Integer> vetor){
        for(int i=1; i<vetor.size(); i++){
            int j = i;
            while (j > 0 && vetor.get(j) < vetor.get(j-1)){
                int aux = vetor.get(j);
                vetor.set(j, vetor.get(j-1));
                vetor.set(j-1, aux);
                j--;
            }
        }
    }

}
