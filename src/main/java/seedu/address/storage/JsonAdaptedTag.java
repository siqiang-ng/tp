package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

/**
 * Jackson-friendly version of {@link TagName}.
 */
class JsonAdaptedTag {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Tag's %s field is missing!";

    private final String tagName;
    private final List<JsonAdaptedPersonName> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTag(@JsonProperty("tagName") String tagName,
                          @JsonProperty("persons") List<JsonAdaptedPersonName> persons) {
        this.tagName = tagName;
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    /**
     * Converts a given {@code TagName} into this class for Jackson use.
     */
    public JsonAdaptedTag(Tag source) {
        tagName = source.getTagName().tagName;
        persons.addAll(source.getPersons().stream()
                        .map(JsonAdaptedPersonName::new)
                        .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Tag toModelType() throws IllegalValueException {
        final List<Name> personNames = new ArrayList<>();

        for (JsonAdaptedPersonName personName : persons) {
            personNames.add(personName.toModelType());
        }

        if (!TagName.isValidTagName(tagName)) {
            throw new IllegalValueException(TagName.MESSAGE_CONSTRAINTS);
        }
        final TagName modelTagName = new TagName(tagName);

        final Set<Name> modelPersons = new HashSet<>(personNames);
        return new Tag(modelTagName, modelPersons);
    }

}
