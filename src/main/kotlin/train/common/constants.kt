package train.common

import train.classes.City

val CITIES = City.listOf(
    "Москва",
    "Санкт-Петербург",
    "Новосибирск",
    "Екатеринбург",
    "Казань",
    "Нижний Новгород",
    "Челябинск",
    "Самара",
    "Омск",
    "Ростов-на-Дону",
    "Уфа",
    "Красноярск",
    "Воронеж",
    "Пермь",
    "Краснодар"
)

const val MIN_PASSENGERS = 5U
const val MAX_PASSENGERS = 201U

const val MIN_CARRIAGE_CAPACITY = 5U
const val MAX_CARRIAGE_CAPACITY = 25U
