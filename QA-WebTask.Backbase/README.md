# HomeTask_Backbase
Cucumber+Maven+Selenium , Design production ready framework !


Tools and Technologies
======================
- Cucumber JVM
- Gherkin
- Java
- Maven
- JUnit
- TestNG
- Eclipse
- POM
- Testproject


Framework features
==================
- Behavioral Driven
- Production Ready
- Supports Parallel Execution
- Screenshot on Scenario Failure
- Integration with Cucumber-HTML-Reports Plugin
- Execution from Runner file or from Maven Command Line



Prerequisite
==================
Maven (For managing dependencies)
IntelliJ or Eclipse
Installation
==================
Install from git (using git clone)
Run "mvn clean test" from project directory




Setup automation project
==================
*. Checkout the project

*. Download and install JDK 1.8.

*. Add the environment paths

Type defaults write com.apple.finder AppleShowAllFiles YES in terminal to view hidden files

Alt+Right click on finder and click relaunch to activate changes

Navigate to your user's directory

If you don't have a .bash_profile file, you can create one by following these steps:
Start up Terminal
Type cd ~/ to go to your home folder
Type touch .bash_profile to create your new file.
Edit .bash_profile with your favorite editor (or you can just type open -e .bash_profile to open it in TextEdit.

Add the following to the bash_profile:
export JAVA_HOME=/Library/Java/JavaVirtualMachines/{jdk version}/Contents/Home/
export PATH=${JAVA_HOME}/bin:$PATH

*. Import the project in Eclipse/IntelliJ IDEA (using import from external model Gradle) and do a Gradle sync

*. Install Cucumber for Java plugin on the IDE(Eclipse/IntelliJ)
From the menu, select Eclipse IDEA -> 
Go to Help
Click on the eclipse marketplace
Search Cucumber and then Select Cucumber for Java and click install
You will have to restart Eclipse 


From the menu, select IntelliJ IDEA -> Preferences
Go to Plugins
Click Install JetBrains plugins
Select Cucumber for Java and click install
You will have to restart IntelliJ

*. Duplicate all .properties files from /src/test/resources/config/ into /src/test/resources/config/local/ and update the new files with the values specific to your machine (usually the same way you've set up Appium UI app).

*. Run tests

Right-click on a test class/feature file and select Run As cucumber or  click on the TestRuner class and Run as Junit


Note:
""I have synced my project on the Testproject.
you just need to download and install Testproject Agent and Run code and check result and reports""

- I have synced my project on the Testproject
- you just need to download and install the Test project Agent and Run the code and check results and reports
- I sent my username and password to the testproject
- 
- Steps:

- 1- Download and install the Test project Agent
- 2- Login and sync your agent with the testprogect
- 3- Click on the agent's tab(your agent status should be ready)
- 4- Click on the project tab
- 5-  On the right side "Jobs",  click on "..." and "Edit" buttons in the QA_Backbase_Task and "Next" button, and on the Select browsers tab, you should click on your ready agent and Next and Save.
- 6- Now you can run the code with click on the Run button(it is like the play button, on the left the "...")
- **** I describe all processes with screenshots.****