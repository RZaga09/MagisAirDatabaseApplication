# GIT Conventions
## Brief Introduction
To standardize our git commit messages, I decided to write down some guidelines on git conventions to ensure consistency, readability, and more importantly informative.

I'm writing this because the last time I worked with commit messages, they were bad in explaining in exactly what changes were made with each commit. Hopefully this time the commit messages will be more informative and useful in informing what changes were made this time around. This can also be good practice if we find ourselves working in a company that uses git and requires us to follow conventions.

## How to Write Commit Messages
### GIT Command
This will be the command we'll type whenever we are committing code to the centra repo.
> git commit -m "type  of  commit: brief  description" -m "detailed description"

### Type of Commit
Whenever writing a commit message, make sure that you note first what kind of commit you are making. Here's a list of commits we will expect while working with the repo:
1. `code`: The new feature you're adding to the project
2. `fix`: Any bug fixes
3. `style`: Feature and updates related to styling. Like GUI.
4. `refactor`: refactoring a something in the code
5. `test`: everything relatd to testing
6. `docs`: everything related to documentation
7. `clean`: if you cleaned up the database , rearranged files and folders, or generally did some cleaning to make the project look neat.
8. `others`: everything that does not fall under the above.

For example, if your commit is about adding a new feature then you start your message with:
> git commit -m "feat: "

### Message Body of Commit
When you have written down what kind of commit you're making, write a brief summary of what you wrote in no less than 50 characters. For example:
> git commit -m "feat: feat: added log-in functionality"

After that, write a more detailed description right afterwards.
> git commit -m "feat: feat: added log-in functionality" -m "Created a login.java file in the src folder. It can accept credentials, check if credentials are valid, and can either accept or reject the credentials."