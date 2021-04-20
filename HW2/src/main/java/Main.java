import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int MAS_LENGTH = 10;
    public static final int SEARCH_VALUE = 2;

    public static void main(String[] args) {
        int[] masInt = new int[MAS_LENGTH];

        Random rand = new Random();
        for (int i = 0; i < masInt.length; i++) {
            masInt[i] = rand.nextInt(15);
        }

        /*task1(masInt);//задание 1
        long a = System.nanoTime();
        int numEl = lineSearch(masInt, SEARCH_VALUE);
        System.out.println("Время линейного поиска = " + (System.nanoTime() - a));

        Arrays.sort(masInt);
        long с = System.nanoTime();
        int el = binarySearch(masInt, 4);

        System.out.println("Время бинарного поиска = " + (System.nanoTime() - a));

        task23();

        long bub = System.nanoTime();
        bubbleSort(masInt);
        System.out.println("Время пузырьковой сортировки поиска = " + (System.nanoTime() - bub));
*/
        changeSort(masInt);

    }

    static void task1(int[] masInt) {
        long a = System.nanoTime();
        int[] masIntCopy = new int[MAS_LENGTH];
        System.out.println(Arrays.toString(masInt));
        System.out.println("Время вывода массива = " + (System.nanoTime() - a));

        long b = System.nanoTime();
        masIntCopy = Arrays.copyOf(masInt, MAS_LENGTH);
        System.out.println("Время копирования массива = " + (System.nanoTime() - b));

        long с = System.nanoTime();
        Arrays.sort(masIntCopy);
        System.out.println("Время сортировки массива = " + (System.nanoTime() - с));

        System.out.println(Arrays.toString(masIntCopy));
    }

    static int lineSearch(int[] masInt, int num) {//линейный поиск

        for (int i = 0; i < masInt.length; i++) {
            if (masInt[i] == num) {
                return i;
            }

        }
        return -1;
    }

    static int binarySearch(int[] masInt, int num) {
        int firstIndex = 0;
        int lastIndex = MAS_LENGTH - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (masInt[middleIndex] == num) {
                return middleIndex;
            } else if (masInt[middleIndex] < num) {
                firstIndex = middleIndex + 1;
            } else if (masInt[middleIndex] > num) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    static int[] task23() {
        int[] mas = new int[400];
        Random rnd = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rnd.nextInt(15);
        }
        long b = System.nanoTime();
        Arrays.sort(mas);
        System.out.println("Время сортировки массива из 400 элементов = " + (System.nanoTime() - b));
        return  mas;
    }

    static void bubbleSort(int[] mas) {
        int buf;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    sorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        Arrays.toString(mas);

    }

    static void changeSort(int[]mas){//выбора
        int buf,min;
        for (int i = 0; i < mas.length-1; i++) {
            min = i;
            for (int j = i+1; j < mas.length; j++) {
                    if(mas[j] < mas[min]){
                        min = j;
                    }
            }
            buf = mas[i];
            mas[i] = mas[min];
            mas[min] = buf;
        }

        System.out.println(Arrays.toString(mas));
    }

    static void vstavkaMethod(int[] m){
        int in,buff;
        for (int i = 0; i < m.length; i++) {
            buff = m[i];
            in = i;

            while (in > 0 && m[i-1]>=buff){
                m[i] = m[i-1];
                --in;
            }
            m[in] = buff;
        }

        System.out.println(Arrays.toString(m));
    }
}
