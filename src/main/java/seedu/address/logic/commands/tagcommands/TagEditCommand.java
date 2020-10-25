package seedu.address.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TAGS;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.PersonName;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

/**
 * Edits the details of an existing tag in the tag list.
 */
public class TagEditCommand extends Command {

    public static final String COMMAND_WORD = "tagedit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the name of the tag identified "
            + "by the index number used in the displayed tag list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TAG + "TAG NAME\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TAG + "CS2101";

    public static final String MESSAGE_EDIT_TAG_SUCCESS = "Edited Tag: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_TAG = "This tag already exists in Projact.";

    private final Index index;
    private final EditTagDescriptor editTagDescriptor;

    /**
     * @param index of the tag in the filtered tag list to edit
     * @param editTagDescriptor details to edit the tag with
     */
    public TagEditCommand(Index index, EditTagDescriptor editTagDescriptor) {
        requireNonNull(index);
        requireNonNull(editTagDescriptor);

        this.index = index;
        this.editTagDescriptor = new EditTagDescriptor(editTagDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Tag> lastShownList = model.getFilteredTagList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
        }

        Tag tagToEdit = lastShownList.get(index.getZeroBased());
        Tag editedTag = createEditedTag(tagToEdit, editTagDescriptor);

        if (!tagToEdit.isSameTag(editedTag) && model.hasTag(editedTag)) {
            throw new CommandException(MESSAGE_DUPLICATE_TAG);
        }

        model.setTag(tagToEdit, editedTag);
        model.updateFilteredTagList(PREDICATE_SHOW_ALL_TAGS);
        return new CommandResult(String.format(MESSAGE_EDIT_TAG_SUCCESS, tagToEdit, editedTag));
    }

    /**
     * Creates and returns a {@code Tag} with the name of {@code tagToEdit}
     * edited with {@code editTagDescriptor}.
     */
    private static Tag createEditedTag(Tag tagToEdit, EditTagDescriptor editTagDescriptor) {
        assert tagToEdit != null;

        // currently only the name of the tag can be edited
        TagName updatedTagName = editTagDescriptor.getTagName().get();
        Set<Name> persons = tagToEdit.getPersons();
        return new Tag(updatedTagName, persons);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TagEditCommand)) {
            return false;
        }

        // state check
        TagEditCommand e = (TagEditCommand) other;
        return index.equals(e.index)
                && editTagDescriptor.equals(e.editTagDescriptor);
    }

    /**
     * Stores the details to edit the tag with. The name will replace the
     * corresponding name of the tag.
     */
    public static class EditTagDescriptor {
        private TagName tagName;
<<<<<<< HEAD:src/main/java/seedu/address/logic/commands/TagEditCommand.java
=======
        private Set<PersonName> persons;
>>>>>>> a81afe4bcc11b1b997611f901a999c24465b1e30:src/main/java/seedu/address/logic/commands/tagcommands/TagEditCommand.java

        public EditTagDescriptor() {}

        /**
         * Copy constructor.
         */
        public EditTagDescriptor(EditTagDescriptor toCopy) {
            setTagName(toCopy.tagName);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull();
        }

        public void setTagName(TagName tagName) {
            this.tagName = tagName;
        }

        public Optional<TagName> getTagName() {
            return Optional.ofNullable(tagName);
        }

<<<<<<< HEAD:src/main/java/seedu/address/logic/commands/TagEditCommand.java
=======
        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setPersons(Set<PersonName> persons) {
            this.persons = (persons != null) ? new HashSet<>(persons) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<PersonName>> getPersons() {
            return (persons != null) ? Optional.of(Collections.unmodifiableSet(persons)) : Optional.empty();
        }

>>>>>>> a81afe4bcc11b1b997611f901a999c24465b1e30:src/main/java/seedu/address/logic/commands/tagcommands/TagEditCommand.java
        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditTagDescriptor)) {
                return false;
            }

            // state check
            EditTagDescriptor e = (EditTagDescriptor) other;

            return getTagName().equals(e.getTagName());
        }
    }
}
