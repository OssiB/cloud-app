# How to test MapReduce programs with MRUnit

### Requirements
* Maven
* Eclipse


Clone repo
````sh
$ git remote add origin https://github.com/OssiB/cloud-app.git
````
Make  a directory *src/main/java* and copy all the source files to this directory.
Uncomment *Pair* class from  java files and create a new *Pair* class  with the same content.
Run 
````sh
mvn eclipse:eclipse
````
There is  a test class *TestTitleCounterMapper* which you can use as a starting point with your own tests.
When you will submit your exercise remember to uncomment *Pair* class.

