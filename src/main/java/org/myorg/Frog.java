package org.myorg;

/*Invoker class
 *Приемник - это объект, который выполняет набор связанных действий.
 * Это компонент, который выполняет фактическое действие, когда вызывается метод execute () команды.
 * */

public class Frog {
    public static final int MIN_POSITION = 0;//границы поля
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;//стартовая позиция лягухи
    }
    
    public int jumpForward(int stepsNumber) {
        int newPossiblePosition = position + stepsNumber;
        if (checkJumpOpportunity(newPossiblePosition)) {
            position = position + stepsNumber;
            System.out.println("Прыгаю вперед на " + stepsNumber + ". Расстояние " + position);
        } else {
            System.out.println("Я не могу туда прыгнуть! Расстояние " + position);
        }
        return position;
    }

    public int jumpBackward(int stepsNumber) {
        int newPossiblePosition = position - stepsNumber;
        if (checkJumpOpportunity(newPossiblePosition)) {
            position = position - stepsNumber;
            System.out.println("Прыгаю назад на " + stepsNumber + ". Расстояние " + position);
        } else {
            System.out.println("I can't jump there! Расстояние " + position);
        }
        return position;
    }

    private boolean checkJumpOpportunity(int newPossiblePosition) {
        return newPossiblePosition <= MAX_POSITION && newPossiblePosition >= MIN_POSITION;
    }
}