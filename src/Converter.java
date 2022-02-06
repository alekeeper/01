

public class Converter {
    double rateUSD;
    double  rateEUR;
    double rateJPY;

    //добавьте конструктор здесь
    Converter(double usd, double eur, double jpy) {
        rateUSD = usd;
        rateEUR = eur;
        rateJPY = jpy;
    }

    void convert(double rubles, int currency) {
        if (currency == 1) {
            System.out.println("Ваши сбережения в долларах: " + rubles / rateUSD);
        } else if (currency == 2) {
            System.out.println("Ваши сбережения в евро: " + rubles / rateEUR);
        } else if (currency == 3) {
            System.out.println("Ваши сбережения в иенах: " + rubles / rateJPY);
        } else {
            System.out.println("Неизвестная валюта");
        }
    }
}




/*
import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        double[] expenses = new double[7];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                convert(scanner, moneyBeforeSalary);
            } else if (command == 2) {
                getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
                // Перенесите код ниже в метод saveExpense
                // Вызовите метод с помощью такой строки:
                moneyBeforeSalary = saveExpense(scanner, moneyBeforeSalary, expenses);

            } else if (command == 4) {
                // Перенесите обработку команды в метод printAllExpenses, здесь вызовите его
                printAllExpenses(expenses);

            } else if (command == 5) {
                // Перенесите поиск максимальной траты в метод findMaxExpense
                //findMaxExpense(expenses);
                // Печать должна остаться здесь — для получения максимальной траты нужно вызвать метод
                System.out.println("Самая большая сумма расходов на этой неделе составила " + findMaxExpense(expenses) + " руб.");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    //Добавьте здесь метод saveExpense, который будет сохранять значение расходов пользователя.
          //saveExpense также должен возвращать новое значение остатка средств.
    public static double saveExpense(Scanner scanner, double moneyBeforeSalary, double[] expenses) {
        System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
        int day = scanner.nextInt();
        System.out.println("Введите размер траты:");
        double expense = scanner.nextDouble();
        moneyBeforeSalary = moneyBeforeSalary - expense;
        expenses[day - 1] = expenses[day - 1] + expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    // Объявите и реализуйте здесь метод printAllExpenses
    public static void printAllExpenses(double[] expenses) {
        for (int i = 0; i < expenses.length; i++) {
            System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
        }
    }

    // Напишите метод findMaxExpense — он должен возвращать значение максимальной траты
    public static double findMaxExpense(double[] expenses) {
        double maxExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
            }
        }
        return maxExpense;
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }

    public static void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        if (moneyBeforeSalary < 3000) {
            System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
        } else if (moneyBeforeSalary < 10000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Окей, пора в Макдак!");
            } else {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            }
        } else if (moneyBeforeSalary < 30000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            } else {
                System.out.println("Окей, пора в Макдак!");
            }
        } else {
            if (daysBeforeSalary < 10) {
                System.out.println("Отлично! Заказывайте крабов!");
            } else {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            }
        }
    }

    public static void convert(Scanner scanner, double moneyBeforeSalary) {
        double rateUSD = 78.5;
        double rateEUR = 85;
        double rateJPY = 0.74;

        System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
        System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
        int currency = scanner.nextInt();
        if (currency == 1) {
            System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
        } else if (currency == 2) {
            System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
        } else if (currency == 3) {
            System.out.println("Ваши сбережения в иенах: " + moneyBeforeSalary / rateJPY);
        } else {
            System.out.println("Неизвестная валюта");
        }
    }

}
*/

/*
public class Praktikum {

    public static void main(String[] args) {
        //String name;
        String pixel = "Пиксель";
        String bite = "Байт";

        double[] feedExpensesCat = {100.50, 236.0, 510.6, 150.20, 80.0, 172.0, 135.4};
        double[] feedExpensesHamster = {70.50, 146.0, 710.6, 250.20, 83.0, 19.0, 55.4};
        //double[] feedExpenses = new double[7];
        //double maxFeedExpenseCat = 0, maxFeedExpenseHamster = 0;
        //double sumFeedCat = 0, sumFeedHamster = 0;

        sayHello(pixel);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesCat));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesCat));
        sayEnjoyMeal(pixel);
        System.out.println("\n");

        sayHello(bite);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesHamster));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesHamster));
        sayEnjoyMeal(bite);

    }

    public static double findExpensesSum(double[] feedExpenses) {
        double sumFeed = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            sumFeed = sumFeed + feedExpenses[i];
        }
        return sumFeed;
    }

    public static double findMaxExpense(double[] feedExpenses) {
        double maxFeedExpense = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            if (feedExpenses[i] > maxFeedExpense) {
                maxFeedExpense = feedExpenses[i];
            }
        }
        return maxFeedExpense;
    }

    public static void sayEnjoyMeal(String name) {
        System.out.println("Приятного аппетита, " + name + "!");
    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

}
*/

