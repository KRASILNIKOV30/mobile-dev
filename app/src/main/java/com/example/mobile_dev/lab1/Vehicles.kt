package com.example.mobile_dev.lab1

sealed interface Vehicle

data object Scooter : Vehicle

sealed class Wheel(d: Int)

class BikeWheel(d: Int) : Wheel(d)

class Disk

class CarWheel(d: Int, brand: String, disk: Disk)

enum class FrameType {
    TITAN,
    STEEL,
    PLASTIC,
}

class Frame(type: FrameType)

enum class Fuel {
    PETROL,
    DIESEL,
}

sealed class Bike(bikeBrand: String, d: Int, frame: FrameType) : Vehicle {
    val brand = bikeBrand
    val frontWheel = BikeWheel(d)
    val backWheel = BikeWheel(d)
    val frame = Frame(frame)
}

sealed class Engine

class ICE(volume: Double, fuel: Fuel): Engine()

data object ElectricMotor : Engine()

open class ControlSystem

class SteeringWheel : ControlSystem()

enum class AutopilotType {
    YANDEX,
    TESLA,
}

class Autopilot(type: AutopilotType) : ControlSystem()

sealed class Car(
    wheels: List<CarWheel>,
    engine: Engine,
    controlSystem: ControlSystem
) : Vehicle

class ICECar(
    wheels: List<CarWheel>,
    engine: ICE,
    controlSystem: SteeringWheel,
) : Car(wheels, engine, controlSystem)

class ElectricCar(
    wheels: List<CarWheel>,
    engine: ElectricMotor,
    controlSystem: Autopilot,
) : Car(wheels, engine, controlSystem)