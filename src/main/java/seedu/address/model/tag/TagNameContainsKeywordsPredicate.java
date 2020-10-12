package seedu.address.model.tag;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Tag}'s {@code Name} matches any of the keywords given.
 */
public class TagNameContainsKeywordsPredicate implements Predicate<TagName> {
    private final List<String> keywords;

    public TagNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(TagName tagName) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(tagName.tagName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((TagNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
