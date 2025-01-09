package lesson1;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Gson gson1 = new Gson();
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson3 = gsonBuilder.create();

        Person person = new Person("Anna", "Ivanova", 30);

        String personToGson1 = gson1.toJson(person);
        String personToGson2 = gson2.toJson(person);
        String personToGson3 = gson3.toJson(person);

        Person fromGsonPerson = gson1.fromJson(personToGson1, Person.class);

        System.out.println(fromGsonPerson  + "\n");
        System.out.println(personToGson1 + "\n");
        System.out.println(personToGson2 + "\n");
        System.out.println(personToGson3 + "\n");
    }
}
