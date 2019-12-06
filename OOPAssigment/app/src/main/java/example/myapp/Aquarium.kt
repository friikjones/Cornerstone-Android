package example.myapp

open class Aquarium(open var length: Int = 100,open var width: Int = 20,open var height: Int = 40) {

    init{
        println("Aquarium initializing")
    }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    open fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm "+ "\n" +
                "Volume: $volume l "+ "\n" +
                "Water: $water l (${water/volume*100.0}% full)")
    }

}