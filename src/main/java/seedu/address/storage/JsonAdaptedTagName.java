package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.TagName;

/**
 * Jackson-friendly version of {@link TagName}.
 */
class JsonAdaptedTagName {

    private final String tagName;

    /**
     * Constructs a {@code JsonAdaptedTagName} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Converts a given {@code TagName} into this class for Jackson use.
     */
    public JsonAdaptedTagName(TagName source) {
        tagName = source.tagName;
    }

    @JsonValue
    public String getTagName() {
        return tagName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code TagName} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public TagName toModelType() throws IllegalValueException {
        if (!TagName.isValidTagName(tagName)) {
            throw new IllegalValueException(TagName.MESSAGE_CONSTRAINTS);
        }
        return new TagName(tagName);
    }

}
