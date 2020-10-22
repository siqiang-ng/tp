package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Name;

public class JsonAdaptedPersonName {
    private final String name;

    /**
     * Constructs a {@code JsonAdaptedPersonName} with the given {@code name}.
     */
    @JsonCreator
    public JsonAdaptedPersonName(String name) {
        this.name = name;
    }

    /**
     * Converts a given {@code Name} into this class for Jackson use.
     */
    public JsonAdaptedPersonName(Name source) {
        name = source.fullName;
    }

    @JsonValue
    public String getPersonName() {
        return name;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Name} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Name toModelType() throws IllegalValueException {
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(name);
    }
}
