package il.co.lird.FS133.Projects.Zemingo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertEquals;

class TestQuickPop {

    @Test
    void MutliThreadQuickPop() throws InterruptedException {

        int NB_THREADS = 1000;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        };
        QuickPopDataStructure<Integer> quickPopDataStructure = new QuickPopDataStructure<>(comparator);
        ArrayList<Thread> pushThreadArrayList = new ArrayList<>();
        ArrayList<Thread> popThreadArrayList = new ArrayList<>();
        class PushThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                Random rand = new Random();
                int pushVal = rand.nextInt(1000);
                quickPopDataStructure.push(pushVal);
            }
        }
        class PopThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                int value = quickPopDataStructure.pop();
                System.out.println(value);
            }
        }

        for (int i = 0; i <NB_THREADS; ++i){
            Thread thread = new Thread(new PushThreadSafeRandom());
            pushThreadArrayList.add(thread);
        }

        for (Thread thread : pushThreadArrayList){
            thread.start();
        }

        for (Thread thread : pushThreadArrayList){
            thread.join();
        }

        for (int i = 0; i <NB_THREADS; ++i){
            System.out.println(quickPopDataStructure.pop());
        }

        /*for (int i = 0; i <NB_THREADS; ++i){
            Thread thread = new Thread(new PopThreadSafeRandom());
            popThreadArrayList.add(thread);
        }

        for (Thread thread : popThreadArrayList){
            thread.start();
        }

        for (Thread thread : popThreadArrayList){
            thread.join();
        }*/

    }

    @Test
    void MultiThreadPopStudent() throws InterruptedException {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student2.grades - student1.grades;
            }
        };

        QuickPopDataStructure<Student> quickPopDataStructure = new QuickPopDataStructure<>(comparator);
        ArrayList<Thread> pushThreadArrayList = new ArrayList<>();
        ArrayList<Thread> popThreadArrayList = new ArrayList<>();

        class PushThreadSafeRandom implements Runnable {
            final Student student;
            PushThreadSafeRandom(Student student){
                this.student = student;
            }
            @Override
            public void run() {
                Student student1 = quickPopDataStructure.peek();
                /*if (student1 != null){
                    System.out.println(student1.name + " " + student1.familyName);
                }*/
                quickPopDataStructure.push(student);
            }
        }
        class PopThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                Student value = quickPopDataStructure.pop();
                System.out.println(value);
            }
        }

        Student student1 = new Student("Alice", "Smith", 85, 19, 1);
        Student student2 = new Student("Bob", "Johnson", 90, 20, 2);
        Student student3 = new Student("Charlie", "Davis", 75, 18, 3);
        Student student4 = new Student("David", "Brown", 80, 21, 1);
        Student student5 = new Student("Emily", "Taylor", 95, 19, 2);
        Student student6 = new Student("Frank", "Anderson", 70, 20, 3);
        Student student7 = new Student("Grace", "Wilson", 88, 18, 1);
        Student student8 = new Student("Henry", "Moore", 82, 21, 2);
        Student student9 = new Student("Isabella", "Lee", 93, 19, 3);
        Student student10 = new Student("James", "Clark", 77, 20, 1);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);

        for (int i = 0; i < 10; ++i){
            Thread thread = new Thread(new PushThreadSafeRandom(studentList.get(i)));
            pushThreadArrayList.add(thread);
        }

        for (Thread thread : pushThreadArrayList){
            thread.start();
        }

        for (Thread thread : pushThreadArrayList){
            thread.join();
        }

        Student student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student5);
        student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student9);
        student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student2);
        student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student7);
        student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student1);
        student = quickPopDataStructure.pop();
        System.out.println(student.name + " " + student.familyName);
        assertEquals(student, student8);

       /*for (int i = 0; i < 10; ++i){
            Student student = quickPopDataStructure.pop();
            System.out.println(student.name + " " + student.familyName);
        }*/
    }

    @Test
    void MutliThreadQuickPush() throws InterruptedException {

        int NB_THREADS = 1000;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        };
        QuickPushDataStructure<Integer> quickPushDataStructure = new QuickPushDataStructure<>(comparator);
        ArrayList<Thread> pushThreadArrayList = new ArrayList<>();
        ArrayList<Thread> popThreadArrayList = new ArrayList<>();
        class PushThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                Random rand = new Random();
                int pushVal = rand.nextInt(1000);
                quickPushDataStructure.push(pushVal);
            }
        }
        class PopThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                int value = quickPushDataStructure.pop();
                System.out.println(value);
            }
        }

        for (int i = 0; i <NB_THREADS; ++i){
            Thread thread = new Thread(new PushThreadSafeRandom());
            pushThreadArrayList.add(thread);
        }

        for (Thread thread : pushThreadArrayList){
            thread.start();
        }

        for (Thread thread : pushThreadArrayList){
            thread.join();
        }

        for (int i = 0; i <NB_THREADS; ++i){
            System.out.println(quickPushDataStructure.pop());
        }

        /*for (int i = 0; i <NB_THREADS; ++i){
            Thread thread = new Thread(new PopThreadSafeRandom());
            popThreadArrayList.add(thread);
        }

        for (Thread thread : popThreadArrayList){
            thread.start();
        }

        for (Thread thread : popThreadArrayList){
            thread.join();
        }*/

    }

    @Test
    void SimultaneousQuickPop() throws InterruptedException {

        int NB_THREADS = 1000;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        };
        QuickPopDataStructure<Integer> quickPopDataStructure = new QuickPopDataStructure<>(comparator);
        ArrayList<Thread> pushThreadArrayList = new ArrayList<>();
        ArrayList<Thread> popThreadArrayList = new ArrayList<>();
        class PushThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                Random rand = new Random();
                int pushVal = rand.nextInt(1000);
                quickPopDataStructure.push(pushVal);
            }
        }
        class PopThreadSafeRandom implements Runnable {
            @Override
            public void run() {
                int value = quickPopDataStructure.pop();
                System.out.println("Pop " + value);
            }
        }

        for (int i = 0; i <NB_THREADS; ++i){
            Thread thread = new Thread(new PushThreadSafeRandom());
            Thread threadPop = new Thread(new PopThreadSafeRandom());
            pushThreadArrayList.add(thread);
            popThreadArrayList.add(threadPop);
            thread.start();
            threadPop.start();
        }

        for (Thread thread : popThreadArrayList){
            thread.join();
        }

        for (Thread thread : pushThreadArrayList){
            thread.join();
        }
    }
}
