fun main() {
    class Habitacion(
        val numero: Int,
        val tipo: String,
        val capacidad: Int,
        val precioPorNoche: Double,
    )
    class Cliente(
        val nombre: String,
        val direccion: String,
        val telefono: String
    )

    class Reserva(
        val cliente: Cliente,
        val habitacion: Habitacion,
        val fechaInicio: String,
        val fechaFin: String
    )

    class Hotel {
        val habitaciones = mutableListOf<Habitacion>()
        val reservas = mutableListOf<Reserva>()
        val clientes = mutableListOf<Cliente>()

        fun registrarHabitacion() {
            println("Ingrese el número de habitación:")
            val numero = readLine()!!.toInt()

            println("Ingrese el tipo de habitación:")
            val tipo = readLine()!!

            println("Ingrese la capacidad de la habitación:")
            val capacidad = readLine()!!.toInt()

            println("Ingrese el precio por noche:")
            val precioPorNoche = readLine()!!.toDouble()

            val habitacion = Habitacion(numero, tipo, capacidad, precioPorNoche)
            habitaciones.add(habitacion)

            println("Habitación registrada correctamente.")
        }

        fun eliminarHabitacion() {
            println("Ingrese el número de habitación a eliminar:")
            val numero = readLine()!!.toInt()

            val habitacion = habitaciones.find { it.numero == numero }
            if (habitacion != null) {
                habitaciones.remove(habitacion)
                println("Habitación eliminada correctamente.")
            } else {
                println("Habitación no encontrada.")
            }
        }

        fun mostrarHabitaciones() {
            println("Habitaciones:")
            habitaciones.forEach {
                println("${it.numero} - ${it.tipo} - ${it.capacidad} personas - $${it.precioPorNoche} por noche")
            }
        }
    }
    val hotel = Hotel()
    var opcion: Int
    do {
        println("Bienvenido al sistema de administración de hotel")
        println("1. Registrar nueva habitación")
        println("2. Eliminar habitación")
        println("3. Mostrar habitaciones")
        println("4. Salir")

        println("Ingrese una opción:")
        opcion = readLine()?.toIntOrNull() ?: 0


        when (opcion) {
            1 -> hotel.registrarHabitacion()
            2 -> hotel.eliminarHabitacion()
            3 -> hotel.mostrarHabitaciones()
        }
    } while (opcion != 4)

}