package seedu.address.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagTask;

/**
 * An UI component that displays information of a {@code Tag}.
 */
public class TagCard extends UiPart<Region> {

    private static final String FXML = "TagListCard.fxml";

    private final Tag tag;

    @FXML
    private HBox tagCardPane;
    @FXML
    private Label id;
    @FXML
    private Label tagName;
    @FXML
    private Label meetingLink;
    @FXML
    private FlowPane persons;
    @FXML
    private Label tasks;
    @FXML
    private Label taskid;

    /**
     * Creates a {@code TagCard} with the given {@code Tag} and index to display.
     */
    public TagCard(Tag tag, int displayedIndex, List<Person> personList) {
        super(FXML);
        Objects.requireNonNull(tag);
        this.tag = tag;
        id.setText(displayedIndex + ". ");
        tagName.setText(tag.getTagName().tagName);
        tag.getMeetingLink().ifPresent(link -> meetingLink.setText(link.toString()));
        personList.stream()
                .sorted(Comparator.comparing(person -> person.getName().fullName))
                .forEach(person -> persons.getChildren().add(new Label(person.getName().fullName)));

        List<TagTask> tagTasksList = tag.getTagTasks();
        String taskList = "";
        char start = 'a';
        for (TagTask task : tagTasksList) {
            taskList += start + ". " + task.toString() + "\n";
            start++;
        }

        tasks.setText(taskList);
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
