package machine

import kotlin.system.exitProcess


class CoffeeMachine() {
    private var waterAmount = 400
    private var milkAmount = 540
    private var beansAmount = 120
    private var disposableCups = 9
    private var money = 550
    private var action = ""


    private fun start() {
        println()
        getAction()
    }

    private fun displayData() {
        println(
            "The coffee machine has:\n$waterAmount ml of water\n$milkAmount ml of milk\n$beansAmount g of coffee beans\n$disposableCups disposable cups\n\$$money of money"
        )
        start()
    }

     fun getAction() {
        println("Write action (buy, fill, take, remaining, exit):")
        action = readln()
        performAction()
    }


    private fun performAction() {
        println()
        when (action) {
            "buy" -> actionBuy()
            "fill" -> actionFill()
            "take" -> actionTake()
            "remaining" -> displayData()
            "exit"  -> exit()
        }
    }

    private fun exit() {
            exitProcess(10)
    }

    private fun actionBuy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val coffeeType = readln()
        if(coffeeType == "back"){
            start()
        }
        when (coffeeType.toInt()) {
            1 -> buyCoffee(250, 0, 16, 4)
            2 -> buyCoffee(350, 75, 20, 7)
            3 -> buyCoffee(200, 100, 12, 6)
        }
    }

    private fun buyCoffee(requiredWater: Int = 0, requiredMilk: Int = 0, requiredBeans: Int = 0, cost: Int = 0) {
        if(waterAmount < requiredWater){
            println("Sorry, not enough water!")
            start()
        }
        waterAmount -= requiredWater
        if(milkAmount < requiredMilk){
            println("Sorry, not enough milk!")
            start()
        }
        milkAmount -= requiredMilk
        if(beansAmount < requiredBeans){
            println("Sorry, not enough beans!")
            start()
        }
        beansAmount -= requiredBeans
        if (disposableCups < 1){
            println("Sorry, not enough beans!")
            start()
        }
        disposableCups--
        money += cost
        println("I have enough resources, making you a coffee!")
        start()
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
        start()
    }

    private fun actionTake() {
        println("I gave you \$$money")
        money = 0
        start()
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.getAction()
}
