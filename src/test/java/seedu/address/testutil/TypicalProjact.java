package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.getTypicalPersons;
import static seedu.address.testutil.TypicalTags.getTypicalTags;

import seedu.address.model.Projact;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class TypicalProjact {

    private TypicalProjact() {} // prevents instantiation

    /**
     * Returns an {@code Projact} with all the typical persons.
     */
    public static Projact getTypicalProjact() {
        Projact projact = new Projact();
        for (Person person : getTypicalPersons()) {
            projact.addPerson(person);
        }

        for (Tag tag : getTypicalTags()) {
            projact.addTag(tag);
        }
        return projact;
    }
}
