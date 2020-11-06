package seedu.address.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TAGS;

import java.util.List;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.tag.Tag;

public class TaskClearCommand extends Command {
    public static final String COMMAND_WORD = "taskclear";

    public static final String MESSAGE_SUCCESS = "The completed tasks have been cleared.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Tag> lastShownList = model.getFilteredTagList();

        for (Tag tag : lastShownList) {
            tag.clearCompletedTasks();
        }

        model.updateFilteredTagList(PREDICATE_SHOW_ALL_TAGS);
        return new CommandResult(MESSAGE_SUCCESS,
                false, false, false, false, true, false);
    }
}
