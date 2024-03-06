# GitLab repository for CO2201 Group Projects

## Please update this readme file with installation instructions as soon as is possible

## Introduction: 

The following steps describes the installation of the project in both
operating systems Windows and Linux. We recommend running the
application on windows.


## Install Java Development Kit (JDK 17):

Here is a step-by-step guide to installing Java Development Kit (JDK 17)
on a Windows machine:

1.  Go to the Oracle website:
    <https://www.oracle.com/java/technologies/downloads/>

2.  Click on the \"JDK Download\" button under the \"Java SE 17\"
    section.
3.  On the next page, accept the license agreement and click on the
    appropriate download link for your operating system.
4.  Once the download is complete, double-click on the downloaded file
    to start the installation process.
5.  Follow the prompts in the installation wizard to complete the
    installation.
6.  Once the installation is complete, open a command prompt or terminal
    window and type \"java -version\" to verify that Java has been
    installed correctly. You should see output that includes the version
    number of the JDK you just installed.
Congratulations, you have successfully installed Java Development Kit
    (JDK 17) on your machine!


Here is a step-by-step guide to installing Java Development Kit (JDK 17)
on a Linux machine:

1.  Open a terminal window.
2.  Update the system package cache by running the following command:
    -   sudo apt-get update
3.  Install the OpenJDK 17 package by running the following command:
    -   sudo apt-get install openjdk-17-jdk
4.  Verify the installation by running the following command:
    -   java -version
    -   This command displays the installed Java version information.

Congratulations, you have successfully installed Java Development Kit
    (JDK 17) on your Linux machine!

## Install JetBrains IntelliJ IDEA Ultimate:  
Here is a step-by-step guide to installing JetBrains IntelliJ IDEA Ultimate on a Windows machine: 

1. Go to the JetBrains website: https://www.jetbrains.com/idea/download/ 
2. Click on the "Download" button under the "Ultimate" edition. 
3. Choose the appropriate download link for your operating system. 
4. Once the download is complete, double-click on the downloaded file to start the installation process. 

5. Follow the prompts in the installation wizard to complete the installation. 

6. When prompted to select the installation options, make sure to select the "Create desktop shortcut" and "Create associations for .java files" options. 

7. Once the installation is complete, launch IntelliJ IDEA by double-clicking on the desktop shortcut. 

8. When prompted to import settings, choose the "Do not import settings" option and click on "OK". 

9. On the welcome screen, click on "Create New Project". 

10. Choose the appropriate project type and settings for your project and click on "Finish". 

Congratulations, you have successfully installed JetBrains IntelliJ IDEA Ultimate on your machine and created a new project! 



 

Here is a step-by-step guide to installing JetBrains IntelliJ IDEA Ultimate on a Linux machine: 

1. Go to the JetBrains website: https://www.jetbrains.com/idea/download/ 
2. Click on the "Download" button under the "Ultimate" edition. 
3. Choose the appropriate download link for your operating system. 
4. Once the download is complete, extract the downloaded archive to a directory of your choice. You can do this by right-clicking on the archive and selecting "Extract Here" or by running the following command in the terminal: 
   - ‘tar xfz \<intellij-idea-ultimate-edition\>.tar.gz’ 
   - Replace \<intellij-idea-ultimate-edition\> with the actual name of the downloaded archive. 
5. Navigate to the extracted directory using the terminal: 
    -  ‘cd \<intellij-idea-ultimate-edition\>’ 
   - Replace \<intellij-idea-ultimate-edition\> with the actual name of the extracted directory. 

1. Launch IntelliJ IDEA by running the following command in the terminal: 
   - ‘bin/idea.sh’ 

2. When prompted to import settings, choose the "Do not import settings" option and click on "OK". 

3. On the welcome screen, click on "Create New Project". 

4. Choose the appropriate project type and settings for your project and click on "Finish". 

Congratulations, you have successfully installed JetBrains IntelliJ IDEA Ultimate on your Linux machine and created a new project! 


## Install MySQL Server 8: 
Here is a step-by-step guide to installing MySQL Server 8 on a Windows
machine:

1.  Go to the MySQL website: <https://dev.mysql.com/downloads/mysql/>
2.  Scroll down to the \"MySQL Community Server\" section and click on
    the \"Download\" button.
3.  On the next page, scroll down to the \"Looking for previous GA
    versions?\" section and click on \"Looking for previous GA
    versions?\".
4.  Click on \"MySQL Server 8.0.28\" to download the appropriate
    installer for your system.
5.  Once the download is complete, double-click on the downloaded file
    to start the installation process.
6.  Follow the prompts in the installation wizard to complete the
    installation.
7.  When prompted to select the setup type, choose \"Custom\" and select
    the components you want to install.
8.  On the \"Type and Networking\" screen, select \"Server Only\" and
    choose a port for the MySQL server.
