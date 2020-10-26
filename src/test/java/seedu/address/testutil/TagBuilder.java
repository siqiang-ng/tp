package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.PersonName;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

public class TagBuilder {

    public static final String DEFAULT_NAME = "friend";

    private TagName name;
    private Set<PersonName> persons;

    /**
     * Creates a {@code TagBuilder} with the default details.
     */
    public TagBuilder() {
        name = new TagName(DEFAULT_NAME);
        persons = new HashSet<>();
    }

    /**
     * Initializes the TagBuilder with the data of {@code tagToCopy}.
     */
    public TagBuilder(Tag tagToCopy) {
        name = tagToCopy.getTagName();
    }

    /**
     * Sets the {@code TagName} of the {@code Tag} that we are building.
     */
    public TagBuilder withTagName(String name) {
        this.name = new TagName(name);
        return this;
    }


    public Tag build() {
        return new Tag(name);
    }
}
