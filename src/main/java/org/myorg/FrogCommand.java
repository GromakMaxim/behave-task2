package org.myorg;

public interface FrogCommand {
    String execute();//выполни

    String undo();//(отмени последнюю команду (т.е. сделай обратное действие последнему)

    String redo(); //Redo (повтори отменённую команду)

}