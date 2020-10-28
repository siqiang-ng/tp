package seedu.address.testutil;

import seedu.address.logic.commands.tagcommands.TagEditCommand;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;

/**
 * A utility class to help with building EditTagDescriptor objects.
 */
public class EditTagDescriptorBuilder {

    private TagEditCommand.EditTagDescriptor descriptor;

    public EditTagDescriptorBuilder() {
        descriptor = new TagEditCommand.EditTagDescriptor();
    }

    public EditTagDescriptorBuilder(TagEditCommand.EditTagDescriptor descriptor) {
        this.descriptor = new TagEditCommand.EditTagDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditTagDescriptor} with fields containing {@code tag}'s details
     */
    public EditTagDescriptorBuilder(Tag tag) {
        descriptor = new TagEditCommand.EditTagDescriptor();
        descriptor.setTagName(tag.getTagName());
    }

    /**
     * Sets the {@code tagName} of the {@code EditTagDescriptor} that we are building.
     */
    public EditTagDescriptorBuilder withTagName(String name) {
        descriptor.setTagName(new TagName(name));
        return this;
    }

    public TagEditCommand.EditTagDescriptor build() {
        return descriptor;
    }
}
