
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    // @Execution(ExecutionMode.CONCURRENT) - запустить все тесты параллельно (или вписать строку в файл junit-platform)
    void createCar() {
        car = new Car("ZAZ", "E605MX82", 2010, "Oleg Sergienko");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisabledOnOs(OS.MAC)  // можно выставлять несколько через запятую
    // @EnabledOnJre(JRE.JAVA_8)
    @DisabledOnJre(JRE.JAVA_11)  // можно выставлять несколько через запятую
    void getManufacturer() {
        assertEquals("ZAZ", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("E605MX82", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("A222AO22");
        assertEquals("A222AO22", car.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"E605MX82", "У333АА82", "H666KP82"}) // не может подать больше одного параметра в метод testSetNumberMultipleNumbers()
    // @CsvSource({"'E605MX82', "'У333АА82'"}) // если в тестовый метод нам необходимо подать больше одного параметра
    @NullSource
    @EmptySource
    void testSetNumberMultipleNumbers(String number){
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2010, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Oleg Sergienko", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Vika Zelenka");
        assertEquals("Vika Zelenka", car.getOwner());
    }

    @Test
    void getListOfOwners() {
        assertArrayEquals(new String[]{"Oleg Sergienko"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Vika Zelenka");
        assertArrayEquals(new String[]{"Oleg Sergienko", "Vika Zelenka"}, car.getOwners().toArray());
    }

    // модульный тест на переменную private из класса Car
    @Test
    void testPrivateMethod() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);

            method.setAccessible(true);
            assertEquals(method.invoke(car).toString(), "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPrivateMethodWithArgument() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);

            method.setAccessible(true);
            assertEquals(method.invoke(car, "abd").toString(), "abd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // модульный тест для более лучшего понимания @CsvSource
    @ParameterizedTest
    @CsvSource({"4, 8", // первый параметр - ввода, второй - вывода
            "8, 12",
            "9, 13",
    })
    void testInt(int input, int output){
        assertEquals(car.testInt(input), output);
    }

    // загрузка тестовых данных из файла @CsvFileSource
    @ParameterizedTest
    @DisplayName("Test demonstrates how test data can be loaded from file")
    @CsvFileSource(resources = "/Package01/test-data.csv", delimiter = '|', numLinesToSkip = 1)
    public void testNumbers(String input, String expected){
        car.setNumber(input);
        assertEquals(expected, car.getNumber());
    }

}
