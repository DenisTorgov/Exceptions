package org.example;

class MyErrors extends Exception {
//    public UncompleteData() {
//    }
}
class UncompleteData extends MyErrors {
    public String msg() {
        return "Количество элементов должно быть равно 6.";
    }
}
class NotStringData extends MyErrors {
    public String msg() {
        return "Введите Фамилию Имя Отчество буквами через пробел";
    }
}
class DayOutOfLimits extends MyErrors {
    public String msg() {
        return "День не может быть меньше 0 и больше 31";
    }
}
class MonthOutOfLimits extends MyErrors {
    public String msg() {
        return "Месяц не может быть меньше 0 и больше 12";
    }
}
class YearOutOfLimits extends MyErrors {
    public String msg() {
        return "Год не может быть меньше 0";
    }
}
class UnKnownSex extends MyErrors {
    public String msg() {
        return "Для обозначения пола наберите m для мужчин и f для женщин";
    }
}