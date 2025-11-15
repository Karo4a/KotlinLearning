import infrastructure.Task
import infrastructure.Topic

val topics = listOf(
    Topic(
        id = 1,
        name = "Основы",
        tasks = listOf(
            Task(1, "Задача 1") { basics.task1() },
            Task(2, "Задача 2") { basics.task2() },
            Task(3, "Задача 3") { basics.task3() },
            Task(4, "Задача 4") { basics.task4() },
            Task(5, "Задача 5") { basics.task5() },
            Task(6, "Задача 6") { basics.task6() },
        )
    ),
    Topic(
        id = 2,
        name = "Массивы, коллекции",
        tasks = listOf(
            Task(1, "Задача 1") { arrays.task1() },
            Task(2, "Задача 2") { arrays.task2() },
            Task(3, "Задача 3") { arrays.task3() },
            Task(4, "Задача 4") { arrays.task4() },
            Task(5, "Задача 5") { arrays.task5() },
        )
    ),
    Topic(
        id = 3,
        name = "Классы - основы",
        tasks = listOf(
            Task(1, "Задача 1") { classes_intro.task1() },
            Task(2, "Задача 2") { classes_intro.task2() },
            Task(3, "Задача 3") { classes_intro.task3() },
            Task(4, "Задача 4") { classes_intro.task4() },
            Task(5, "Задача 5") { classes_intro.task5() },
        )
    ),
)