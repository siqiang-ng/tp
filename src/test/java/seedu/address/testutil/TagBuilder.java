package seedu.address.testutil;

import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

public class TagBuilder {

    private static final String DEFAULT_TAGNAME = "CS2103";

    private TagName tagName;

    /**
     * Creates a {@code TagBuilder} with the default details.
     */
    public TagBuilder() {
        this.tagName = new TagName(DEFAULT_TAGNAME);
    }

    /**
     * Initializes the TagBuilder with the data of {@code tagToCopy}.
     */
    public TagBuilder(Tag tagToCopy) {
        this.tagName = tagToCopy.getTagName();
    }

    /**
     * Sets the {@code TagName} of the {@code Tag} that we are building.
     */
    public TagBuilder withTagName(String tagName) {
        this.tagName = new TagName(tagName);
        return this;
    }

    public TagName build() {
        return tagName;
    }

}
