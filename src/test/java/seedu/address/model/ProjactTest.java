package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_ADDRESS_BOB;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalProjact;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.PersonBuilder;

public class ProjactTest {

    private final Projact projact = new Projact();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), projact.getPersonList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> projact.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyProjact_replacesData() {
        Projact newData = getTypicalProjact();
        projact.resetData(newData);
        assertEquals(newData, projact);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Person editedAlice = new PersonBuilder(ALICE).withTelegramAddress(VALID_TELEGRAM_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        List<Person> newPersons = Arrays.asList(ALICE, editedAlice);
        ProjactStub newData = new ProjactStub(newPersons);

        assertThrows(DuplicatePersonException.class, () -> projact.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> projact.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInProjact_returnsFalse() {
        assertFalse(projact.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInProjact_returnsTrue() {
        projact.addPerson(ALICE);
        assertTrue(projact.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInProjact_returnsTrue() {
        projact.addPerson(ALICE);
        Person editedAlice = new PersonBuilder(ALICE).withTelegramAddress(VALID_TELEGRAM_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(projact.hasPerson(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> projact.getPersonList().remove(0));
    }

    /**
     * A stub ReadOnlyProjact whose persons list can violate interface constraints.
     */
    private static class ProjactStub implements ReadOnlyProjact {
        private final ObservableList<Person> persons = FXCollections.observableArrayList();

        ProjactStub(Collection<Person> persons) {
            this.persons.setAll(persons);
        }

        @Override
        public ObservableList<Person> getPersonList() {
            return persons;
        }
    }

}
