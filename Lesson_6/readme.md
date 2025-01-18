Используя Spring, разработайте RESTful API для вашего приложения. 
Ваш API должен включать операции для создания, чтения, обновления и удаления пользователей.

Приложение проверялось в Postman.

Создать пользователей: http://localhost:8080/persons/add

{
    "name": "",
    "email": ""
}

Посмотреть всех пользователей: http://localhost:8080/persons

Посмотреть конкретного пользователя: http://localhost:8080/persons

Изменить пользователя: http://localhost:8080/persons/update/{id}

Удалить пользователя: http://localhost:8080/persons/delete/{id}