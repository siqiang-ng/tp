package seedu.address.logic.commands.tagcommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.tag.MeetingLink;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.TagBuilder;

public class LinkAddCommandTest {

    @Test
    public void constructor_nullIndex_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LinkAddCommand(null, new MeetingLink("http://www.google.com/")));
    }

    @Test
    public void constructor_nullLink_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LinkAddCommand(Index.fromOneBased(1), null));
    }

    @Test
    public void execute_linkAcceptedByModel_addSuccessful() throws Exception {
//        ModelStubAcceptingLinkAdded modelStub = new ModelStubAcceptingTagAdded();
//        Tag validTag = new TagBuilder().build();
//
//        CommandResult commandResult = new TagAddCommand(validTag).execute(modelStub);
//
//        assertEquals(String.format(TagAddCommand.MESSAGE_SUCCESS, validTag), commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validTag), modelStub.tagsAdded);
    }

    @Test
    public void execute_linkAlreadyExists_throwsCommandException() {

    }

    @Test
    public void execute_invalidTagIndex_throwsCommandException() {

    }

    @Test
    public void equals() {
        Tag cs2101 = new TagBuilder().withTagName("cs2101").build();
        Tag cs2103t = new TagBuilder().withTagName("cs2103t").build();
        TagAddCommand add2101Command = new TagAddCommand(cs2101);
        TagAddCommand add2103tCommand = new TagAddCommand(cs2103t);

        // same object -> returns true
        assertTrue(add2101Command.equals(add2101Command));

        // same values -> returns true
        TagAddCommand add2101CommandCopy = new TagAddCommand(cs2101);
        assertTrue(add2101Command.equals(add2101CommandCopy));

        // different types -> returns false
        assertFalse(add2101Command.equals(1));

        // null -> returns false
        assertFalse(add2101Command.equals(null));

        // different person -> returns false
        assertFalse(add2101Command.equals(add2103tCommand));
    }
}
