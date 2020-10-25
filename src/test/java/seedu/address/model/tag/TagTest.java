package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.TypicalTags.COLLEAGUE;
import static seedu.address.testutil.TypicalTags.GROUPMATE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TagBuilder;

public class TagTest {

    @Test
    void isSameTag() {
        // same object -> returns true
        assertTrue(GROUPMATE.isSameTag(GROUPMATE));

        // null -> returns false
        assertFalse(GROUPMATE.isSameTag(null));

        // different name -> returns false
        Tag editedGroupmate = new TagBuilder(GROUPMATE).withName(VALID_TAG_HUSBAND).build();
        assertFalse(GROUPMATE.isSameTag(editedGroupmate));
    }

    @Test
    void testEquals() {
        // same values -> returns true
        Tag groupmateCopy = new TagBuilder(GROUPMATE).build();
        assertTrue(GROUPMATE.equals(groupmateCopy));

        // same object -> returns true
        assertTrue(GROUPMATE.equals(GROUPMATE));

        // null -> returns false
        assertFalse(GROUPMATE.equals(null));

        // different type -> returns false
        assertFalse(GROUPMATE.equals(5));

        // different tag -> returns false
        assertFalse(GROUPMATE.equals(COLLEAGUE));

        // different name -> returns false
        Tag editedGroupmate = new TagBuilder(GROUPMATE).withName(VALID_TAG_HUSBAND).build();
        assertFalse(GROUPMATE.equals(editedGroupmate));
    }
}
