package solutionTasks.listOfUsersAssignedTasks;


import lombok.Getter;
import lombok.Setter;

import java.util.*;

/*

 * Необходимо создать объект, который будет хранить информацию о Пользователе.
 * Объект должен содержать следующие поля:
  * Id — который нужно считать по порядку добавления нового пользователя.
 *  name - Имя пользователя.
  * age - возраст пользоватля.
  * sex - Пол (male/female).
  * Необходимо предусмотреть хранение списка пользователей.
 *
 * Класс должен выполнять следующие задачи:
 * 1. Формировать список всех пользователей.
 * 2. Формировать список пользователей по полу (MALE/FEMALE).
 * 3. Возвращать количество пользователей в общем списке,
 * 4. Посчитать количество пользователей по признаку пола пользователя.
 * 5. Возвращать количество пользователей в общем списке.
 * 6. Посчитать количество пользователей по признаку пола пользователя.
 * 7. Посчитать общую сумму по возрасту пользователей, так же учесть по признаку пола.
 * 8. Посчитать средний возраст, как общий так и по признаку пола.
 * 9. После написания методы покрыть тестами.
 * */
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;
    /**
     * после проверки всех методов, добавили приватные поля
     * и метод setUp()  */
    private User user;
    private User user1;
    private User user2;

    private User userNotAdd;
    private User userNotAdd1;

    /*хранение пользователей*/
    private static Map<Integer, User> allUsers;
    /*подстчёт пользователей*/
    private static int countId = 0;

    /*Конструктор, который инициализирует поля,
     * провнряет есть ли такой объект или нет, если нет то добавляет*/
    public User(String name, int age, Sex sex) {
        if (allUsers == null) {
            allUsers = new HashMap<>();
        }
        this.name = name;
        this.age = age;
        this.sex = sex;
        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    /*а. формирование списка всех пользователей getAllUsers() */

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    /*b. формировать список пользователей по полу getAllUsers(Sex sex)*/
    public static List<User> getAllUsers(Sex sex) {
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()) {
            if (user.sex == sex) {
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    /* c. Возвращать количество пользователей в общем списке,
    и посчитать количество по признаку пола пользователя.*/

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    /* d. Посчитать общую сумму по возрасту пользователей,
     * так же учесть по признаку пола. Для этой задачи сделаем
     * методы.*/
    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user : allUsers.values()) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User user : getAllUsers(sex)) {
            countAge += user.age;
        }
        return countAge;
    }

    /*
     * e.Посчитать средний возраст, как общий так и по признаку пола.*/

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()
                != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
