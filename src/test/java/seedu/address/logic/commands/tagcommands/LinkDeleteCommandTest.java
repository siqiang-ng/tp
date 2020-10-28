package seedu.address.logic.commands.tagcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showTagAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TAG;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_TAG;
import static seedu.address.testutil.TypicalProjact.getTypicalProjact;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tag.Tag;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code LinkDeleteCommand}.
 */
public class LinkDeleteCommandTest {

    private Model model = new ModelManager(getTypicalProjact(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Tag tagToDelete = model.getFilteredTagList().get(INDEX_FIRST_TAG.getZeroBased());
        LinkDeleteCommand linkDeleteCommand = new LinkDeleteCommand(INDEX_FIRST_TAG);

        String expectedMessage = String.format(LinkDeleteCommand.MESSAGE_DELETE_LINK_SUCCESS,
                tagToDelete.getMeetingLink(), tagToDelete.getTagName());

        ModelManager expectedModel = new ModelManager(model.getProjact(), new UserPrefs());
        expectedModel.setTag(tagToDelete, new Tag(tagToDelete.getTagName(),
                                                tagToDelete.getTagTasks(),
                                                Optional.empty()));

        assertCommandSuccess(linkDeleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTagList().size() + 1);
        LinkDeleteCommand linkDeleteCommand = new LinkDeleteCommand(outOfBoundIndex);

        assertCommandFailure(linkDeleteCommand, model, Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTagAtIndex(model, INDEX_FIRST_TAG);

        Tag tagToDelete = model.getFilteredTagList().get(INDEX_FIRST_TAG.getZeroBased());
        LinkDeleteCommand linkDeleteCommand = new LinkDeleteCommand(INDEX_FIRST_TAG);

        String expectedMessage = String.format(LinkDeleteCommand.MESSAGE_DELETE_LINK_SUCCESS,
                tagToDelete.getMeetingLink(), tagToDelete.getTagName());

        Model expectedModel = new ModelManager(model.getProjact(), new UserPrefs());
        expectedModel.setTag(tagToDelete, new Tag(tagToDelete.getTagName(),
                tagToDelete.getTagTasks(),
                Optional.empty()));

        assertCommandSuccess(linkDeleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTagAtIndex(model, INDEX_FIRST_TAG);

        Index outOfBoundIndex = INDEX_SECOND_TAG;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getProjact().getTagList().size());

        LinkDeleteCommand linkDeleteCommand = new LinkDeleteCommand(outOfBoundIndex);

        assertCommandFailure(linkDeleteCommand, model, Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        LinkDeleteCommand deleteFirstCommand = new LinkDeleteCommand(INDEX_FIRST_TAG);
        LinkDeleteCommand deleteSecondCommand = new LinkDeleteCommand(INDEX_SECOND_TAG);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        LinkDeleteCommand deleteFirstCommandCopy = new LinkDeleteCommand(INDEX_FIRST_TAG);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different tag -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }
}
