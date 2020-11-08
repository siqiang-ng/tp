---
layout: page
title: Kyi Nuu Khin Khin's Project Portfolio Page
---

## Project: Projact

Projact is a **project management app that helps NUS computing students to organise their fellow computing students' contacts and their teams' meeting links and tasks**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

### New Features
* **Feature**: Added the ability to undo/redo previous commands.
  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: *{mention here if you reused any code/ideas from elsewhere or if a third-party library is heavily used in the feature so that a reader can make a more accurate judgement of how much effort went into the feature}*
  
* **Feature**: Added the ability to add tags.
  * What it does: allows the user to add a new tag with zero contacts in the tag. 
  * Justification: This feature allows for more flexibility of how the app is being used as users can create additional tags that may not necessarily be related to any contacts. A possible example might be the user having a `personal` tag, so that the user can add personal tasks and or meeting links to the task. 
  
* **Feature**: Added the ability to add tasks to tags.
  * What it does: allows the user to add tasks to tags one at a time.
  * Justification: This feature improves the product significantly because the functionality of tags has been greatly improved. Tags are now capable of storing more information, and tasks in particular can help the user be more organised.
  * Highlights: This enhancement was hard to implement as adding a task was more like editing a tag. Previous edit commands did not care about the previous entry, and merely overwrote them (such as tags being rewritten when user edits a contact). However for task related commands, it was necessary to edit the previous list of tasks, and this posed a challenge. We managed to solve this by introducing a new method that would work with the current implementation.

* **Feature**: Added the ability to delete tasks from tags.
  * What it does: allows the user to delete tasks from tags one at a time. This is done by using both the index of the tag and the index of the task.
  * Justification: This feature improves the product as the user can now delete tasks that they have either added accidentally or made a typo in.
  * Highlights: Similar to the above feature, we initially struggled with how to use the currently implemented model to add this new feature. However we managed to come up with a work around to the problem of finding the exact task to delete by implementing an alphabetical index, so that it would be easier to identify which index to delete.

### Enhancements to Existing Features
* **Enhancement**: Refactored the code to use terms specific to our app (Pull requests [\#53]())
    * Justification: This improved readability of code for other developers, as our app was adapted from an app called "AddressBook", which might be confusing for new developers unaware of this. Hence refactoring the code to use the term "Projact" instead of "AddressBook" in various files made the code more consistent.
* **Enhancement**: Fixed bug that resulted in text being cut off when it was longer than the result display box. (Pull requests [\#234]())

### Code Contributed
* [RepoSense link]()

### Project Management
* Aided in maintenance of issue tracker during `v1.1`

### Documentation    
* **User Guide**:
    * Added documentation for feature `tagedit` [\#29]()
    * Added documentation for the features `taskadd` and `taskdelete` [\#149]()
* **Developer Guide**:
    * Added implementation details of the `tagadd` feature [\#93]()
    * Added non-functional requirements [\#33]()
    * Formatted developer guide to ensure that there was a consistent format and style during `v1.3` [\#97]()

### Community    
* PRs reviewed (with non-trivial review comments): [\#27]()
