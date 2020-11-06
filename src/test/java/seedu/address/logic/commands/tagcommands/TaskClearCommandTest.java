package seedu.address.logic.commands.tagcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.tagcommands.TaskClearCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalProjact.getTypicalProjact;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tag.Tag;

public class TaskClearCommandTest {
    private Model model = new ModelManager(getTypicalProjact(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalProjact(), new UserPrefs());

    @Test
    public void equals() {
        TaskClearCommand commandOne = new TaskClearCommand();
        TaskClearCommand commandTwo = new TaskClearCommand();

        // same object -> returns true
        assertTrue(commandOne.equals(commandOne));

        // different types -> returns false
        assertFalse(commandOne.equals(1));

        // null -> returns false
        assertFalse(commandOne.equals(null));

        // different tag -> returns false
        assertFalse(commandOne.equals(commandTwo));
    }

    @Test
    public void execute_clearTaskCommand_success() {
        String expectedMessage = MESSAGE_SUCCESS;
        CommandResult expectedResult = new CommandResult(
                expectedMessage, false, false, false, false, true, false);
        TaskClearCommand command = new TaskClearCommand();

        for (Tag tag : expectedModel.getFilteredTagList()) {
            tag.clearCompletedTasks();
        }

        expectedModel.updateFilteredTagList(Model.PREDICATE_SHOW_ALL_TAGS);
        assertCommandSuccess(command, model, expectedResult, expectedModel);
    }
}
