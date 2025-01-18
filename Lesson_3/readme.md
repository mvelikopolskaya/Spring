Используя Spring, создайте серверное приложение, 
которое обрабатывает HTTP-запросы и возвращает JSON-ответы.
Задание проверялось в Postman

Добавить задачу: http://localhost:8080/task/add

{
    "name": "study",
    "description": "do homework",
    "status": "IN_PROGRESS"         //(DONE, IN_PROGRESS, TO_DO)
}

Показать все задачи: http://localhost:8080/task

Изменить задачу: http://localhost:8080/task/{id}/update

{
    "name": "study",
    "description": "do homework",
    "status": "DONE"                //(DONE, IN_PROGRESS, TO_DO)
}

Удалить задачу: http://localhost:8080/task/{id}/delete
