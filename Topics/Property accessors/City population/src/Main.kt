class City(val name: String) {
    var population: Int = 10
        set(value) {
            field = if (value < 0) {
                0
            } else if (value > 50000000) {
                50000000
            } else {
                value
            }
        }
}