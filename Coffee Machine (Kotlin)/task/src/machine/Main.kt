package machine


class CoffeeMachine() {
    private var waterAmount = 400
    private var milkAmount = 540
    private var beansAmount = 120
    private var disposableCups = 9
    private var money = 550
    private var action = ""
    private val totalCups = minOf((waterAmount / 200) as Int, minOf(milkAmount / 50 as Int, beansAmount / 15 as Int))
    fun getCoffee(cups: Int) {
        val cups = totalCups - cups
        when {
            cups == 0 -> println("Yes, I can make that amount of coffee")
            cups > 0 -> println("Yes, I can make that amount of coffee (and even $cups more than that)")
            cups < 0 -> println("No, I can make only $totalCups cups of coffee")
        }
    }

    fun start() {
        println(
            "The coffee machine has:\n" + "$waterAmount ml of water\n" + "$milkAmount ml of milk\n" + "$beansAmount g of coffee beans\n" + "$disposableCups disposable cups\n" + "\$$money of money\n"
        )
        getAction()
    }

    private fun displayData() {
        println()
        println(
            "The coffee machine has:\n" + "$waterAmount ml of water\n" + "$milkAmount ml of milk\n" + "$beansAmount g of coffee beans\n" + "$disposableCups disposable cups\n" + "\$$money of money\n"
        )
    }

    private fun getAction() {
        println("Write action (buy, fill, take):")
        action = readln()
        performAction()
    }


    private fun performAction() {
        when (action) {
            "buy" -> actionBuy()
            "fill" -> actionFill()
            "take" -> actionTake()
        }
    }

    private fun actionBuy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val coffeeType = readln().toInt()
        when (coffeeType) {
            1 -> buyCoffee(250, 0, 16, 4)
            2 -> buyCoffee(350, 75, 20, 7)
            3 -> buyCoffee(200, 100, 12, 6)
        }
    }

    private fun buyCoffee(requiredWater: Int = 0, requiredMilk: Int = 0, requiredBeans: Int = 0, cost: Int = 0) {
        waterAmount -= requiredWater
        milkAmount -= requiredMilk
        beansAmount -= requiredBeans
        money += cost
        disposableCups--
        displayData()
    }

    private fun actionFill() {
        println("Write how many ml of water you want to add:")
        waterAmount += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milkAmount += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beansAmount += readln().toInt()
        println("Write how many disposable cups you want to add:")
        disposableCups += readln().toInt()
        displayData()
    }

    private fun actionTake() {
        println("I gave you \$$money")
        money = 0
        displayData()
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.start()
}
