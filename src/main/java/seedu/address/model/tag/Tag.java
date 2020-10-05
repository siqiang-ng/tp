package seedu.address.model.tag;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Name;

/**
 * Represents a Tag in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Tag {

    // Identity fields
    private final TagName name;

    // Data fields
    private final Set<Name> persons = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Tag(TagName name, Set<Name> persons) {
        requireAllNonNull(name, persons);
        this.name = name;
        this.persons.addAll(persons);
    }

    public TagName getTagName() {
        return name;
    }

    /**
     * Returns an immutable person set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Name> getPersons() {
        return Collections.unmodifiableSet(persons);
    }

    /**
     * Returns true if both tags of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two tags.
     */
    public boolean isSameTag(Tag otherTag) {
        if (otherTag == this) {
            return true;
        }

        return otherTag != null && otherTag.getTagName().equals(getTagName());
    }

    /**
     * Returns true if both tags have the same identity and data fields.
     * This defines a stronger notion of equality between two tags.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return otherTag.getTagName().equals(getTagName())
                && otherTag.getPersons().equals(getPersons());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, persons);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTagName())
                .append(" Persons: ");
        getPersons().forEach(builder::append);
        return builder.toString();
    }

    // PLACEHOLDERS/QUICK FIX - DO NOT USE
    public String tagName;
    public static final String MESSAGE_CONSTRAINTS = "";
    public Tag(String tagName) { this.name = new TagName(""); }
    public static boolean isValidTagName(String tagName) { return true; }

}
