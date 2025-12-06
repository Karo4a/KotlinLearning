package train.classes

data class City(val name : String) {
    companion object {
        fun listOf(vararg names: String) : List<City> {
            return names.map { City(it) }.toList()
        }
    }
}