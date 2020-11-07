---
layout: page
title: Yeo Ke Xin's Project Portfolio Page
---

## Project: Projact

Projact is a **project management app that helps NUS computing students to organise their fellow computing students' contacts and their teams' meeting links and tasks**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

Given below are my contributions to the project.

### New Features
* **Feature**: Added the ability to edit Tag's names.
  * What it does: allows the user to change the name of a tag for all its occurrences. 
  * Highlights: This implementation was challenging as it had to make changes to every contact with the edited Tag's previous name. 
  * Justification: This feature significantly improves the user experience by providing an easy way for the user to quickly correct their mistakes.

* **Feature**: Added the ability to store Tags with their names, tasks and meeting links in JSON. (Pull request [\#142](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/142))
  * What it does: allows the user's data to be saved and reloaded upon the next usage of the app.
  * Highlights: This feature affects existing and future tag commands. 

* **Feature**: Added the ability to clear all completed tasks from a Tag.
  * What it does: allows the user to delete all completed tasks from a Tag.  
  * Justification: This feature makes it more convenient for the user by providing a command to mass delete completed tasks from a Tag.
  
### Enhancements to Existing Features
* **Enhancement**: Added a new field in Person's model to store Telegram address. (Pull requests [\#68](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/68), [\#209](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/209))
  * What it does: Allows the user to store a person's telegram address.
  * Justification: This feature improves the product as it allows the user to store a more relevant way to contact someone.
  * Highlights: This enhancement affects existing contact commands.

* **Enhancement**: Removed the address field in Person's model. (Pull request [\#68](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/68))
  * Justification: It is uncommon for our target users to know their fellow acquaintances' address or need to save them.

* **Enhancement**: Refined the regex for valid emails. (Pull request [\#218](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/218))
  
* **Enhancement**: Edited ModelManager, along with the Tag's model to support the new features. (Pull requests [\#109](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/109), [\#113](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/113))
  * Highlights: This enhancement affects existing contact, tag, link and task commands.

* **Enhancement**: Edited existing commands to work with the new Tag features and model. (Pull requests [\#113](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/113), [\#135](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/135))
  * Highlights: This enhancement was difficult as it required modifying existing commands and ensuring that current features would not fail.

* **Enhancement**: Improve the GUI by adding icons and removing blank spaces when fields are missing. (Pull request [\#216](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/216))
  * Credits: Used [FontAwesome5](https://github.com/kordamp/ikonli) for the icons.
 
### Code Contributed
* [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=pockii)

### Project Management
* Managed the issue tracker for v1.2
* Created the demo screenshots to be shown for v1.3

### Documentation    
* **User Guide**:
    * Improved wording for Introduction and added a brief explanation for the application's name.
    * Added explanation for key terms and symbols to help new users navigate the user guide.(Pull requests [\#147](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/147))
    * Edit format of UG to better group features (Pull request [\#111](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/111))
    * Added documentation of new features `tagedit` and `taskclear`. (Pull requests [\#146](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/146))
    * Improved wording on existing documentation of features `list`. 
    
* **Developer Guide**:
    * Added implementation details of the `tagedit` feature.

### Community    
* PRs reviewed (with non-trivial review comments): (Pull request [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116), [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139))

### Tools
* Integrated a third party library (FontAwesome5) to the project (Pull request [\#216](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/216))


