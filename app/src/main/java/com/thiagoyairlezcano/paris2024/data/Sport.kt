package data

data class Sport(
    val id: Long,
    val name: String,
    val stars: Double,
    val logo: String


) {
    override fun toString(): String {
        return "Deporte(Nombre:'$name', Estrellas=$stars)"
    }
}
