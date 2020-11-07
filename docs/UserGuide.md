---
layout: page
title: User Guide
---
# Projact User Guide

## Table of Contents
* [Introduction](#introduction)
* [About the User Guide](#about-this-user-guide)
    * [Key Terms](#key-terms)
        * [Contacts](#what-are-contacts)
        * [Tags](#wait-what-are-tags)
        * [Tasks](#how-about-tasks)
        * [Meeting Links](#and-meeting-links)
        * [Index](#index) 
    * [Symbols](#symbols)
* [Quick Start](#quick-start)
* [Features](#features)
    * [General](#general-features)
    * [Contact](#contact-features)
    * [Tag](#tag-features)
        * [Link](#link-features)
        * [Task](#task-features)
* [Command Summary](#command-summary)
    * [General](#general-commands)
    * [Contact](#contact-commands)
    * [Tag](#tag-commands)
    * [Link](#link-commands)
    * [Task](#task-commands)
* [FAQ](#faq)

--------------------------------------------------------------------------------------------------------------------

## Introduction
Welcome to the *Projact User Guide*!

Projact is a **project and contact management app that helps NUS computing students to organise their fellow students' contacts and their teams' meeting links and tasks**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

The Projact application consists of a person list, which stores the contacts of the other computing students, and a tag list, which can store the tags of the modules that the current user is taking in this semester and even more!

--------------------------------------------------------------------------------------------------------------------

## About this User Guide
This user guide provides in-depth documentation on the features in Projact to facilitate the effective organisation of your contacts. In addition, the quick start guide provides an end-to-end setup process to get you started. 

A basic understanding of how the Command Line Interface works would be good. However, a lack of it would not affect your experience with Projact as prior technical experience is not required.

Before you go on, here are some key terms and symbols you should know!

### Key Terms

#### What are Contacts?
- People whose information you store inside Projact are known as contacts. 
- Contacts contain the following information:
    - Name
    - Phone number
    - Email address
    - Telegram address
- You can also tag your contacts!
   
#### Wait, what are Tags?
- Tags are extremely customizable labels you can use to help organise your contacts. 
- Each contact can have any number of tags, from 0 to any number you assign it!
- Tags can store the following information:
    - Tasks
    - Links

#### How about Tasks?
- Ever forget what to-dos have been allocated to your project mates? Keep track of them by storing the to-dos as Tasks in Projact!
- Tasks are stored under a tag so you can easily categorise them.
- Whenever you or your project mates are done with their tasks, you can easily check them off and feel accomplished!

#### And Links?
- There are so many links floating around now and it's tough to keep track of them all. But don't worry, we've got your back!
- The link will be stored under a tag so it's easy to know what it's for. 

#### Index?
- Index refers to the contact's or tag's position in its list. You will need this to use many of the commands! But fret not, it's really easy to identify the index of your desired contact or tag. Find out more about this later on in the User Guide!

### Symbols

<!--suppress HtmlUnknownAttribute -->
<div markdown="block" class="alert alert-info">

#### <div> :information_source: </div> 
- This information symbol signals that there are things you should take note of! 

#### <div> :bulb: </div>
- The light bulb symbol will show you a tip to make your Projact experience smoother.

#### <div> :exclamation: </div>
- The exclamation mark symbol is a warning for any side effects that may result from the command, or any other important information you should know before you proceed.
</div>

Now you're prepared to embark on this journey and have Projact manage your contacts and projacts.

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer. Click [here](https://phoenixnap.com/kb/check-java-version-on-m…) to check if you have the correct version of Java installed. 

1. Download the latest `projact.jar` from [here](https://github.com/AY2021S1-CS2103T-T17-4/tp/releases/download/v1.3/projact.jar).

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
  
* `INDEX` refers to the contact's position in `list` or the tag's position in `taglist`.

</div>

### General Features

#### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

#### Clearing all entries : `clear`

Clears all contact entries from the person list in Projact.

Format: `clear`

#### Exiting the program : `exit`

Exits Projact application.

Format: `exit`

#### Saving the data

Projact data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

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

Made a mistake while adding tags? We got you! Here's a simple `tagedit` command to quickly fix your typos.

**Format**: `tagedit INDEX t/TAG_NAME`

**Step-By-Step Guide:**

Step 1: Key in `taglist` and hit enter to display all the tags. Then, scroll until you find the tag you want to edit.
![TagEditCommand Step 1](images/TagEditCommandGuide1.png)

Step 2: For example, if you want to change the name of the `family` tag to `brother`, then key in `tagedit 4 t/brother` and hit enter.
![TagEditCommand Step 2](images/TagEditCommandGuide2.png)

Step 3: You should see the tag's name being edited. Everyone who had the old tag will also have it renamed.
![TagEditCommand Step 3](images/TagEditCommandGuide3.png)

<div markdown="block" class="alert alert-info">
**:information_source: Take note:**<br>
* The index **must be a positive integer** 1, 2, 3, …​
</div>

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

#### Sorting tags by tag name: `tagsort`

Dislike how the current list of tags is displayed? Sort the tags by their names in alphabetical order by typing a single `tagsort` word on the command line.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Do you wish to get back to the previous tag list? No worries, this sorted tag list is not permanent! Simply enter `taglist` on the command line to get back to the chronological order.
</div>

**Format:** `tagsort`
 
**Step-By-Step Guide:**

Step 1: Key in the `tagsort` command.
![TagSortCommand Step 1](images/TagSortCommandGuide1.png)

Step 2: Hit enter and the list with all the tag names sorted will be displayed immediately as shown.
![TagSortCommand Step 2](images/TagSortCommandGuide2.png)

#### Deleting a tag: `tagdelete`

Want to get rid of a particular tag? Use the `tagdelete` command follow by the index `INDEX` of that tag from the tag list.

<div markdown="span" class="alert alert-primary">:exclamation: **Warning:**
The tag will also be removed from the contact(s) that contain(s) the tag.
</div>

**Format:** `tagdelete INDEX`

**Step-By-Step Guide:**

Step 1: First key in `taglist` and hit enter to display all the tags.
![TagDeleteCommand Step 1](images/TagDeleteCommandGuide1.png)

Step 2: For example, if you want to remove the "family" tag, key in `tagdelete 5` and hit enter.
![TagDeleteCommand Step 2](images/TagDeleteCommandGuide2.png)

Step 3: You should see the updated tag list without the "family" tag.
![TagDeleteCommand Step 3](images/TagDeleteCommandGuide3.png)

### Link Features

#### Adding a link under a tag: `linkadd`

This command ties a link to a specified tag. It will come in handy if you have group projects where you have a permanent platform that your group meets on (E.g. Zoom, Skype). However, do note that there can only be one link per tag.

**Format:** `linkadd INDEX l/LINK`

**Step-By-Step Guide:**

Step 1: First key in `taglist` and hit enter to display all the tags.
![LinkAddCommand Step 1](images/LinkAddCommandGuide1.png)

Step 2: For example, if you want to add a Skype meeting link to the "CS2103Project" tag, key in `linkadd 6 l/https://skype.com/cs2103proj/` and hit enter.

<div markdown="span" class="alert alert-primary">:exclamation: **Warning:**
Ensure that the link provided starts with either "https://" or "http://" and has top level domains such as ".com" and ".org".
</div>

![LinkAddCommand Step 2](images/LinkAddCommandGuide2.png)

Step 3: You should see the link being added to the "CS2103Project" tag like this. 
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Click on the link to be redirected to your browser!
</div>

![LinkAddCommand Step 3](images/LinkAddCommandGuide3.png)

#### Deleting the link under the tag: `linkdelete`

Want to get rid of the link under a particular tag? Use the `linkdelete` command followed by the index `INDEX` of that tag from the tag list.
 
**Format:** `linkdelete INDEX`

**Step-By-Step Guide:**

Step 1: First key in `taglist` and hit enter to display all the tags.
![LinkDeleteCommand Step 1](images/LinkDeleteCommandGuide1.png)

Step 2: For example, if you want to remove the link from the "classmates" tag, key in `linkdelete 3` and hit enter.
![LinkDeleteCommand Step 2](images/LinkDeleteCommandGuide2.png)

Step 3: You should see the link being removed from the "classmates" tag like this.
![LinkDeleteCommand Step 3](images/LinkDeleteCommandGuide3.png)

### Task Features

#### Adding a task: `taskadd`

Is there a specific task you want to add to a tag? Simply use the `taskadd` command followed by the index of that tag, and the name of the task!

**Format:** `taskadd INDEX task/TASK_NAME`

* Adds a task to the tag with the `INDEX` from the current view of the tag list after doing `taglist`.
* Task will not be added if specified tag with `INDEX` already has a task with the same task name.

<div markdown="block" class="alert alert-info">

**:information_source: Maximum number of tasks in each tag:**<br>

* Only a maximum of 26 tasks can be added, due to the alphabet being used as an index.

* Attempts to add additional tags after 26 will result in an error.<br>
  i.e. Unable to add new tasks after the task with index `z`.

</div>

Example:
* `taskadd 2 task/peer review` adds a task to the tag with the index 2 in the current tag list.

#### Marking a task under a tag as done: `taskdone`

After adding a task to your targeted tag, you must have seen the cross beside the task description. So how to mark the 
task as done once you have completed the task? Use `taskdone` followed by the index `INDEX` of the tag and 
the alphabetical index `ALPHAINDEX` to do the magic!

**Format:** `taskdone INDEX ALPHAINDEX`

**Step-By-Step Guide:**

Step 1: First key in `taglist` and hit enter to display all the tags.
![TaskDoneCommand Step 1](images/LinkDeleteCommandGuide1.png)

Step 2: For example, if you want to mark the second task under the tag "CS2101" as done. Key in "taskdone 2 b" and hit enter.
![TaskDoneCommand Step 2](images/TaskDoneCommandGuide2.png)

Step 3: You should see the task "complete user guide" have a tick beside it.
![TaskDoneCommand Step 3](images/TaskDoneCommandGuide3.png)

#### Deleting a task: `taskdelete`

Are the tasks added no longer needed? Or perhaps you accidentally added the wrong task to the wrong tag? Worry not! Use the `taskdelete` command followed by the index of that tag, and the alphabetical index of the task!

**Format:** `taskdelete INDEX ALPHAINDEX`

* Deletes a task to the tag with the `INDEX` from the currrent view of the tag list (either tagsort or taglist).

Example:
* `taskdelete 1 b` deletes the task with the alphabetical index b from the tag with the index 1 in the current tag list.

--------------------------------------------------------------------------------------------------------------------

## Command summary

### General commands

Action | Format, Examples
--------|------------------
**Help** | `help`
**Clear** | `clear`
**Exit** | `exit`

### Contact commands

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL ta/TELEGRAM_ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com ta/jamesHO t/CS2101 t/CS2103T`
**List** | `list`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [ta/TELEGRAM_ADDRESS] [t/TAG]…​`<br> e.g., `edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**Sort** | `sort`
**Delete** | `delete INDEX`<br> e.g., `delete 3`

### Tag commands

Action | Format, Examples
--------|------------------
**Tag Add** | `tagadd t/TAG`<br> e.g., `tagadd t/CS2103T`
**Tag List** | `taglist`
**Tag Edit**| `tagedit INDEX t/TAG_NAME` <br> e.g., `tagedit 1 t/CS2101`
**Tag Find** | `tagfind  KEYWORD [MORE_KEYWORDS]`<br> e.g., `tagfind friends colleagues`
**Tag Sort** | `tagsort`
**Tag Delete**| `tagdelete INDEX` <br> e.g., `tagdelete 1`

### Link commands

Action | Format, Examples
--------|------------------
**Link Add** | `linkadd INDEX l/LINK` <br> e.g, `linkadd 2 l/https://skype.com/cs2103proj/`
**Link Delete** | `linkdelete INDEX`<br> e.g., `linkdelete 1`

### Task commands

Action | Format, Examples
--------|------------------
**Task Add** | `taskadd INDEX task/TASK_NAME`<br> e.g., `taskadd 1 task/peer review`
**Task Delete** | `taskdelete INDEX ALPHAINDEX`<br> e.g., `taskdelete 1 b`
**Task Done** | `taskdone INDEX ALPHAINDEX`<br> e.g., `taskdone 1 c`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Copy all the current files generated by the application, together with `projact.jar` file and paste in an empty folder 
in the other computer. The data should remain the same as it was in your previous computer.

**Q**: I have tried double-clicking the `projact.jar` file but the application does not open. <br>
**A**: Please ensure that you have loaded the `projact.jar` file from our latest release on our github website. 
A temporary solution could be to open your Command Prompt (Windows OS) or terminal (MacOS) and key in `java -jar <path_of_file>`. 
For example, `java -jar C:\Users\name\projact\projact.jar`. We understand that this may be troublesome over time, so please 
drop an email at siqiang@comp.nus.edu.sg or raise an issue on our github page.

