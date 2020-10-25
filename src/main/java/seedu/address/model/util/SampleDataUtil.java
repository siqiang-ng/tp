package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Projact;
import seedu.address.model.ReadOnlyProjact;
import seedu.address.model.person.Email;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonName;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TelegramAddress;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code Projact} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new PersonName("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new TelegramAddress("alex_yeoh"), getTagSet("friends")),
            new Person(new PersonName("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new TelegramAddress("berniceYu"), getTagSet("colleagues", "friends")),
            new Person(new PersonName("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new TelegramAddress("char_Oli"), getTagSet("neighbours")),
            new Person(new PersonName("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new TelegramAddress("david123"), getTagSet("family")),
            new Person(new PersonName("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new TelegramAddress("Irfan_Ibrahim24"), getTagSet("classmates")),
            new Person(new PersonName("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new TelegramAddress("RoyBalak111"), getTagSet("colleagues"))
        };
    }

    public static Tag[] getSampleTags() {
        return new Tag[] {
            new Tag("colleagues"),
            new Tag("neighbours"),
            new Tag("classmates"),
            new Tag("family"),
            new Tag("friends")
        };
    }



    public static ReadOnlyProjact getSampleProjact() {
        Projact sampleAb = new Projact();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }

        for (Tag sampleTag : getSampleTags()) {
            sampleAb.addTag(sampleTag);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a person set containing the list of strings given.
     */
    public static Set<PersonName> getPersonSet(String... strings) {
        return Arrays.stream(strings)
                .map(PersonName::new)
                .collect(Collectors.toSet());
    }

}
