package seedu.address.model.tag;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;


/**
 * Represents a Tag in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Tag {

    // Identity fields
    private final TagName name;

    /**
      * Every field must be present and not null.
      */
    public Tag(TagName name) {
        requireAllNonNull(name);
        this.name = name;
    }

    /**
     * Every field must be present and not null.
     */
    public Tag(String name) {
        requireAllNonNull(name);
        this.name = new TagName(name);
    }

    public TagName getTagName() {
        return name;
    }


    //    /**
    //     * Returns an immutable person set, which throws {@code UnsupportedOperationException}
    //     * if modification is attempted.
    //     */
    //    public Set<Name> getPersons() {
    //        return Collections.unmodifiableSet(persons);
    //    }


    /**
     * Returns true if both tags have the same name
     * This defines a weaker notion of equality between two tags.
     */
    public boolean isSameTag(Tag otherTag) {
        return this.equals(otherTag);
    }

    /**
     * Returns true if both tags have the same name and data fields.
     * This defines a stronger notion of equality between two tags.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tag // instanceof handles nulls
                && getTagName().equals(((Tag) other).getTagName())); // state check
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTagName());
        //                .append(" Persons: ");
        //        getPersons().forEach(builder::append);
        return builder.toString();
    }

}