9.  On the \"Authentication Method\" screen, choose the \"Use Strong
    Password Encryption\" option and set a password for the root user.
10. Complete the installation process and launch the MySQL Command Line
    Client.
11. Log in to the MySQL server using the following command:
    -   'mysql -u root --p\'
12. Enter the password you set for the root user when prompted.

Congratulations, you have successfully installed MySQL Server 8 on your
Windows machine!

Here is a step-by-step guide to installing MySQL Server 8 on a Linux
machine:

1.  Open a terminal window.
2.  Add the MySQL repository to your system by running the following
    command:
    -   sudo wget
        <https://dev.mysql.com/get/mysql80-community-release-el8-1.noarch.rpm>
    -   This command downloads the MySQL 8 repository configuration package 
    for CentOS 8. If you\'re using a different Linux distribution,
    replace the file name accordingly.

3.  Install the repository package by running the following command:
    -   'sudo rpm -ivh mysql80-community-release-el8-1.noarch.rpm'
    -   This command installs the repository configuration package.

4.  Update the system package cache by running the following command:
    -   'sudo apt makecache'
    -   This command refreshes the system package cache with the newly  added MySQL repository.

5.  Install MySQL Server 8 by running the following command:
    -   'sudo apt install mysql-server\'
    -   This command installs the MySQL Server 8 package and its
        dependencies.

6.  Start the MySQL service by running the following command:
    -   'sudo systemctl start mysqld'
    -   This command starts the MySQL service.

7.  Secure the MySQL installation by running the following command:
    -   'sudo mysql_secure_installation'\
        This command prompts you to set a root password, remove anonymous
        users, disallow root login remotely, and remove the test database.
        Follow the prompts to secure your MySQL installation.

8.  Log in to the MySQL server using the following command:
    -   'mysql -u root --p'

9.  Enter the password you set for the root user when prompted.

Congratulations, you have successfully installed MySQL Server 8 on your
Linux machine!



## Create a database: 
This step describes the same process for both Windows Operating System
and Ubuntu Linux.

1.  Log in to the MySQL server using the following command:
    -   'mysql -u root --p'

2.  Create a database called "PlacementTrackingSystem" using the
    following command :
    -   'CREATE DATABASE PlacementTrackingSystem;\'

    Notes: If the database names was changed the name need to be updated
    inside " resources/applicaton.properties".


## Configuring OKTA Login System: 

This file explains how to set up a new authentication application using
OKTA and adding users to it.

### Creating an OKTA account. 

To create an OKTA account first go to
<https://developer.okta.com/signup/> and file the prompted fields.



###  Creating an OKTA application. 

To create an okta application, go to OKTA main page as shown in Figure
2, https://dev-\<YOUR UNIQUE
NUMBER\>-admin.okta.com/admin/getting-started, then open the
"Applications" branch at the left of main page and choose "Applications".


After that, click on "Create App Integration" then select "OIDC - OpenID
Connect" and "Web Application" as the application type as Shown in

Choose an "App integration name" and click on save as shown in Figure 5.

### Integrate the new APP integration into OKTA

In order to add the new app integration, open the "application.
properties" located in the resource folder
(resources/application.properties).


At the end, replace the issuer, client-id and client-secret with the new
configuration found in the application page.

## Downloading and building the project
1. Open a terminal or a command prompt on your computer (in this case, **GitBash** as we are working on the windows operating system) 
2. Navigate to the directory where you would like to clone the repository to, you may use the “cd” command to navigate to the specific directory. 
3. Use ‘git clone’ command to clone the repository, like this ‘git clone https://campus.cs.le.ac.uk/gitlab/co2201-2023/group-14’  
4. Once successful you may go to that directory and there should be a folder titled ‘group-14’ 
5. Open the ‘group-14’ folder, and there should exist a folder named “**PlacementTrackingSystem**”. The directory of this folder is important and will be relavant in the later steps.
6. Open IntelliJ IDEA Ultimate.
    1. If you are greeted with the welcome screen, click on Open Project then navigate to the directory and select the “**PlacementTrackingSystem**” 
    2. If you are greeted with an open project, for example, the IDE, you may click on <br> File (can be found in the menu bar) -> Open then navigate to the directory where the **PlacementTrackingSystem** folder is, select that folder. Click on Open.
7. You shall see the following figure if all the steps have been followed correctly <br>
![Figure 8](/Additional Documents/installationDocuments/FIG8.png)
8. Looking at the bottom right of the screen (as indicated below), we can see that we are in the main branch, which is the correct branch. <br>
![Figure 9](/Additional Documents/installationDocuments/fig9.jpg)

## Running the project
Go ahead and click on the run icon on the top right of the screen.<br>
![Figure 10](/Additional Documents/installationDocuments/fig10.png)

You may visit localhost:8080 to view the web application running live.


