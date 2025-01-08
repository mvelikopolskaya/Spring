package lesson1;


import com.google.gson.Gson;

/**
Создать проект с использованием Maven или Gradle, добавить в него несколько
зависимостей и написать код, использующий эти зависимости.
Пример решения:
        1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или
блока 2.
        2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и
com.google.code.gson:gson:2.8.6.
        3. Создайте класс Person с полями firstName, lastName и age.
        4. Используйте библиотеку commons-lang3 для генерации методов toString,
equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов
класса Person в формат JSON.
**/

public class App
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        Person person = new Person("Anna", "Ivanova", 30);
        String gsonPerson = gson.toJson(person);
        Person fromGsonPerson = gson.fromJson(gsonPerson, Person.class);

        System.out.println(fromGsonPerson);

        System.out.println(fromGsonPerson.name);
        System.out.println(fromGsonPerson.lastName);
        System.out.println(fromGsonPerson.age);
    }
}