/*
import com.sun.source.tree.BreakTree;
import java.util.Scanner;

public class Praktikum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую зарплату вы получите в этом месяце?");
        int salary = scanner.nextInt();
        System.out.println("Сколько планируете потратить на транспорт?");
        int transportMoney = scanner.nextInt();
        System.out.println("Сколько запланировано на супермаркеты?");
        int foodMoney = scanner.nextInt();
        System.out.println("Какую сумму хотите отложить?");
        int savings = scanner.nextInt();

        correctExpenses(salary, transportMoney, foodMoney, savings); // Вызовите метод correctExpenses с правильными аргументами

        // Напечатайте запланированные траты
        System.out.println("Вы планировали потратить: транспорт — " + transportMoney + ", "
                + "еда — " + foodMoney + ", "
                + "сбережения — " + savings + ".");
    }

    public static int correctExpenses(int salary, int transportMoney, int foodMoney, int savings) { // Объявите метод correctExpenses
        // Тело метода дано ниже

        int expensesSum = transportMoney + foodMoney + savings; // Считаем расходы
        int leftMoney = salary - expensesSum;
        if (expensesSum > salary) { // Проверяем, не превышают ли расходы зарплату
            int lackMoney = expensesSum - salary; // Считаем, сколько не хватает
            // Считаем излишек средств

            // Пока не начнёт хватать денег на еду — сокращаем траты на 100 рублей
            while ((salary - foodMoney) < transportMoney) {
                foodMoney = foodMoney - 100;
            }
            // Если не хватает денег на жизнь — не откладываем
            if (transportMoney + foodMoney + savings > salary) {
                savings = 0;
            }

            // Печатаем рекомендации
            System.out.println("Придётся пересмотреть планы, вам не хватает " + lackMoney);
            System.out.println("Рекомендуемые траты: "
                    + "еда — " + foodMoney + ", "
                    + "сбережения — " + savings + ".");
        } else {
            System.out.println("В этом месяце дебет с кредитом сошлись!");
            System.out.println("Свободных средств " + leftMoney);
        }
        return expensesSum;
    }

}
*/

/*
public class Praktikum {

    public static void main(String[] args) {
        int a = 16;
        int b = 5;
        System.out.println("Наибольшее из чисел 16 и 5 = " + findMaxOf16And5(a, b));
    }

    public static int findMaxOf16And5(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

}
*/

/*
public class Praktikum {

    public static void main(String[] args) {
        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses); // Вызовите метод и присвойте maxExpense значение его результата
        System.out.println("Самая большая трата недели " + maxExpense);
    }

    public static double findMaxExpense(double[] expenses) {
        double maxExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
            }
        }
        return maxExpense;
    }
}
*/

/*
import java.util.Scanner;

public class Praktikum {

    public static void main(String[] args) {
        System.out.println("Наибольшее из чисел: " + findMax(3, 5));
        // Напишите аналогичный вызов метода findMax для таких пар чисел: 16 и 5, -1 и -7
        System.out.println("Наибольшее из чисел: " + findMax(16, 5));
        System.out.println("Наибольшее из чисел: " + findMax(-1, -7));
    }

    public static int findMax(int a, int b) {

        //int a;
        //int b;
        if (a > b) {
            return a;
        }
        return b;
    }

}
*/

/*
public class Praktikum {

    public static void main(String[] args) {
        // Ниже вызовите новый метод
        String highestGrossingFilm = findHighestGrossingFilm();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);
    }

    public static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;

        // Напишите реализацию нового метода ниже
        if (income1 >= income2) {
            if (income1 >= income3) {
                return film1;
            } else {
                return film3;
            }

        } else {
            if (income2 >= income3) {
                return film2;
            } else {
                return film3;
            }
        }
    }
}

/*
import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        System.out.println("Робот-помощник v2.0.");
        // Вызовите ниже методы в правильном порядке
        sayHello();
        sayHelloByTime();
        welcomeUserByName();
        printSuccess();
    }

    public static void welcomeUserByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = scanner.next();
        printCity();
        String city = scanner.next();
        System.out.println("Рад познакомиться, " + name + " из " + city + "!");
    }

    public static void printSuccess() {
        System.out.println("У вас уже неплохо получается программировать!");
    }

    public static void sayHello() {
        System.out.println("Привет!");
    }// Допишите метод sayHello(), который печатает: Привет!

    public static void printCity() {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Из какого вы города?");
        //String city = scanner.next();
    }// Допишите метод printCity(), который спрашивает: Из какого вы города?

    public static void sayHelloByTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Который час?");
        int currentHour = scanner.nextInt();
        if (currentHour < 6) {
            System.out.println("Доброй ночи!");
        } else if (currentHour > 22) {
            System.out.println("Доброй ночи!");
        } else if (currentHour < 12) {
            System.out.println("Доброе утро!");
        } else if (currentHour < 18) {
            System.out.println("Добрый день!");
        } else {
            System.out.println("Добрый вечер!");
        }
    }
}
*/

