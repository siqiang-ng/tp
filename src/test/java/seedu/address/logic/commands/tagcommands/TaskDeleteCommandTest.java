package seedu.address.logic.commands.tagcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.showTagAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TAG;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_TAG;
import static seedu.address.testutil.TypicalProjact.getTypicalProjact;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tag.Tag;

public class TaskDeleteCommandTest {
    private Model model = new ModelManager(getTypicalProjact(), new UserPrefs());

    @Test
    public void execute_invalidTagIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTagList().size() + 1);
        TaskDeleteCommand taskDeleteCommand = new TaskDeleteCommand(outOfBoundIndex, INDEX_FIRST_TASK);

        assertCommandFailure(taskDeleteCommand, model, Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidTagIndexFilteredList_failure() {
        showTagAtIndex(model, INDEX_FIRST_TAG);
        Index outOfBoundIndex = INDEX_SECOND_TAG;
        // ensures that outOfBoundIndex is still in bounds of Projact list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getProjact().getTagList().size());

        TaskDeleteCommand taskDeleteCommand = new TaskDeleteCommand(outOfBoundIndex, INDEX_FIRST_TASK);

        assertCommandFailure(taskDeleteCommand, model, Messages.MESSAGE_INVALID_TAG_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        TaskDeleteCommand commandOne = new TaskDeleteCommand(Index.fromZeroBased(1), Index.fromZeroBased(1));
        TaskDeleteCommand commandTwo = new TaskDeleteCommand(Index.fromZeroBased(0), Index.fromZeroBased(1));
        TaskDeleteCommand commandThree = new TaskDeleteCommand(Index.fromZeroBased(1), Index.fromZeroBased(0));

        // same object -> returns true
        assertTrue(commandOne.equals(commandOne));

        // different types -> returns false
        assertFalse(commandOne.equals(1));

        // null -> returns false
        assertFalse(commandOne.equals(null));

        // different index -> returns false
        assertFalse(commandOne.equals(commandTwo));

        // different task index -> return false
        assertFalse(commandOne.equals(commandThree));
    }
}
