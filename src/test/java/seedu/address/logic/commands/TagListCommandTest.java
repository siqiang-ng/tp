package seedu.address.logic.commands;


import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalProjact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

class TagListCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalProjact(), new UserPrefs());
        expectedModel = new ModelManager(model.getProjact(), new UserPrefs());
    }

    @Test
    public void execute_tagList_success() {
        CommandResult expectedCommandResult = new CommandResult(TagListCommand.MESSAGE_SUCCESS, false, false, true);
        assertCommandSuccess(new TagListCommand(), model, expectedCommandResult, expectedModel);
    }
}
