package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Projact;
import seedu.address.model.ReadOnlyProjact;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TelegramAddress;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

/**
 * Contains utility methods for populating {@code Projact} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new TelegramAddress("alex_yeoh"), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new TelegramAddress("berniceYu"), getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new TelegramAddress("char_Oli"), getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new TelegramAddress("david123"), getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new TelegramAddress("Irfan_Ibrahim24"), getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new TelegramAddress("RoyBalak111"), getTagSet("colleagues"))
        };
    }

    public static Tag[] getSampleTags() {
        return new Tag[] {
                new Tag(new TagName("friends"), getPersonSet("Alex Yeoh", "Bernice Yu")),
                new Tag(new TagName("colleagues"), getPersonSet("Bernice Yu", "Roy Balakrishnan")),
                new Tag(new TagName("family"), getPersonSet("David Li")),
                new Tag(new TagName("classmates"), getPersonSet("Irfan Ibrahim")),
                new Tag(new TagName("neighbours"), getPersonSet("Charlotte Oliveiro"))
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
    public static Set<TagName> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(TagName::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a person set containing the list of strings given.
     */
    public static Set<Name> getPersonSet(String... strings) {
        return Arrays.stream(strings)
                .map(Name::new)
                .collect(Collectors.toSet());
    }

}
