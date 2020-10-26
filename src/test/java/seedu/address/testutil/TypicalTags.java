package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.Projact;
import seedu.address.model.tag.Tag;

/**
 * A utility class containing a list of {@code Tag} objects to be used in tests.
 */
public class TypicalTags {

    public static final Tag GROUPMATE = new TagBuilder().withTagName("groupmate").build();
    public static final Tag COLLEAGUE = new TagBuilder().withTagName("colleague").build();
    public static final Tag CS2103T = new TagBuilder().withTagName("CS2103T").build();
    public static final Tag CS2040S = new TagBuilder().withTagName("CS2040S").build();
    public static final Tag SEP = new TagBuilder().withTagName("SEP").build();
    public static final Tag HALL = new TagBuilder().withTagName("Hall").build();
    public static final Tag HANDBALL = new TagBuilder().withTagName("Handball").build();

    // Manually added
    public static final Tag SWIMMING = new TagBuilder().withTagName("Swimming").build();
    public static final Tag PROFESSOR = new TagBuilder().withTagName("Professor").build();

    // Manually added - Tag's details found in {@code CommandTestUtil}
    public static final Tag FRIEND = new TagBuilder().withTagName(VALID_TAG_FRIEND).build();
    public static final Tag HUSBAND = new TagBuilder().withTagName(VALID_NAME_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "CS"; // A keyword that matches CS

    private TypicalTags() {} // prevents instantiation

    /**
     * Returns an {@code Projact} with all the typical tags.
     */
    public static Projact getTypicalProjact() {
        Projact ab = new Projact();
        for (Tag tag : getTypicalTags()) {
            ab.addTag(tag);
        }
        return ab;
    }

    public static List<Tag> getTypicalTags() {
        return new ArrayList<>(Arrays.asList(GROUPMATE, COLLEAGUE, CS2103T, CS2040S, SEP, HALL, HANDBALL));
    }
}
