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
  * Justification: This feature significantly improves the user experience by providing an easy way for the user to quickly correct their mistakes.

* **Feature**: Added the ability to store Tags with their names and tasks
  * What it does: allows the user's data to be saved and reloaded upon the next usage of the app.
  * Highlights: This enhancement affects existing and future tag commands.  
  
### Enhancements to Existing Features
* **Enhancement**: Added a new field in Person's model to store Telegram address
  * What it does: Allows the user to store a person's telegram address
  * Justification: This feature improves the product as iit allows the user to store a more relevant way to contact someone.
  * Highlights: This enhancement affects existing contact commands.

* **Enhancement**: Removed the address field in Person's model
  * Justification: It is uncommon for our target users to know their fellow acquaintances' address or need to save them.

* **Enhancement**: Edited the Tag's model to support our new features
  * Highlights: This enhancement affects existing contact, tag, link and task commands. It also provides a way to find all contacts with that tag.
 
### Code Contributed
* [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=pockii)

### Project Management

### Documentation    
* **User Guide**:
    * Added explanation for key terms and symbols to help new users navigate the user guide
    * Improved wording on existing documentation of features `tagedit`
* **Developer Guide**:
    * Added implementation details of the `tagedit` feature.

### Community    
* PRs reviewed (with non-trivial review comments):

### Tools


