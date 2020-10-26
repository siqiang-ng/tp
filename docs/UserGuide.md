---
layout: page
title: User Guide
---
# Projact User Guide

## Table of Contents
* [Introduction](#introduction)
* [About the User Guide](#about-this-user-guide)
* [Quick Start](#quick-start)
* [Features](#features)
    * [Contact](#_contact-features_)
    * [Tag](#_tag-features_)
* [Command Summary](#command-summary)
* [FAQ](#faq)

--------------------------------------------------------------------------------------------------------------------

## Introduction
Welcome to the *Projact User Guide*!

Projact is a **project and contact management app that helps NUS computing students to organise their fellow computing students' contacts and their teams' meeting links and tasks**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

The Projact application consists of a person list, which stores the contacts of the other computing students, and a tag list, which stores the tags of the modules that the current user is taking in this semester. The user can assign a tag in the tag list to a contact in the person list.

--------------------------------------------------------------------------------------------------------------------

## About this User Guide
This user guide provides in-depth documentation on the features in Projact to facilitate the effective organisation of your contacts. In addition, the quick start guide provides an end-to-end setup process to get you started. 

A basic understanding of how the Command Line Interface works would be good. However, a lack of it would not affect your experience with Projact as prior technical experience is not required.

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `projact.jar` from [here](https://github.com/AY2021S1-CS2103T-T17-4/tp/releases/download/v1.2/projact.jar).

1. Copy the file to the folder you want to use as the _home folder_ for your Projact application.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts in the person list.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com ta/john_doe123` : Adds a contact named `John Doe` to the person list.

   * **`tagadd`**`t/CS210T` : Adds a permanent tag to the tag list.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current person list.

   * **`tagdelete`**`1` : Deletes the tag of index 1 in the tag list.

   * **`clear`** : Deletes all contacts in the person list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Clearing all entries : `clear`

Clears all contact entries from the person list in Projact.

Format: `clear`

### Contact Features

#### Adding a contact: `add`

Adds a contact to the person list.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL ta/TELEGRAM_ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags since he/she is able to take more than one module with the user. (including 0)
</div>

* Listed tags will be created automatically if they are not found in the tag list.

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com ta/john_doe123`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com ta/betsycr0w p/1234567 t/CS2101`

#### Listing all contacts : `list`

Shows a list of all the contacts in the person list.

Format: `list`

#### Editing a contact : `edit`

Edits the contact details of an existing contact in the person list.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [ta/TELEGRAM_ADDRESS] [t/TAG]…​`

* Edits the contact at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the contact will be removed i.e adding of tags is not cumulative.
* You can remove all the contact’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st contact to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd contact to be `Betsy Crower` and clears all existing tags.
*  `edit 2 t/CS2103T` Edits the tag of the 2nd contact to only contain the module CS2103T tag.

#### Locating contacts by name: `find`

Finds the contacts whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)
  
#### Sort contacts by name: `sort`

Dislike how the current list of contacts is displayed? Sort the names in alphabetical order by typing a single `sort` word on the command line.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Do you wish to get back to the previous list? No worries, this sorted list is not permanent! Simply enter `list` on the command line to get back to the chronological order.
</div>
 
**Format:** `sort`
 
**Step-By-Step Guide:**

Step 1: Key in the `sort` command.
![SortContactCommand Step 1](images/SortCommandGuide1.png)

Step 2: Hit enter and the list with all the contact names sorted will be displayed immediately as shown.
![SortContactCommand Step 2](images/SortCommandGuide2.png)


#### Deleting a contact : `delete`

Deletes the specified contact from the person list.

Format: `delete INDEX`

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd contact in the person list.
* `find Betsy` followed by `delete 1` deletes the 1st contact in the results of the `find` command.

### Tag Features

#### Adding a tag : `tagadd`

Adds a tag to the tag list.

Format: `tagadd t/TAG`

* Creates a specified tag without the need of a contact.
* Tag will not be created if it already exists in the tag list.

Examples:
* `tagadd t/CS2103T` creates a tag named CS2103T without assigning to any contact

#### Listing all tags: `taglist`

Want to see all the tags you have added? Display them with simply the `taglist` command.

**Format:** `taglist`
 
**Step-By-Step Guide:**

Step 1: Key in the `taglist` command.
![TagListCommand Step 1](images/TagListCommandGuide1.png)

Step 2: Hit enter and the list with all the tags that you have added will be displayed immediately as shown.
![TagListCommand Step 2](images/TagListCommandGuide2.png)

#### Editing a tag : `tagedit`

Edits an existing tag in the tag list.

Format: `tagedit INDEX t/tag`

* Edits the tag at the specified `INDEX`. The index refers to the index number shown in the displayed tag list. The index **must be a positive integer** 1, 2, 3, …​
* All users tagged with the original tag will have their tag renamed.

Examples:
*  `tagedit 1 t/CS2101` Edits the original tag in index 1 in the tag list to `CS2101`. All users will have the old tag edited to be `CS2101`.

#### Locating tags by name: `tagfind`

Finds the tags whose names contain any of the given keywords.

Format: `tagfind KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `friends` will match `Friends`
* The order of the keywords does not matter. e.g. `Team1 GroupA` will match `GroupA Team1`
* Only the name is searched.
* Only full words will be matched e.g. `Team` will not match `Team1`
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Team A` will return `Team B`, `Group A`

Examples:
* `tagfind Group` returns `group` and `Group A`
* `tagfind Team B` returns `Team A`, `Group B`<br>

#### Deleting a tag: `tagdelete`

Deletes the specified tag in the tag list.

Format: `tagdelete INDEX`

* Deletes the tag with the index `INDEX` from the tag list.
* The tag will also be removed from the contact(s) that contain(s) the tag.

Example:
* `tagdelete 1` deletes the tag with the index 1 in the tag list.

#### Exiting the program : `exit`

Exits Projact application.

Format: `exit`

#### Saving the data

Projact data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL ta/TELEGRAM_ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com ta/jamesHO t/CS2101 t/CS2103T`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [ta/TELEGRAM_ADDRESS] [t/TAG]…​`<br> e.g., `edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**Tag Add** | `tagadd t/TAG`<br> e.g., `tagadd t/CS2103T`
**Tag Delete**| `tagdelete INDEX` <br> e.g., `tagdelete 1`
**Tag Edit**| `tagedit INDEX t/TAG` <br> e.g., `tagedit 1 t/CS2101`
**Tag List** | `taglist`
**Tag Find** | `tagfind  KEYWORD [MORE_KEYWORDS]`<br> e.g., `tagfind friends colleagues`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Projact home folder.


