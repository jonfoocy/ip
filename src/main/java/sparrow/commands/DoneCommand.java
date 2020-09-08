package sparrow.commands;

import sparrow.data.exceptions.FileErrorException;
import sparrow.data.task.Task;
import sparrow.data.task.TaskList;
import sparrow.storage.Storage;
import sparrow.ui.Ui;

public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_COMPLETED_TASK_SUCCESS =
            "Great job! I've marked this task as completed: \n\t%s";

    public DoneCommand(int indexToDelete) {
        super(indexToDelete);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task completedTask = tasks.markAsDone(getTargetIndex());
            storage.saveToFile(tasks);
            return String.format(MESSAGE_COMPLETED_TASK_SUCCESS, completedTask);
        } catch (IndexOutOfBoundsException e) {
            return "INDEX OUT OF BOUNDS";
        } catch (FileErrorException fee) {
            return fee.getMessage();
        }
    }
}
