package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.tag.TagName;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final Projact projact;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private Predicate<TagName> filteredTagPredicate = x -> true;

    /**
     * Initializes a ModelManager with the given projact and userPrefs.
     */
    public ModelManager(ReadOnlyProjact projact, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(projact, userPrefs);

        logger.fine("Initializing with address book: " + projact + " and user prefs " + userPrefs);

        this.projact = new Projact(projact);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.projact.getPersonList());
    }

    public ModelManager() {
        this(new Projact(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getProjactFilePath() {
        return userPrefs.getProjactFilePath();
    }

    @Override
    public void setProjactFilePath(Path projactFilePath) {
        requireNonNull(projactFilePath);
        userPrefs.setProjactFilePath(projactFilePath);
    }

    //=========== Projact ================================================================================

    @Override
    public void setProjact(ReadOnlyProjact projact) {
        this.projact.resetData(projact);
    }

    @Override
    public ReadOnlyProjact getProjact() {
        return projact;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return projact.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        projact.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        projact.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        projact.setPerson(target, editedPerson);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedProjact}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    //=========== Filtered Tag List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Tag} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<TagName> getFilteredTagList() {
        ObservableList<TagName> observableList = this.projact.getPersonList()
                .stream()
                .map(Person::getTags)
                .flatMap(Set::stream)
                .filter(filteredTagPredicate)
                .collect(Collectors.toCollection(HashSet::new))
                .stream()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        return new FilteredList<TagName>(observableList);
    }

    @Override
    public void updateFilteredTagList(Predicate<TagName> predicate) {
        requireNonNull(predicate);
        filteredTagPredicate = predicate;
    }


    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return projact.equals(other.projact)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons);
    }

}
