package machine

fun main() {
    println("Write how many cups of coffee you will need:")
    val noOfCoffee = readln().toInt()
    val requiredWater = noOfCoffee * 200
    val requiredMilk = noOfCoffee * 50
    val requiredBeans = noOfCoffee * 15

    println("For $noOfCoffee cups of coffee you will need:\n" +
            "$requiredWater ml of water\n" +
            "$requiredMilk ml of milk\n" +
            "$requiredBeans g of coffee beans")
}
