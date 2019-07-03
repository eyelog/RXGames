package ru.eyelog.rxgames.utils

class MockNumbers {

    companion object {
        fun generateNumber(): Int {
            return (0..300).random()
        }

        fun generateList(limit: Int): List<Int> {

            val numbers = ArrayList<Int>()
            for (i in 0..limit) {
                numbers.add((0..300).random())
            }
            return numbers
        }

        fun generateIncomeObject(limit: Int): ObjIncome {
            return ObjIncome(
                15,
                "Some Name",
                generateList(limit)
            )
        }
    }
}