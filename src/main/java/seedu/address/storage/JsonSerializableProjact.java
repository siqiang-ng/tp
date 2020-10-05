package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.Projact;
import seedu.address.model.ReadOnlyProjact;
import seedu.address.model.person.Person;

/**
 * An Immutable Projact that is serializable to JSON format.
 */
@JsonRootName(value = "projact")
class JsonSerializableProjact {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableProjact} with the given persons.
     */
    @JsonCreator
    public JsonSerializableProjact(@JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlyProjact} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableProjact}.
     */
    public JsonSerializableProjact(ReadOnlyProjact source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
    }

    /**
     * Converts this Projact into the model's {@code Projact} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Projact toModelType() throws IllegalValueException {
        Projact projact = new Projact();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            if (projact.hasPerson(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            projact.addPerson(person);
        }
        return projact;
    }

}