/*
import java.util.Scanner;

class Praktikum {
    public static void main(String[] args) {
        double[] expenses = new double[7];

        double rateUSD = 78.5;
        double rateEUR = 85;
        double rateJPY = 0.74;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Конвертировать валюту");
            System.out.println("2 - Получить совет");
            System.out.println("3 - Ввести трату");
            System.out.println("4 - Показать траты за неделю");
            // Допишите вывод нового пункта меню
            System.out.println("5 — Показать самую большую сумму расходов за неделю");
            System.out.println("0 - Выход");

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
                System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
                int currency = scanner.nextInt();
                if (currency == 1) {
                    System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
                } else if (currency == 2) {
                    System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
                } else if (currency == 3) {
                    System.out.println("Ваши сбережения в иенах: " + moneyBeforeSalary / rateJPY);
                } else {
                    System.out.println("Неизвестная валюта");
                }
            } else if (command == 2) {
                if (moneyBeforeSalary < 3000) {
                    System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                } else if (moneyBeforeSalary < 10000){
                    if (daysBeforeSalary < 10) {
                        System.out.println("Окей, пора в Макдак!");
                    } else {
                        System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                    }
                } else if (moneyBeforeSalary < 30000) {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                    } else {
                        System.out.println("Окей, пора в Макдак!");
                    }
                } else {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Отлично! Заказывайте крабов!");
                    } else {
                        System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                    }
                }
            } else if (command == 3) {
                System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
                int day = scanner.nextInt();
                System.out.println("Введите размер траты:");
                double expense = scanner.nextDouble();
                moneyBeforeSalary = moneyBeforeSalary - expense;
                expenses[day - 1] = expenses[day - 1] + expense;
                System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
                if (moneyBeforeSalary < 1000) {
                    System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
                }
            } else if (command == 4) {
                for (int i = 0; i < expenses.length; i++) {
                    System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
                }
            } else if (command == 5) { // Добавьте условие в ветвление для обработки новой команды
                double maxExpense = 0;
                for (int i = 0; i < expenses.length; i++) { // Проходим циклом по всему массиву трат
                    if (expenses[i] > maxExpense) { // Сравниваем, больше ли текущий элемент массива значения maxExpense
                        // Если условие верно, то записываем в maxExpense значение текущего элемента массива
                        maxExpense = expenses[i];
                    }
                }
                // Печатаем максимум расходов:
                System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}
*/

/*
import java.util.Scanner;

class Praktikum {
    public static void main(String[] args) {

        double[] expenses = new double[7];
        double expense = 50;

        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = expense;
            expense = expense + 100;
        }
        System.out.println("Расходы за неделю успешно занесены в приложение!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Расходы за какой день вы хотите проверить. Выберите значение от 0 (пн) до 6 (вс).");

            int index = scanner.nextInt();

            if (index < 0) {
                System.out.println("Выбрано неверное значение! Минимальное значение - 0");
                continue;
            } else if (index >= expenses.length) {
                System.out.println("Выбрано неверное значение! Максимальное значение - " + (expenses.length - 1));
                continue;
            } else if (index < expenses.length) {
                System.out.println("Потрачено " + expenses[index] + " рублей");
                break;
            }
        }
    }
}
*/
/*
import java.util.Random;


class Praktikum {
    public static void main(String[] args) {
        // Объявите пустой массив трат за неделю (7 дней)
        int[] expenses = new int[7];
        int sum = 0;

        Random random = new Random(); // Генерирует случайное число

        // Допишите условие цикла for, чтобы заполнить массив случайными тратами
        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = random.nextInt(10);
            System.out.print(expenses[i] + " ");
            sum = sum + expenses[i];
        }
        System.out.println(" ");

        System.out.println("Траты за неделю:");
        // Выведите с помощью цикла все траты за неделю в виде: "День ... . Потрачено рублей: ..."
        for (int i = 0; i < expenses.length; i++) {
            System.out.println("День " + (i + 1) + ". Потрачено рублей: " + expenses[i]);
        }

        //int sum = 0;
        // Посчитайте и выведите сумму трат за неделю — используйте цикл и здесь
        //for (int i = 0; i < expenses.length; i++); {
        //    sum = sum + expenses[i];
        //}
        System.out.println("Траты в рублях за неделю: " + sum);
    }
}
*/


/*import java.util.Scanner;

class Praktikum {
    public static void main(String[] args) {
        String[] currencies = {"USD","EUR","JPY","RUB"};

        System.out.println("В вашем тревел-кошельке доступны следующие валюты:");
        System.out.print(currencies[0] + ", ");
        System.out.print(currencies[1] + ", ");
        System.out.print(currencies[2] + ", ");
        System.out.println(currencies[3] + ".");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Если вы планируете поездку в Данию, введите 1, а если в Китай, введите 2:");

        int country = scanner.nextInt();  // Считайте из консоли ввод пользователя

        if (country == 1) {// Если выбрана Дания, измените значение элемента евро на кроны DKK
            currencies[1] = "DKK";
            // Если Китай, измените значение элемента иена на юани CNY
        } else if (country == 2){
            currencies[2] = "CNY";
        } else {
            System.out.println("Неверный выбор.");
        }

        System.out.println("В вашем тревел-кошельке доступны следующие валюты:");
        System.out.print(currencies[0] + ", ");
        System.out.print(currencies[1] + ", ");
        System.out.print(currencies[2] + ", ");
        System.out.println(currencies[3] + ".");
    }
}
*/
