package commands;

import tasks.Deadline;
import tasks.Tasklist;
import zenbot.ZenBot;
import exceptions.TaskEmptyDescriptionException;

public class AddDeadline extends Command {
    
    private String commandString;
    private Tasklist tasks;
    private String description;
    private String deadline;
    
    public AddDeadline(String commandString, Tasklist tasks) {
        this.commandString = commandString;
        this.tasks = tasks;
    }

    @Override
    public void execute() throws TaskEmptyDescriptionException {
        description = commandString.substring(9, commandString.indexOf("/by") - 1);
        deadline = commandString.substring(commandString.indexOf("/by") + 4);
        tasks.addTask(new Deadline(description, deadline));

        ZenBot.printSeperatorLine();
        System.out.println("\tBehold, a new endeavor enters the realm: " + description);
        System.out.print("\tThe grand tally of tasks has reached a harmonious count of ");
        System.out.println(tasks.getTaskListSize() + " in all.");
        ZenBot.printSeperatorLine();
    }
}