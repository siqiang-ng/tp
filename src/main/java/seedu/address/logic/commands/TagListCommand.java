package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TAGS;

/**
 * Lists all tags in the tag list to the user.
 */
public class TagListCommand extends Command {
    public static final String COMMAND_WORD = "tagList";

    public static final String MESSAGE_SUCCESS = "These are the tags in tag list currently.";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTagList(PREDICATE_SHOW_ALL_TAGS);
        return new CommandResult(MESSAGE_SUCCESS, false, false, true);
    }
}
