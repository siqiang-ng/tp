package seedu.address.ui;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * Panel containing the list of tags.
 */
public class TagListPanel extends UiPart<Region> {
    private static final String FXML = "TagListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TagListPanel.class);
    private final Function<Tag, List<Person>> findContactsByTag;

    @FXML
    private ListView<Tag> tagListView;

    /**
     * Creates a {@code TagListPanel} with the given {@code ObservableList}.
     */
    public TagListPanel(ObservableList<Tag> tagList, Function<Tag, List<Person>> findContactsByTag) {
        super(FXML);
        tagListView.setItems(tagList);
        tagListView.setCellFactory(listView -> new TagListViewCell());
        this.findContactsByTag = findContactsByTag;
    }

    /**
     * Refreshes the TagListPanel.
     */
    void refresh() {
        this.tagListView.refresh();
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Tag} using a {@code TagCard}.
     */
    class TagListViewCell extends ListCell<Tag> {
        @Override
        protected void updateItem(Tag tag, boolean empty) {
            super.updateItem(tag, empty);

            if (empty || tag == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TagCard(tag, getIndex() + 1, findContactsByTag.apply(tag)).getRoot());
            }
        }
    }

}
