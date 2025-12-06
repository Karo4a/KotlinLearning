import common.pressToContinue
import infrastructure.Task

fun main() {
    while (true) {
        println("Сборник программ по Kotlin.")
        println("Темы:")
        topics.forEach { topic ->
            println("${topic.id} - ${topic.name}")
        }
        println("-1 - Для выхода")

        print("Выберите тему: ")
        val topicId = readln().toIntOrNull()
        if (topicId == -1) {
            return
        }

        val topic = topics.find { topic -> topic.id == topicId}
        if (topic == null) {
            println("Неправильный выбор темы.\n")
            continue
        }

        do {
            var task: Task?

            if (topic.tasks.size == 1) {
                task = topic.tasks.first()
                println()
            } else {
                println("\n${topic.name}:")
                topic.tasks.forEach {
                    println("${it.id} - ${it.name}")
                }
                println("-1 - Вернуться к темам")

                print("Выберите задачу: ")
                val taskId = readln().toIntOrNull()
                println()
                if (taskId == null) {
                    println("Некорректный ввод.\n")
                    continue
                } else if (taskId == -1) {
                    break
                }
                task = topic.tasks.find { it.id == taskId }
                if (task == null) {
                    println("Неправильный выбор задачи.\n")
                    continue
                }
            }
            task.action()
            pressToContinue()
            println()

            if (topic.tasks.size == 1) {
                break
            }
        } while (true)
    }
}