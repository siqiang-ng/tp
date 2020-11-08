---
layout: page
title: Yeo Ke Xin's Project Portfolio Page
---

### Project: Projact 
Projact is a contact and project management app that helps NUS computing students to organise their contacts and their projects' meeting links and tasks.
 
Given below are my contributions to the project.

#### New Features
* **Feature**: Command to edit Tag's names. (Pull request [\#109](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/109))
  * What it does: allows the user to change the name of a tag for all its occurrences. 
  * Highlights: This implementation was challenging as it had to make changes to every contact with the edited Tag's previous name. 
  * Justification: This feature significantly improves the user experience by providing an easy way for the user to quickly correct their mistakes.

* **Feature**: JSON Storage for Tags with their names, tasks and meeting links. (Pull requests [|#109](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/109), [\#142](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/142))
  * What it does: allows the user's data to be saved and reloaded upon the next usage of the app.
  * Highlights: This feature affects existing and future tag commands. 

* **Feature**: Command to clear all completed tasks from a Tag. (Pull request [\#224](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/224))
  * What it does: allows the user to delete all completed tasks from a Tag.  
  * Justification: This feature makes it more convenient for the user by providing a command to mass delete completed tasks from a Tag.
  
#### Enhancements to Existing Features
* **Enhancement**: New Telegram Address field in Person's model. (Pull requests [\#68](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/68), [\#209](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/209))
  * What it does: Allows the user to store a person's telegram address.
  * Justification: This feature improves the product as it allows the user to store a more relevant way to contact someone.
  * Highlights: This enhancement affects existing contact commands.

* **Enhancement**: Removed Address field in Person's model. (Pull request [\#68](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/68))
  * Justification: It is uncommon for our target users to know their fellow acquaintances' address or need to save them.

* **Enhancement**: Refined regex for valid emails. (Pull request [\#218](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/218))

* **Enhancement**: Edited ModelManager and Tag's model to support new features. (Pull requests [\#109](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/109), [\#113](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/113))
  * Highlights: This enhancement affects existing contact, tag, link and task commands.

* **Enhancement**: Edited existing commands to update Tag's UI. (Pull requests [\#113](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/113), [\#135](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/135))
  * Highlights: This enhancement was difficult as it required modifying existing commands and ensuring current features would not fail.

* **Enhancement**: Improved the GUI by adding icons and removed blank spaces when fields are missing. (Pull request [\#216](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/216))
  * Credits: Used [FontAwesome5](https://github.com/kordamp/ikonli) for the icons.
 
#### Code Contributed
* [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=pockii)

#### Project Management
* Managed the issue tracker for v1.2
* Created the demo screenshots to be shown for v1.3

#### Documentation    
* **User Guide**:
    * Improved wording for Introduction and explained the application's name. (Pull request [\#222](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/222))
    * Added explanation for key terms and symbols to help new users navigate the user guide.(Pull requests [\#147](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/147), [\#222](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/222))
    * Edit UG's format. (Pull request [\#111](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/111))
    * Documented new features `tagedit` and `taskclear`. (Pull requests [\#146](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/146))
    * Improved wording on existing documentation of features `list`. (Pull request [\#]())
    
* **Developer Guide**:
    * Updated UML diagrams for Model and Storage. (Pull request [\#]())
    * Added implementations and use cases of `tagedit` and `taskdone` feature. (Pull requests [\#146](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/146), [\#]())

#### Community    
* PRs reviewed (with non-trivial review comments): (Pull request [\#69](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/69), [\#116](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/116), [\#118](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/118), [\#119](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/119), [\#139](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/139), [\#249](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/249))

#### Tools
* Integrated a third party library (FontAwesome5) to the project (Pull request [\#216](https://github.com/AY2021S1-CS2103T-T17-4/tp/pull/216))


