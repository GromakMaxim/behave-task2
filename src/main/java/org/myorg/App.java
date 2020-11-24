package org.myorg;

import org.myorg.commands.JumpBackwardOperation;
import org.myorg.commands.JumpForwardOperation;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Frog crazyFrog = new Frog();//создаём лягуху
        boolean continueGame = true;
        OperationExecutor operationExecutor = new OperationExecutor();//создаём исполнителя

        Greeting hello = new Greeting();
        hello.welcomeIntro();

        while (continueGame) {
            System.out.println("Жду команды: ");
            String userInput = myScan.nextLine();
            switch (userInput) {
                case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10": //если введено число 1-10 - прыгаем вперёд
                    operationExecutor.registerOperation(new JumpForwardOperation(crazyFrog, Integer.parseInt(userInput)));
                    operationExecutor.execute();
                    break;
                case "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"://если введено число -1 - -10 - прыгаем назад
                    operationExecutor.registerOperation(new JumpBackwardOperation(crazyFrog, -1 * Integer.parseInt(userInput)));
                    operationExecutor.execute();
                    break;
                case "<<": //Undo (отмени последнюю команду)
                    operationExecutor.undo();
                    break;
                case ">>"://Redo (повтори отменённую команду)
                    operationExecutor.redo();
                    break;
                case "!!"://repeat повтори последнюю команду
                    operationExecutor.repeat();
                    break;
                case "0", "end"://выход
                    continueGame = false;
                    break;
                default:
                    System.out.println("Лягух топчется на месте и не понимает, что ему нужно делать");
            }
        }
    }
}
