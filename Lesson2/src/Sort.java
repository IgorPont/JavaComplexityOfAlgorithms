public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 5, 4, 7, 8, 3, 1, 0, 6};

//        bubbleSort(array);
//        directSort(array);
//        insertSort(array);
//        quickSort(array, 0, array.length - 1);
        heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

//        System.out.println(find(array, 8));

//        System.out.println(binarySearch(array, 8, 0, array.length - 1));


    }

    // Пузырькова сортировка, сложность O(n^2) - квадратичная
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    // Сортировка выбором, сложность O(n^2) - квадратичная
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int tmp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = tmp;
            }
        }
    }

    // Сортировка вставками, сложность O(n^2) - квадратичная
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    // Алгоритм поиска значения в массиве, сложность О(n) - линейная
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Бинарный поиск через рекурсию, сложность О(log n) - логарифмическая
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;

        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }

        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        } else {
            if (array[midPoint] > value) {
                return binarySearch(array, value, min, midPoint - 1);
            } else {
                return midPoint;
            }
        }
    }

    // Быстрая сортировка, сложность от O(log n) до O(n^2), то есть O(n * log n)
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int tmp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = tmp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    // Пирамидальная сортировка, бинарная куча, сложность O(n * log n)
    // Состоит из двух этапов: подготовки и просеивания
    public static void heapSort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // определяем левый дочерний элемент
        int rightChild = 2 * rootIndex + 2; // определяем правый дочерний элемент

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int tmp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = tmp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
