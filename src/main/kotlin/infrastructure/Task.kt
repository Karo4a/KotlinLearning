package infrastructure

data class Task(
    val id: Int,
    val name: String,
    val action: () -> Unit
)