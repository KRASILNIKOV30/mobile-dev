package com.example.mobile_dev.lab1

sealed interface Vehicle

data object Scooter : Vehicle

sealed class Wheel(val d: Int)

class BikeWheel(d: Int) : Wheel(d)

// 3 вида диска (Исправлено)
enum class Disk {
    CAST,
    FORGED,
    STAMPED,
}

class CarWheel(val d: Int, val brand: String, val disk: Disk)

enum class Frame {
    TITAN,
    STEEL,
    PLASTIC,
}

enum class Fuel {
    PETROL,
    DIESEL,
}

//  определить поля внутри конструктора (Исправлено)
sealed class Bike(val bikeBrand: String, d: Int, val frame: Frame) : Vehicle {
    val frontWheel = BikeWheel(d)
    val backWheel = BikeWheel(d)
}

sealed class Engine

class ICE(val volume: Double, val fuel: Fuel): Engine()

data object ElectricMotor : Engine()

class SteeringWheel

// Можно сразу type (Исправлено)
enum class Autopilot {
    YANDEX,
    TESLA,
}

sealed class Car(
    val wheels: List<CarWheel>,
    val engine: Engine,
) : Vehicle

class ICECar(
    wheels: List<CarWheel>,
    engine: ICE,
    val steeringWheel: SteeringWheel,
) : Car(wheels, engine)

class ElectricCar(
    wheels: List<CarWheel>,
    engine: ElectricMotor,
    val autopilot: Autopilot,
) : Car(wheels, engine)