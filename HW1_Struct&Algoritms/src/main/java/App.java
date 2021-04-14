import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

    public static final int FIND_AGE = 3;//примитив

    public static void main(String[] args) {


        List<Cat> cats = new ArrayList<>();//ссылочный
        cats.add(new Cat("Barsik", 8, 15));//своего класса
        cats.add(new Cat("Murka", 1, 8));
        cats.add(new Cat("Omega", 3, 10));


        cats.forEach(System.out::println);
        long a = System.nanoTime();
        for (int i = 0; i < cats.size(); i++) {//поиск перебором

            if (cats.get(i).getAge() == FIND_AGE) {
                System.out.println("Нашелся кот!");
            }

        }
        System.out.println("Время работы алгоритма поиска = " + (System.nanoTime() - a));

    }
}

class Cat {
    private String Name;
    int age;
    int weight;

    public Cat(String name, int age, int weight) {
        Name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat " +
                "по имени '" + Name + '\'' +
                ", возраст =" + age +
                ", вес =" + weight;
    }

    public int getAge() {
        return age;
    }
}
