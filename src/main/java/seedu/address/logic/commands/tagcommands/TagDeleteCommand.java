package seedu.address.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * Deletes a tag identified using it's displayed index from the tag list.
 */
public class TagDeleteCommand extends Command {

    public static final String COMMAND_WORD = "tagdelete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the tag identified by the index number used in the displayed tag list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_TAG_SUCCESS = "Deleted Tag: %1$s";

    private final Index targetIndex;

    public TagDeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Tag> lastShownList = model.getFilteredTagList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
        }

        Tag tagToDelete = lastShownList.get(targetIndex.getZeroBased());
        List<Person> contactsWithTagToDelete = model.findContactsByTag(tagToDelete);

        for (Person p : contactsWithTagToDelete) {
            Person personToEdit = p;
            Set<Tag> oldTags = p.getTags();
            Set<Tag> newTags = new HashSet<>(oldTags);
            newTags.remove(tagToDelete);
            p.setTags(newTags);
            model.setPerson(personToEdit, p);
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        }

        model.deleteTag(tagToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_TAG_SUCCESS, tagToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagDeleteCommand // instanceof handles nulls
                && targetIndex.equals(((TagDeleteCommand) other).targetIndex)); // state check
    }
}