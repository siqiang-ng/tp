package seedu.address.ui;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.tag.Tag;

/**
 * An UI component that displays information of a {@code Tag}.
 */
public class TagCard extends UiPart<Region> {

    private static final String FXML = "TagListCard.fxml";

    private final Tag tag;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;

    /**
     * Creates a {@code TagCard} with the given {@code Tag} and index to display.
     */
    public TagCard(Tag tag, int displayedIndex) {
        super(FXML);
        Objects.requireNonNull(tag);
        this.tag = tag;
        id.setText(displayedIndex + ". ");
        name.setText(tag.getTagName().tagName);
    }

    /**
     * Indicates whether some obj object is "equal to" this one.
     * Two {@code TagCard}s are equivalent if they represent the same {@code Tag}.
     *
     * @param obj the reference object with which to compare
     * @return true if the two objects are equivalent, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagCard)) {
            return false;
        }
        TagCard tagCard = (TagCard) obj;
        return tag.equals(tagCard.tag);
    }

    /**
     * Returns a hash code value for {@code TagCard}.
     * The hash code value for {@code TagCard} is equivalent to
     * the hash code value of the {@code Tag} contained within.
     *
     * @return a hash code value for this {@code TagCard}
     */
    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }
}
