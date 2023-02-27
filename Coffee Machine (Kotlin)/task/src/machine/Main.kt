package machine


class CoffeeMachine(waterAmount: Int, milkAmount: Int, beansAmount: Int) {
    private val totalCups = minOf((waterAmount / 200) as Int, minOf(milkAmount / 50 as Int, beansAmount / 15 as Int))
    fun getCoffee(cups: Int) {
        val cups = totalCups - cups
        when {
            cups == 0 -> println("Yes, I can make that amount of coffee")
            cups > 0 -> println("Yes, I can make that amount of coffee (and even $cups more than that)")
            cups < 0 -> println("No, I can make only $totalCups cups of coffee")
        }
    }
}

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val waterAmount = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milkAmount = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val beansAmount = readln().toInt()
    val machine = CoffeeMachine(waterAmount, milkAmount, beansAmount)
    println("Write how many cups of coffee you will need:")
    val cups = readln().toInt()

    machine.getCoffee(cups)

}
