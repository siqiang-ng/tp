package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_NAME_COLLEAGUE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_NAME_HUSBAND;
import static seedu.address.testutil.TypicalTags.COLLEAGUE;
import static seedu.address.testutil.TypicalTags.GROUPMATE;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TagBuilder;

public class TagTest {
    @Test
    public void testLegalConstruction() {
        Tag tag = new Tag(new TagName(VALID_TAG_NAME_COLLEAGUE));
        assertTrue(tag.getTagName().tagName.equals(VALID_TAG_NAME_COLLEAGUE));
        assertTrue(tag.getTagTasks().equals(new ArrayList<TagTask>()));
        assertTrue(tag.getMeetingLink().equals(Optional.empty()));
    }

    @Test
    public void testIllegalConstruction() {
        try {
            Tag tag = new Tag(null);
        } catch (NullPointerException npe) {
            assertTrue(true);
        }
    }

    @Test
    void isSameTag() {
        // same object -> returns true
        assertTrue(GROUPMATE.isSameTag(GROUPMATE));

        // null -> returns false
        assertFalse(GROUPMATE.isSameTag(null));

        // different name -> returns false
        Tag editedGroupmate = new TagBuilder(GROUPMATE).withTagName(VALID_TAG_NAME_HUSBAND).build();
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
        Tag editedGroupmate = new TagBuilder(GROUPMATE).withTagName(VALID_TAG_NAME_HUSBAND).build();
        assertFalse(GROUPMATE.equals(editedGroupmate));
    }
}
