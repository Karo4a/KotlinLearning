package infrastructure

data class Topic(
    val id: Int,
    val name: String,
    val tasks: List<Task>
)