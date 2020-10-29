package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.tag.TagTask;

public class JsonAdaptedTagTaskTest {
    private static final String VALID_TAG_TASK_DESC = "CS2103T tutorial";

    private static final TagTask VALID_TAG_TASK = new TagTask(VALID_TAG_TASK_DESC, false);

    @Test
    public void toModelType_validTaTaskDetails_returnsTagTask() throws Exception {
        JsonAdaptedTagTask tagTask = new JsonAdaptedTagTask(VALID_TAG_TASK);
        assertEquals(VALID_TAG_TASK, tagTask.toModelType());
    }
}
