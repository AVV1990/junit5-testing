package ru.geekbrains.homework6Java3.tests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.homework6Java3.ArrayApp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayAppTest {

    private  ArrayApp arrayApp;

    @BeforeEach
    public  void  init (){
        arrayApp = new ArrayApp();
        System.out.println("init");
    }

    @AfterEach
    public void shutdown (){ // закрытие теста
        System.out.println("shutdown");
    }

    @ParameterizedTest
    @MethodSource ("demo2Args")
    public void TestIfArrayContains4and1 ( int [] arr, boolean ok) {
        Assertions.assertEquals(arrayApp.ifArrayContains4and1(arr), ok);
    }
    public static Stream<Arguments> demo2Args (){
        List <Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1,1,1,1}, false));
        out.add(Arguments.arguments(new int[] {4,4,4,4,4}, false));
        out.add(Arguments.arguments(new int[] {4,4,1,4,1}, true));
        out.add(Arguments.arguments(new int[] {1,2,3,3,4}, false));

        return out.stream();
    }








    @ParameterizedTest // тест является параметрическим
    @MethodSource("demoArgs") //Аннотация @MethodSource по имени метода привязывает источник данных к тесту.
    public void TestChangeArrIfArrContains4(int[] arr1, int[] arr2) {
        Assertions.assertArrayEquals(arrayApp.changeArrIfArrContains4(arr1), arr2);
    }

    public static Stream<Arguments> demoArgs() { //Класс Arguments представляет собой контейнер для любого количества аргументов
        List <Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int [] {1,2,4,5,4,6,7}, new  int [] {6,7}));
        out.add(Arguments.arguments(new int [] {1,4,2,5,6,7}, new  int [] {2,5,6,7}));
        out.add(Arguments.arguments(new int [] {1,2,4,5,6,7}, new  int [] {5,6,7}));
        out.add(Arguments.arguments(new int [] {1,2,4,5,7}, new  int [] {5,7}));

        return out.stream();

    }

    @Test
    public  void TestChangeArrIfArrContains4 () {

        Assertions.assertThrows(RuntimeException.class, () -> {
            arrayApp.changeArrIfArrContains4(new int[]{1, 2, 3});
        });

    }


}











