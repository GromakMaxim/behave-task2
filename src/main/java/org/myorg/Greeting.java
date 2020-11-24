package org.myorg;

public class Greeting {
    public void welcomeIntro(){
        System.out.println("Привет, я Лягух! Моё управление сделано через паттерн Command!");
        System.out.println("Вот моё управление: ");
        System.out.println("Введи \"положительное число\" - прыгни на N шагов направо");
        System.out.println("Введи \"отрицательное число\" - прыгни на N шагов налево");
        System.out.println("<< - Undo (отмени последнюю команду)");
        System.out.println(">> - Redo (повтори отменённую команду)");
        System.out.println("!! - повтори последнюю команду");
        System.out.println("0 или end - выход");
    }
}
