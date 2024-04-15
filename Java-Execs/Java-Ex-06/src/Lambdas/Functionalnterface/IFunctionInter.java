package Lambdas.Functionalnterface;
@FunctionalInterface
public interface IFunctionInter<T, U, R> {
    R apply(T t, U u);
}
