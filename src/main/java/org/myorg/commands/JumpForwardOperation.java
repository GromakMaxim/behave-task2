package org.myorg.commands;

import org.myorg.Frog;
import org.myorg.FrogCommand;

/*Command class
 *Команда - это объект, роль которого состоит в том, чтобы хранить всю информацию, необходимую для выполнения действия,
 * включая вызываемый метод, аргументы метода и объект (известный как получатель), который реализует метод.
 * */
public class JumpForwardOperation implements FrogCommand {
    private final Frog frog;
    private final int stepsNumber;

    public JumpForwardOperation(Frog frog, int stepsNumber) {
        this.frog = frog;
        this.stepsNumber = stepsNumber;
    }

    @Override
    public String execute() {//прыгнуть вперёд
        return String.valueOf(frog.jumpForward(stepsNumber));
    }

    @Override
    public String undo() {//обратное действие - прыгнуть назад
        return String.valueOf(frog.jumpBackward(stepsNumber));
    }

    @Override
    public String redo() {//откатить отмену = прыгнуть вперёд
        return String.valueOf(frog.jumpForward(stepsNumber));
    }

}
