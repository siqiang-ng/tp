package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LINK;

import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.tagcommands.LinkAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.MeetingLink;

public class LinkAddCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the LinkAddCommand
     * and returns a LinkAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public LinkAddCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_LINK);

        Index index;
        try {
            index = ParserUtil.parseIndex(args);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, LinkAddCommand.MESSAGE_USAGE), pe);
        }

        Optional<MeetingLink> link = ParserUtil.parseMeetingLink(argMultimap.getValue(PREFIX_LINK).get());
        return new LinkAddCommand(index, link.get());

    }

}
