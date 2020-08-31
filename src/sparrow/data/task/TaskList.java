package sparrow.data.task;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Encapsulates task list with operations to be carried out on list.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a task list with the input list.
     * @param tasks input task list
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task toAdd) {
        tasks.add(toAdd);
    }
    /**
     * Returns a task list matching the inputted date filter.
     * @param dateFilter User's command and date to filter by.
     * @return Filtered list based on input.
     * @throws DateTimeParseException if date passed cannot be converted to a LocalDate object.
     */
    public ArrayList<Task> filterList(LocalDate dateFilter) throws DateTimeParseException {
        ArrayList<Task> filteredList = new ArrayList<>();

        for (Task task : tasks) {
            LocalDate taskDate;

            // Get date from Deadline/Event
            if (task instanceof Deadline) {
                taskDate = ((Deadline) task).getDueDate();
            } else if (task instanceof Event) {
                taskDate = ((Event) task).getDate();
            } else {
                continue;
            }

            // Check if task's date is on date specified
            if (taskDate.isEqual(dateFilter)) {
                filteredList.add(task);
            }
        }
        return filteredList;
    }

    /**
     * Marks a task in the task list as completed.
     * @param taskNum Task number corresponding to completed task.
     */
    public Task markAsDone(int taskNum) {
        Task completedTask = tasks.get(taskNum - 1);
        completedTask.markAsDone();
        return completedTask;
    }

    /**
     * Deletes a task from the task list.
     * @param taskNum Task number corresponding to the task to be deleted.
     */
    public Task deleteTask(int taskNum) {
        return tasks.remove(taskNum - 1);
    }

    public ArrayList<Task> findTasks(String taskStr) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(taskStr)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
