package seedu.address.storage;

import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;
import seedu.address.model.tag.TagTask;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedTag {

    private final String tagName;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTag(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Converts a given {@code TagName} into this class for Jackson use.
     */
    public JsonAdaptedTag(Tag source) {
        this.tagName = source.getTagName().tagName;
    }

    @JsonValue
    public String getTagName() {
        return this.tagName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Tag toModelType() throws IllegalValueException {
        if (!TagName.isValidTagName(tagName)) {
            throw new IllegalValueException(TagName.MESSAGE_CONSTRAINTS);
        }
        return new Tag(
                new TagName(tagName),
                new ArrayList<TagTask>(),
                Optional.empty()
        );
    }

}
