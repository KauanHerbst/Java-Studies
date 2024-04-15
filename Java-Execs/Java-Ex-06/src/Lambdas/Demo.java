package Lambdas;

import Lambdas.Functionalnterface.IFunctionInter;

import java.util.function.BiFunction;

public class Demo {
    public static void main(String[] args) {
        BiFunction<Long, Long, String> biFunction = (Long valor1, Long valor2) -> String.valueOf(valor1 + valor2);
        String result = biFunction.apply(10l, 20l);
        System.out.println(result);

        IFunctionInter<Integer, Integer, Integer> functionInter = (Integer valor1, Integer valor2) -> (valor1 * valor2);
        Integer resultInteger = functionInter.apply(5,5);
        System.out.println(resultInteger);

        calc(40l, 60l, (Long value1, Long value2) -> (value1 + value2));
        calc(40l, 60l, (Long value1, Long value2) -> (value1 * value2));

    }

    public static void calc(Long value1, Long value2, IFunctionInter<Long, Long, Long> functionInter){
        Long result = functionInter.apply(value1, value2);
        System.out.println(result);
    }
}
