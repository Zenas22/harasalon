# HairSalon
This repository contains my Java application Hair salon that enables the owner of the salon to add, update and delete hair stylists and clients.

## Hair Salon Application

This is a repo containing a basic application that has been deployed to Heroku.

It is an application where users can:

1. Add a stylist using a form.
2. Add a client to the stylist using a form.
3. View all stylist and their current clients.
4. View all clients.
5. Delete the stylists or clients.


### Technologies used

Gradle (JUnit) - To test out the project
Intellij - To write the code
Postgres - To create a database
Heroku and maven - To deploy the Application

### Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


1. Download Intellij from https://www.jetbrains.com/idea/download/#section=linux

2. Visit my GitHub repository; User name Mbugua Mwaura and clone the following link: https://github.com/Zenas22/harasalon You can also download the files into you folder and unzip it to access the files.

3. Open the project with Intellij.

4. Type gradle run in order to run the app from your local machine. The port number will be 4567.

5. Install postgres as shown below:

 - sudo apt-get update

 - sudo apt-get install postgresql postgresql-contrib libpq-dev

 - Once it is done installing run

 - sudo -u postgres createuser --superuser $USER
to create super user. Enter your desire password when prompted. Navigate to your home directory and enter the following command to create the .psql_history in order to save your history:

touch .psql_history

Type psql on your terminal to connect to the server:

psql

6. Restore the database schema (tables and columns) by running the following commands:

###### CREATE DATABASE your_database_name

$ psql name_of_database < media.sql

notice that the second command is run in bash and not on psql

### Behaviour Driven Development (BDD)


|Behaviour                |Input Example	      |Output Example         |
|:-----------------------:|:---------------------:|:---------------------:|
|Input a Stylist	      |Stacy Nthenya	      |creates a stylist      |
|Creating a client	      |Glory Kioko	          |create a client        |
|Viewing all the stylists |click to view	      |outputs all stylist    |
|Viewing all clients	  |Click to view	      |outputs all client     |
|View clients of a stylist|Click to view clients  |clients for the stylist|


### Author
Zenas Muli

### Contact information: 
Phone Number: 0704832108 
Email: zenas2294@gmail.com

### License
MIT License

### Copyright (c) [2019] [Zenas Muli]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.}* Copyright (c) {2019} {Zenas Muli}
