---
layout: page
title: Ng Si Qiang's Project Portfolio Page
---

## Project: Projact

Projact is a **project management app that helps NUS computing students to organise their fellow computing students' contacts and their teams' meeting links and tasks**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

### New Features
* **Feature**: Added the command to list the tag list. (Pull request [\#57](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/57))
  * What it does: allows the user to list all the tags that have been created. 
  * Justification: This feature allows the user to keep track of all the tags that have been added and allows extensions of the tag features.
  * Highlights: This enhancement affects the tag commands which can be extended further in the future. The implementation affects the display of the
  original commands and hence the design has to be analyzed to 

* **Feature**: Added the commands to sort the list of contact names and the list of tag names. 
(Pull requests [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116), [\#120](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/120),
[\#223](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/223))
  * What it does: allows the user to sort the contact names in the person list or the tag names in the tag list based on numbers then in alphabetical order. 
  * Justification: This feature allows the user to change how the contacts and tags are viewed in the list based on their personal preference.  
  * Highlight: This implementation was challenging because it uses SortedList, rather than the Filtered List which is used in AB3. 
    It also affects the original commands such as edit and delete commands so there are many design considerations required.
  
* **Feature**: Added the command to delete the link in a tag. (Pull request [\#138](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/138))
  * What it does: allows the user to remove the link added to a tag.
  * Justification: This feature improves the product as the user is able to add a link and needs a way to remove the link from the tag as well.
  
* **Feature**: Added the command to mark a task's status in a tag as done. 
(Pull requests [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139), [\#204](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/204))
  * What it does: allows the user to mark a task in the task list of a tag as done.
  * Justification: This feature allows the user to keep track of the progress of the tasks added to each tag. 
  * Highlight: This implementation was challenging because there was no similar commands in the original AB3 and new methods have to be created in the Index and 
  ParserUtil classes to parse the inputs.
  
* **Feature**: Added the UI to display the tasklist in each tag. (Pull request [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139))
  * What it does: allows the user to view the tasklist under each tag.
  * Justification: This feature allows the user to view the tasks under each tag.
 
### Enhancements to Existing Features
* **Enhancement**: Wrote additional tests for existing features to increase coverage 
 (Pull requests [\#57](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/57), [\#70](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/70),
 [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116), [\#120](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/120), 
 [\#138](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/138), [\#204](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/204), 
 [\#230](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/230))
 
### Code Contributed
* [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=siqiang-ng)

### Project Management
* Wrapped up all the milestones and managed releases `v1.2` - `v1.4` (3 releases) on GitHub
* Changed the product icon (Pull request [\#210](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/210))
* Maintained the issue tracker from time to time

### Documentation    
* **User Guide**:
    * Added documentation for the features `taglist`, `sort`, `tagsort`, `taskdone`, `linkdelete` 
    (Pull requests [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116), 
    [\#120](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/120), [\#138](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/138),
    [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139))
    * Edited documentation for the features `find` and `delete` (Pull request [\#235](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/235))
    * Updated the FAQ section (Pull request [\#215](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/215))
* **Developer Guide**:
    * Created the Table of Contents (Pull request [\#76](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/76))
    * Added the use case for creating a tag (Pull request [\#19](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/19))
    * Wrote the Product Scope (Pull request [\#19](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/19))
    * Maintain the User Stories (Pull requests [\#19](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/19), 
    [\#133](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/133))
    * Added implementation details and the UML diagrams of the `taglist`, `sort`, `tagsort`, `taskdone`, `linkdelete` features 
    (Pull requests [\#98](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/98), [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116),
     [\#120](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/120), [\#138](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/138),
     [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139))

### Community    
* PRs reviewed (with non-trivial review comments): [\#65](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/65), 
[\#118](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/118), 
[\#145](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/145), [\#219](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/219), 
[\#222](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/222), [\#240](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/240),
[\#241](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/241)



