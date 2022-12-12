# Student ToDo:
1. Erstellen Sie einen fork von diesem Repository
2. Dieser fork sollte private sein
3. Fügen Sie in ihrem fork bzw. Repository die Lehrenden unter `Settings --> Collaborators` mit Lese- und Schreibrechten hinzu
4. Implementieren Sie das nachfolgende Beispiel und commiten Sie dieses in Ihr Repository
5. Pushen Sie Ihre Änderungen auf Ihr Repository
6. Klicken Sie [hier](https://itsp.htl-leoben.at/ci/view/all/job/%organisation%/job/%exercise-name%/job/master/build?delay=0sec), um Ihre Aufgabe abzugeben. Sie bekommen im Anschluss eine Mail mit dem Test und Compile Log. **Dies kann etwas dauern, bitte drücken Sie den Link nicht zu oft.**

## Änderungen in den eigenen Fork mergen (nur wenn nötig!)
Fügen Sie zunächst dieses Repository (das der Organisation) als weiteres remote Repository hinzu (Name: `upstream`)
```bash
git remote add upstream https://itsp.htl-leoben.at/git/%organisation%/%exercise-name%.git
```
Remote repository herunterladen
```bash
git fetch upstream
```
Merge durchführen
```bash
git merge upstream/master master -m "merge changes from upstream"
```

# Search UserShell

## Task
Imlement a Commandline Java App, which provides the following options:
1. **option `-init`**: init the database creating the User Table, reading the password.txt file and insert the data into the table (is implemented)
1. **option `-s`**: search option for a given user (use a fuzzy search - with `like`)
  - `-shell`: returns the shell of the user
  - `-home` : return the home directory of the user
  - `-all`: returns all the data stored for the user

Refactor the Name of the `Main` Class to `UserDataSearch`.

  The following examples how the usage of the executeable jar Application with option parameters:
  ```text
# init database and load passwordfile
java -jar UserDataSearch.jar -init password.txt

# search usershell  
java -jar UserDataSearch.jar -s -shell carl
usershell: /bin/bash
  ```

> **Attention:** If more then one user is returned, display only the usernames.


### Necessary maven `pom.xml`´ changes
- Add the **Maven Jar Plugin** to create a executeable Jar File.
- add the dependency for the **CLI Apache** library

## Used Libraries/Maven Plugins

- [Appache CLI](https://commons.apache.org/proper/commons-cli/)
- [Create Executeable Jar with Maven](https://www.baeldung.com/executable-jar-with-maven)
