import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    public static void main(String[] args) {

        int lastNumber = 17;
        AtomicInteger counter = new AtomicInteger();

        System.out.printf("Сумма всех чисел от 1 до %d равна %d; Количество итераций: %d\n",
                lastNumber, sum1(lastNumber, counter), counter.get());

        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n",
                lastNumber, sum2(lastNumber));

        counter.set(0); // Обнулили счетчик
        List<Integer> list01 = findSimpleNumbers(lastNumber, counter);
        System.out.printf("Поиск простых чисел от 1 до %d. Количество итераций: %d\n",
                lastNumber, counter.get());
        for (int i : list01) {
            System.out.printf("%d\t", i);
        }
        System.out.println();

    }

    /**
     * Необходимо написать алгоритм, считающий сумму всех чисел от 1 до n
     */

    // Линейная сложность
    public static int sum1(int lastNumber, AtomicInteger counter) {
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++) {
            sum += i;
            counter.getAndIncrement();
        }
        return sum;
    }

    // Алтернативный способ решения задачи подсчета суммы
    // Константная сложность
    public static int sum2(int lastNumber) {
        return ((1 + lastNumber) * lastNumber) / 2;
    }

    /**
     * Написать алгоритм поиска простых чисел (делятся только на себя и на 1)
     * в диапазоне от 1 ддо N
     */

    // Квадратичная сложность
    public static List<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= lastNumber; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }

            if (simple) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Что будет распечатано на экране при
     * n = 4
     * Ответ: 4321122
     */

    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    /**
     * Последовательность Фибоначчи
     */

    // 1:10

}
