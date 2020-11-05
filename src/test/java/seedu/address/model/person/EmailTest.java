package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Email(null));
    }

    @Test
    public void constructor_invalidEmail_throwsIllegalArgumentException() {
        String invalidEmail = "";
        assertThrows(IllegalArgumentException.class, () -> new Email(invalidEmail));
    }

    @Test
    public void isValidEmail() {
        // null email
        assertThrows(NullPointerException.class, () -> Email.isValidEmail(null));

        // blank email
        assertFalse(Email.isValidEmail("")); // empty string
        assertFalse(Email.isValidEmail(" ")); // spaces only

        // missing parts
        assertFalse(Email.isValidEmail("@example.com")); // missing local part
        assertFalse(Email.isValidEmail("peterjackexample.com")); // missing '@' symbol
        assertFalse(Email.isValidEmail("peterjack@.com")); // missing domain name
        assertFalse(Email.isValidEmail("peterjack@-")); // missing domain extension

        // invalid parts
        assertFalse(Email.isValidEmail("peterjack@-.com")); // invalid domain name
        assertFalse(Email.isValidEmail(" peterjack@example.com")); // leading space
        assertFalse(Email.isValidEmail("peterjack@example.com ")); // trailing space
        assertFalse(Email.isValidEmail("peterjack@@example.com")); // double '@' symbol


        // local parts
        assertFalse(Email.isValidEmail("peter@jack@example.com")); // '@' symbol in local part
        assertFalse(Email.isValidEmail("peter jack@example.com")); // spaces in local part

        // domain server name
        assertFalse(Email.isValidEmail("peterjack@exam_ple.com")); // underscore in domain server name
        assertFalse(Email.isValidEmail("peterjack@exam ple.com")); // spaces in domain server name
        assertFalse(Email.isValidEmail("peterjack@-example.com")); // domain server name starts with a hyphen
        assertFalse(Email.isValidEmail("peterjack@example-.com")); // domain server name ends with a hyphen

        // domain extension
        assertFalse(Email.isValidEmail("peterjack@example.c")); // domain extension has less than 2 characters
        assertFalse(Email.isValidEmail("peterjack@example.co_m")); // underscore in domain extension
        assertFalse(Email.isValidEmail("peterjack@example.co m")); // spaces in domain extension
        assertFalse(Email.isValidEmail("peterjack@example..com")); // domain extension starts with a period
        assertFalse(Email.isValidEmail("peterjack@example.com.")); // domain extension ends with a period
        assertFalse(Email.isValidEmail("peterjack@example.-com")); // domain extension starts with a hyphen
        assertFalse(Email.isValidEmail("peterjack@example.com-")); // domain extension ends with a hyphen

        // valid email
        assertTrue(Email.isValidEmail("PeterJack_1190@example.com"));
        assertTrue(Email.isValidEmail("test@localhost.com")); // alphabets only
        assertTrue(Email.isValidEmail("123@123.123")); // numbers only
        assertTrue(Email.isValidEmail("test@u.com")); // 1 character long server name
        assertTrue(Email.isValidEmail("!#$%&'*+/=?`{|}~^.-@example.org")); // special characters local part
        assertTrue(Email.isValidEmail("a1+be!@example1.com")); // mixture of alphanumeric and special characters
        assertTrue(Email.isValidEmail("a1+be!@1example1.1com1")); // first and last characters for domain are numbers
        assertTrue(Email.isValidEmail("peter_jack@very-very-very-long-example.com")); // long domain server name
        assertTrue(Email.isValidEmail("if.you.dream.it_you.can.do.it@example.com")); // long local part
        // long domain extension with periods
        assertTrue(Email.isValidEmail("peterjack@example.long.long.long.extension"));
        // long domain extension with hyphens
        assertTrue(Email.isValidEmail("peterjack@example.long-long-long-extension"));
        // long domain extension with hyphens and periods
        assertTrue(Email.isValidEmail("peterjack@example.long-long.long.extension"));
    }
}
