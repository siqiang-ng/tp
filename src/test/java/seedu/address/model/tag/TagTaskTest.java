package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class TagTaskTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TagTask(null, true));
    }

    @Test
    public void constructor_invalidTaskDescription_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new TagTask(" ", true));
    }

    @Test
    public void isValidTaskDescription() {
        // null description
        assertThrows(NullPointerException.class, () -> TagTask.isValidTaskDescription(null));

        // Invalid description
        assertFalse(TagTask.isValidTaskDescription(""));
        assertFalse(TagTask.isValidTaskDescription(" "));
        assertFalse(TagTask.isValidTaskDescription(" abc "));
        assertFalse(TagTask.isValidTaskDescription("_abc"));

        // Valid description
        assertTrue(TagTask.isValidTaskDescription("abc"));
        assertTrue(TagTask.isValidTaskDescription("ABC"));
        assertTrue(TagTask.isValidTaskDescription("123"));
        assertTrue(TagTask.isValidTaskDescription("with spacing and underscore_ "));
        assertTrue(TagTask.isValidTaskDescription("valid symbol !@#"));
    }

    @Test
    public void clearCompletedTasks() {
        List<TagTask> allCompletedTasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            allCompletedTasks.add(new TagTask("a" + i, true));
        }
        Tag completedTag = new Tag(new TagName("a"), allCompletedTasks, Optional.empty());
        Tag expectedCompletedTag = new Tag(new TagName("a"), new ArrayList<>(), Optional.empty());
        completedTag.clearCompletedTasks();
        assertEquals(completedTag, expectedCompletedTag);


        List<TagTask> halfCompletedTasks = new ArrayList<>();
        List<TagTask> expectedHalfCompletedTasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 1) {
                expectedHalfCompletedTasks.add(new TagTask("a" + i, false));
            }
            halfCompletedTasks.add(new TagTask("a" + i, i % 2 == 0 ? true : false));
        }
        Tag halfCompletedTag = new Tag(new TagName("b"), halfCompletedTasks, Optional.empty());
        Tag expectedHalfCompletedTag = new Tag(new TagName("b"), expectedHalfCompletedTasks, Optional.empty());
        halfCompletedTag.clearCompletedTasks();
        assertEquals(halfCompletedTag, expectedHalfCompletedTag);

        List<TagTask> noCompletedTasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            noCompletedTasks.add(new TagTask("a" + i, false));
        }
        Tag noCompletedTag = new Tag(new TagName("c"), noCompletedTasks, Optional.empty());
        Tag expectedNoCompletedTag = new Tag(new TagName("c"), noCompletedTasks, Optional.empty());
        noCompletedTag.clearCompletedTasks();
        assertEquals(noCompletedTag, expectedNoCompletedTag);
    }
}
