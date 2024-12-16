# Sistema de Reservas Hoteleras

Un sistema de reservas desarrollado en Java que permite a los usuarios buscar alojamientos, realizar reservaciones y gestionar reservas en múltiples ciudades de Colombia.

## Autor
Johan Villa Osorio

## Características

- Búsqueda de alojamientos por ciudad
- Realización de reservas de habitaciones
- Reservas de pases por día
- Visualización del historial de reservas
- Ajustes de precios basados en fechas
- Soporte para diferentes tipos de habitaciones
- Seguimiento de disponibilidad en tiempo real

## Detalles Técnicos

### Componentes Principales

- **Gestión de Alojamientos**: Maneja datos de hoteles y habitaciones
- **Motor de Reservas**: Procesa reservaciones y disponibilidad
- **Calculador de Precios**: Computa tarifas con ajustes estacionales
- **Rastreador de Historial**: Mantiene registros de reservas

### Estructuras de Datos

- Hoteles y alojamientos almacenados en arrays bidimensionales
- Historial dinámico de reservas usando ArrayList
- Matriz de disponibilidad de habitaciones
- Tablas de precios para diferentes tipos de habitaciones

### Métodos Principales

- `buscarAlojamientos`: Búsqueda de alojamiento por ciudad
- `realizarReserva`: Procesamiento de reservas de habitaciones
- `reservarDiaSol`: Gestión de reservas por día
- `confirmarReservacion`: Confirmación de reservas pendientes
- `verHistorialReservas`: Visualización del historial de reservas
- `calcularAjuste`: Cálculo de ajustes de precios

## Tipos de Habitaciones

1. Suite Presidencial
2. Suite Matrimonial
3. Habitación Doble
4. Habitación Individual
5. Habitación Familiar

## Ciudades Incluidas

- Bogotá
- Cartagena
- Santa Marta
- San Andrés
- Amazonas

## Ajustes de Precios

El sistema incluye ajustes automáticos de precios:

- +15% para reservas que terminan después del día 25
- +10% para reservas que inician entre los días 10-15
- -8% de descuento para reservas que inician entre los días 5-10

## Requisitos

- Java 17 o superior
- IDE con soporte para Java (VS Code recomendado)

## Instrucciones de Configuración

1. Clonar el repositorio
2. Abrir en VS Code o IDE preferido
3. Asegurarse de tener Java 17+ instalado
4. Ejecutar `BookingApp.java`

## Mejoras Futuras

- Persistencia de datos
- Autenticación o por lo menos identificación de usuarios
