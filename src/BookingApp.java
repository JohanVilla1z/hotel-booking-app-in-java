import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingApp {
    private static String ultimaReserva = ""; // Registro temporal de la última reserva realizada
    private static final List<String> historialReservas = new ArrayList<>(); // Registro histórico de reservas
                                                                             // confirmadas

    public static void main(String[] args) {

        String[] ciudades = { "Bogota", "Cartagena", "Santa Marta", "San Andres", "Amazonas" };

        String[][] alojamientos = {
                { "Hotel Tequendama", "Bogota", "Hotel", "4.5", "50000" },
                { "Apartamento Central", "Bogota", "Apartamento", "4.0", "40000" },
                { "Hotel Caribe", "Cartagena", "Hotel", "4.8", "60000" },
                { "Casa Colonial", "Cartagena", "Finca", "4.2", "35000" },
                { "Irotama Resort", "Santa Marta", "Hotel", "5.0", "350000" },
                { "Apartamento Playa", "Santa Marta", "Apartamento", "3.5", "150000" },
                { "Hotel Decameron", "San Andres", "Hotel", "5.0", "500000" },
                { "Casa Vacacional", "San Andres", "Finca", "4.1", "300000" },
                { "EcoAmazon Lodge", "Amazonas", "Hotel", "4.7", "350000" },
                { "Finca Amazonica", "Amazonas", "Finca", "3.0", "200000" }
        };

        String[] actividadesDiaSol = {
                // Hotel Tequendama
                "Disponibildad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero",
                // Apartamento Central
                "Disponibilidad de piscina, zona de asados y parqueadero",
                // Hotel Caribe
                "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero",
                // Casa Colonial
                "Disponibilidad de piscina, salon de eventos y parqueadero",
                // Irotama Resort
                "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, spa, zona de juegos, discoteca y parqueadero",
                // Apartamento Playa
                "Disponibilidad de playa privada, zona de asados y parqueadero",
                // Hotel Decameron
                "Disponibilidad de piscina, almuerzo incluido, refrigerio para niuños, canchas deportivas, spa, zona de juegos, salon de eventos, discoteca y parqueadero",
                // Casa Vacacional
                "Mesa de billar, zona de asados y parqueadero",
                // EcoAmazon Lodge
                "Barra libre de cerveza, acceso dirigido al acuario, almuerzo incluido, spa, zona de juegos, recorrido dirigido por la naturaleza y grupos de avistamiento de aves",
                // Finca Amazonica
                "Disponibilidad de jacuzzi, zona de asados, senderismo por la zona con vista a la naturaleza"

        };

        float[] precioDiaSol = {
                50000, // Hotel Tequendama
                40000, // Apartamento Central
                60000, // Hotel Caribe
                35000, // Casa Colonial
                350000, // Irotama Resort
                150000, // Apartamento Playa
                500000, // Hotel Decameron
                300000, // Casa Vacacional
                350000, // EcoAmazon Lodge
                200000 // Finca Amazónica
        };

        float[][] preciosHabitaciones = {
                { 800000, 600000, 400000, 200000, 1000000 },
                { 300000, 400000, 500000, 600000, 800000 },
                { 900000, 700000, 500000, 300000, 1100000 },
                { 200000, 300000, 500000, 350000, 800000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 }
        };

        int[][] disponibilidadHabitaciones = {
                { 5, 4, 10, 8, 2 },
                { 3, 2, 5, 6, 1 },
                { 6, 3, 7, 4, 2 },
                { 5, 3, 8, 7, 3 },
                { 10, 8, 6, 4, 2 },
                { 3, 2, 5, 6, 2 },
                { 8, 6, 10, 5, 2 },
                { 5, 4, 7, 3, 2 },
                { 6, 4, 7, 5, 2 },
                { 5, 3, 6, 4, 1 }
        };

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBIENVENIDO A BOOKING COLOMBIA");
            System.out.println("1. Buscar alojamientos y disponibilidad");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Reservar Día de Sol");
            System.out.println("4. Confirmar reservación");
            System.out.println("5. Ver historial de reservaciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

        } while (opcion != 6);

        scanner.close();
    }

    public static void buscarAlojamientos(String[] ciudades, String[][] alojamientos, float[][] preciosHabitaciones,
            int[][] disponibilidadHabitaciones, Scanner scanner) {
        System.out.print("Ingrese una ciudad entre las opciones disponibles: ");
        for (String ciudad : ciudades) {
            System.out.print(ciudad + " | ");
        }
        System.out.println();

        scanner.nextLine(); // Limpiar buffer
        String ciudadEscogida = scanner.nextLine();

        System.out.println("\nAlojamientos disponibles en " + ciudadEscogida + ":");
        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i][1].equalsIgnoreCase(ciudadEscogida)) {
                System.out.printf("Nombre: %s | Tipo: %s | Calificación: %.1f estrellas%n",
                        alojamientos[i][0], alojamientos[i][2], Float.parseFloat(alojamientos[i][3]));
                for (int j = 0; j < preciosHabitaciones[i].length; j++) {
                    System.out.printf("  %d- %s: $%.2f | Disponibles: %d%n",
                            j + 1, obtenerDescripcionHabitacion(j), preciosHabitaciones[i][j],
                            disponibilidadHabitaciones[i][j]);
                }
            }
        }
    }

    public static String obtenerDescripcionHabitacion(int indice) {
        return switch (indice) {
            case 0 -> "Suit Presidencial";
            case 1 -> "Suit Matrimonial";
            case 2 -> "Habitación Doble";
            case 3 -> "Habitación Simple";
            case 4 -> "Habitación Familiar";
            default -> "Habitación Desconocida";
        };
    }

    public static void realizarReserva(String[][] alojamientos, float[][] preciosHabitaciones,
            int[][] disponibilidadHabitaciones, Scanner scanner) {
        System.out.print("Ingrese el nombre del hotel: ");
        scanner.nextLine(); // Limpiar buffer
        String nombreHotel = scanner.nextLine();

        int indiceHotel = buscarIndiceHotel(nombreHotel, alojamientos);
        if (indiceHotel == -1) {
            System.out.println("Hotel no encontrado.");
            return;
        }

        System.out.print("Ingrese el tipo de habitación (1-5): ");
        int tipoHabitacion = scanner.nextInt() - 1;

        if (tipoHabitacion < 0 || tipoHabitacion >= preciosHabitaciones[indiceHotel].length) {
            System.out.println("Tipo de habitación no válido.");
            return;
        }

        if (disponibilidadHabitaciones[indiceHotel][tipoHabitacion] <= 0) {
            System.out.println("No hay disponibilidad para este tipo de habitación.");
            return;
        }

        disponibilidadHabitaciones[indiceHotel][tipoHabitacion]--;

        System.out.print("Ingrese su nombre: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese la fecha de finalización de la reserva (yyyy-MM-dd): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

        long noches = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (noches <= 0) {
            System.out.println("Fechas no válidas. La fecha de fin debe ser posterior a la de inicio.");
            return;
        }

        float precioBase = preciosHabitaciones[indiceHotel][tipoHabitacion];
        float precioTotal = precioBase * noches;
        float ajuste = calcularAjuste(precioTotal, fechaInicio, fechaFin);

        ultimaReserva = String.format(
                "Reserva a nombre de %s en %s \nTipo de habitación: %s, \nDel %s al %s. (%d noches) \nPrecio total: $%.2f (Ajuste aplicado: $%.2f)",
                nombre, nombreHotel, obtenerDescripcionHabitacion(tipoHabitacion), fechaInicio, fechaFin, noches,
                precioTotal + ajuste, ajuste);

        System.out.println("\n" + ultimaReserva);
    }

    public static int buscarIndiceHotel(String nombreHotel, String[][] alojamientos) {
        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i][0].equalsIgnoreCase(nombreHotel)) {
                return i;
            }
        }
        return -1;
    }

    public static float calcularAjuste(float precioTotal, LocalDate fechaInicio, LocalDate fechaFin) {
        float ajuste = 0;
        if (fechaFin.getDayOfMonth() >= 25) {
            ajuste = precioTotal * 0.15f;
        } else if (fechaInicio.getDayOfMonth() >= 10 && fechaInicio.getDayOfMonth() <= 15) {
            ajuste = precioTotal * 0.10f;
        } else if (fechaInicio.getDayOfMonth() >= 5 && fechaInicio.getDayOfMonth() <= 10) {
            ajuste = -precioTotal * 0.08f;
        }
        return ajuste;
    }

    public static void confirmarReservacion() {
        if (ultimaReserva.isEmpty()) {
            System.out.println("No hay ninguna reserva para confirmar.");
        } else {
            historialReservas.add(ultimaReserva);
            System.out.println("\nReservación confirmada y añadida al historial.");
            ultimaReserva = ""; // Limpiar la reserva temporal después de confirmar
        }
    }

    public static void verHistorialReservas() {
        if (historialReservas.isEmpty()) {
            System.out.println("No hay reservas confirmadas.");
        } else {
            System.out.println("\nHistorial de Reservas Confirmadas:");
            for (String reserva : historialReservas) {
                System.out.println(reserva);
                System.out.println("----------------------");
            }
        }
    }

    public static void reservarDiaDeSol(String[][] alojamientos, float[] precioDiaSol, String[] actividades,
    Scanner scanner) {
System.out.println("\nAlojamientos disponibles para Día de Sol:");
for (int i = 0; i < alojamientos.length; i++) {
    System.out.printf("%d. %s | Ciudad: %s | Precio por adulto: $%.2f%n Actividades: %s%n%n",
            i + 1, alojamientos[i][0], alojamientos[i][1], precioDiaSol[i], actividades[i]);
}

System.out.print("\nSeleccione el número del alojamiento donde desea reservar: ");
int opcionHotel = scanner.nextInt() - 1;

if (opcionHotel < 0 || opcionHotel >= alojamientos.length) {
    System.out.println("Opción no válida.");
    return;
}

System.out.print("Ingrese la fecha de la reserva (yyyy-MM-dd): ");
scanner.nextLine(); // Limpiar buffer
LocalDate fechaReserva = LocalDate.parse(scanner.nextLine());

System.out.print("Ingrese la cantidad de adultos: ");
int adultos = scanner.nextInt();

System.out.print("Ingrese la cantidad de niños: ");
int ninos = scanner.nextInt();

float precioPorNino = precioDiaSol[opcionHotel] * 0.70f; // Descuento del 30% para niños
float costoTotal = (adultos * precioDiaSol[opcionHotel]) + (ninos * precioPorNino);

// Aplicar ajustes por temporada
float ajuste = calcularAjuste(costoTotal, fechaReserva, fechaReserva);
float costoFinal = costoTotal + ajuste;

// Mostrar el resumen de la reserva
System.out.println("\nResumen de la Reserva:");
System.out.printf("Hotel: %s | Ciudad: %s%n", alojamientos[opcionHotel][0], alojamientos[opcionHotel][1]);
System.out.printf("Fecha: %s | Adultos: %d | Niños: %d%n", fechaReserva, adultos, ninos);
System.out.printf("Costo Total: $%.2f (Incluye ajuste de $%.2f)%n", costoFinal, ajuste);

System.out.print("¿Desea confirmar esta reserva? (1: Sí / 2: No): ");
int confirmar = scanner.nextInt();

if (confirmar == 1) {
    String reserva = String.format("Día de Sol: %s | Fecha: %s | Adultos: %d | Niños: %d | Total: $%.2f | Con acceso a: %s",
            alojamientos[opcionHotel][0], fechaReserva, adultos, ninos, costoFinal, actividades[opcionHotel]);
    historialReservas.add(reserva);
    System.out.println("¡Reserva confirmada y guardada en el historial!");
} else {
    System.out.println("La reserva no se ha confirmado.");
}
}

}
