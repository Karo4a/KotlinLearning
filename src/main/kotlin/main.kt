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
            println("Неправильно выбор темы.\n")
            continue
        }
        println("\n${topic.name}:")
        topic.tasks.forEach {task ->
            println("${task.id} - ${task.name}")
        }

        print("Выберите задачу: ")
        val taskId = readln().toIntOrNull()
        println()
        if (taskId == null) {
            println("Некорректный ввод.\n")
            continue
        }
        val task = topic.tasks.find { task -> task.id == taskId }
        if (task == null) {
            println("Неправильный выбор задачи.\n")
            continue
        }
        task.action()
        println()
    }
}