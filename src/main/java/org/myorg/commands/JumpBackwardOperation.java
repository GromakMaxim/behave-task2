package org.myorg.commands;

import org.myorg.Frog;
import org.myorg.FrogCommand;

/*Command class*/
public class JumpBackwardOperation implements FrogCommand {
    private final Frog frog;
    private final int stepsNumber;

    public JumpBackwardOperation(Frog frog, int stepsNumber) {
        this.frog = frog;
        this.stepsNumber = stepsNumber;
    }

    @Override
    public String execute() {//прямое действие - прыгнуть назад
        return String.valueOf(frog.jumpBackward(stepsNumber));
    }

    @Override
    public String undo() {//обратное действие - прыгнуть вперёд
        return String.valueOf(frog.jumpForward(stepsNumber));
    }

    @Override
    public String redo() {//откатить отмену = прыгнуть назад
        return String.valueOf(frog.jumpBackward(stepsNumber));
    }


}