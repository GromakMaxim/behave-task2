package org.myorg;

import java.util.ArrayList;
import java.util.List;

/*Invoker class
*
*Вызывающий объект - это объект, который знает, как выполнить данную команду, но не знает, как она была реализована.
* Он знает только интерфейс команды.
В некоторых случаях вызывающий также сохраняет и ставит в очередь команды, помимо их выполнения.
* Это полезно для реализации некоторых дополнительных функций, таких как запись макросов или функции отмены и повтора.
*/
public class OperationExecutor {
    private final List<FrogCommand> frogCommandArrList = new ArrayList<>();
    private int currentCommand = 0;//сохраняет текущую позицию(команду) в arrlist

    public void registerOperation(FrogCommand command) {
        frogCommandArrList.add(command);
        currentCommand++;
    }

    public void execute() {
        currentCommand = frogCommandArrList.size() - 1;
        FrogCommand command = frogCommandArrList.get(frogCommandArrList.size() - 1);//выполняется последняя по счету команда в арейлисте
        command.execute();
    }

    //<<
    public void undo() {//вернуть на 1 команду назад
        if (currentCommand < 0) {//убедиться, что действия для отмены ещё есть
            System.out.println("Нет команд для отмены!");
        } else {
            FrogCommand command = frogCommandArrList.get(currentCommand);
            command.undo();
            currentCommand--;
        }
    }

    //>>
    public void redo() {
        if (currentCommand != frogCommandArrList.size() - 1 && currentCommand < frogCommandArrList.size() - 1) {
            currentCommand++;
            FrogCommand command = frogCommandArrList.get(currentCommand);//
            command.redo();
        } else {
            System.out.println("Нет отменённых команд!");
        }
    }

    //!!
    public void repeat() {
        if (frogCommandArrList.size() > 0 && currentCommand > 0) {
            FrogCommand command = frogCommandArrList.get(currentCommand);
            command.execute();
        } else {
            System.out.println("Список команд пуст! Не могу повторить!");
        }

    }
}
