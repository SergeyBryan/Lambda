import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        int firstNumber = randomNumber();
        int secondNumber = randomNumber();

        Predicate<Integer> petPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        System.out.println(petPredicate.test(firstNumber));
        Predicate<Integer> predicate = x -> (x > 0);
        System.out.println(predicate.test(secondNumber));
        System.out.println(firstNumber + " & " + secondNumber);

//        Задание 2
        String ivan = "Иван";
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println("Приветствую, " + string);
            }
        };
        consumer.accept(ivan);
        Consumer<String> consumer1 = s -> System.out.println("Приветствую " + s);
        consumer1.accept(ivan);
//      Задание 3
        double number = ((double) randomNumber() / randomNumber()) * 100;
        Function<Double, Long> doubleIntegerFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println("Function: " + doubleIntegerFunction.apply(number));
        Function<Double, Long> longFunction = x -> x.longValue();
        System.out.println("Function lambda: " + longFunction.apply(number));

//        Задание 4

        Supplier<Integer> randomSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(0, 100);
            }
        };

        System.out.println("Supplier: " + randomSupplier.get());
        Supplier<Integer> supplier = () -> new Random().nextInt(0, 100);
        System.out.println("Supplier lambda: " + supplier.get());


    }


    //    Задание 5
    public static <T, U> Function<T, U> ternaryOperation(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse
    ) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    //  Задание 5
    public static <T, U> Function<T, U> ternaryOperation2(Predicate<? super T> condition,
                                                          Function<? super T, ? extends U> ifTrue,
                                                          Function<? super T, ? extends U> ifFalse) {
        return new Function<T, U>() {
            @Override
            public U apply(T t) {
                if (condition.test(t)) {
                    return ifTrue.apply(t);
                } else {
                    return ifFalse.apply(t);
                }
            }
        };
    }

    //Для задание с 1 по 4
    public static Integer randomNumber() {
        Random random = new Random();
        return random.nextInt(-100, 100);
    }


}